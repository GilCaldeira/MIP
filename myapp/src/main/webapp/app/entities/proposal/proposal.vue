<template>
  <div>
    <h2 id="page-heading" data-cy="ProposalHeading">
      <span v-text="$t('myappApp.proposal.home.title')" id="proposal-heading">Proposals</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myappApp.proposal.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && proposals && proposals.length === 0">
      <span v-text="$t('myappApp.proposal.home.notFound')">No proposals found</span>
    </div>
    <div class="table-responsive" v-if="proposals && proposals.length > 0">
      <table class="table table-striped" aria-describedby="proposals">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.name')">Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.customerName')">Customer Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.customerEmail')">Customer Email</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.travelName')">Travel Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.travelStartDate')">Travel Start Date</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.travelEndDate')">Travel End Date</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.travelType')">Travel Type</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.suggestedAirlines')">Suggested Airlines</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.suggestedHotels')">Suggested Hotels</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.otherSuggestedTravelServices')">Other Suggested Travel Services</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.state')">State</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.customerFeedback')">Customer Feedback</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.examplesOtherTravelServices')">Examples Other Travel Services</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.airlineTicketNumber')">Airline Ticket Number</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.hotelBookingNumber')">Hotel Booking Number</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.carBookingNumber')">Car Booking Number</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.carRentalIncluded')">Car Rental Included</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.applicationUserName')">Application User Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.applicationPassword')">Application Password</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.customer')">Customer</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.travelPlan')">Travel Plan</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.airlineCompany')">Airline Company</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.hotel')">Hotel</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.rentalCarCompany')">Rental Car Company</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="proposal in proposals" :key="proposal.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProposalView', params: { proposalId: proposal.id } }">{{ proposal.id }}</router-link>
            </td>
            <td>{{ proposal.name }}</td>
            <td>{{ proposal.customerName }}</td>
            <td>{{ proposal.customerEmail }}</td>
            <td>{{ proposal.travelName }}</td>
            <td>{{ proposal.travelStartDate }}</td>
            <td>{{ proposal.travelEndDate }}</td>
            <td>{{ proposal.travelType }}</td>
            <td>{{ proposal.suggestedAirlines }}</td>
            <td>{{ proposal.suggestedHotels }}</td>
            <td>{{ proposal.otherSuggestedTravelServices }}</td>
            <td>{{ proposal.state }}</td>
            <td>{{ proposal.customerFeedback }}</td>
            <td>{{ proposal.examplesOtherTravelServices }}</td>
            <td>{{ proposal.airlineTicketNumber }}</td>
            <td>{{ proposal.hotelBookingNumber }}</td>
            <td>{{ proposal.carBookingNumber }}</td>
            <td>{{ proposal.carRentalIncluded }}</td>
            <td>{{ proposal.applicationUserName }}</td>
            <td>{{ proposal.applicationPassword }}</td>
            <td>
              <div v-if="proposal.customer">
                <router-link :to="{ name: 'CustomerView', params: { customerId: proposal.customer.id } }">{{
                  proposal.customer.name
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="proposal.travelPlan">
                <router-link :to="{ name: 'TravelPlanView', params: { travelPlanId: proposal.travelPlan.id } }">{{
                  proposal.travelPlan.travelName
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="proposal.airlineCompany">
                <router-link :to="{ name: 'AirlineCompanyView', params: { airlineCompanyId: proposal.airlineCompany.id } }">{{
                  proposal.airlineCompany.name
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="proposal.hotel">
                <router-link :to="{ name: 'HotelView', params: { hotelId: proposal.hotel.id } }">{{ proposal.hotel.name }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="proposal.rentalCarCompany">
                <router-link :to="{ name: 'RentalCarCompanyView', params: { rentalCarCompanyId: proposal.rentalCarCompany.id } }">{{
                  proposal.rentalCarCompany.name
                }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ProposalView', params: { proposalId: proposal.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="myappApp.proposal.delete.question" data-cy="proposalDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-proposal-heading" v-text="$t('myappApp.proposal.delete.question', { id: removeId })">
          Are you sure you want to delete this Proposal?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-proposal"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProposal()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./proposal.component.ts"></script>
