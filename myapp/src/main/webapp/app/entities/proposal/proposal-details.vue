<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="proposal">
        <h2 class="jh-entity-heading" data-cy="proposalDetailsHeading">
          <span v-text="$t('myappApp.proposal.detail.title')">Proposal</span> {{ proposal.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('myappApp.proposal.name')">Name</span>
          </dt>
          <dd>
            <span>{{ proposal.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.customerName')">Customer Name</span>
          </dt>
          <dd>
            <span>{{ proposal.customerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.customerEmail')">Customer Email</span>
          </dt>
          <dd>
            <span>{{ proposal.customerEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.travelName')">Travel Name</span>
          </dt>
          <dd>
            <span>{{ proposal.travelName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.travelStartDate')">Travel Start Date</span>
          </dt>
          <dd>
            <span>{{ proposal.travelStartDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.travelEndDate')">Travel End Date</span>
          </dt>
          <dd>
            <span>{{ proposal.travelEndDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.travelType')">Travel Type</span>
          </dt>
          <dd>
            <span>{{ proposal.travelType }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.suggestedAirlines')">Suggested Airlines</span>
          </dt>
          <dd>
            <span>{{ proposal.suggestedAirlines }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.suggestedHotels')">Suggested Hotels</span>
          </dt>
          <dd>
            <span>{{ proposal.suggestedHotels }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.otherSuggestedTravelServices')">Other Suggested Travel Services</span>
          </dt>
          <dd>
            <span>{{ proposal.otherSuggestedTravelServices }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.state')">State</span>
          </dt>
          <dd>
            <span>{{ proposal.state }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.customerFeedback')">Customer Feedback</span>
          </dt>
          <dd>
            <span>{{ proposal.customerFeedback }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.examplesOtherTravelServices')">Examples Other Travel Services</span>
          </dt>
          <dd>
            <span>{{ proposal.examplesOtherTravelServices }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.airlineTicketNumber')">Airline Ticket Number</span>
          </dt>
          <dd>
            <span>{{ proposal.airlineTicketNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.hotelBookingNumber')">Hotel Booking Number</span>
          </dt>
          <dd>
            <span>{{ proposal.hotelBookingNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.customer')">Customer</span>
          </dt>
          <dd>
            <div v-if="proposal.customer">
              <router-link :to="{ name: 'CustomerView', params: { customerId: proposal.customer.id } }">{{
                proposal.customer.name
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.travelPlan')">Travel Plan</span>
          </dt>
          <dd>
            <div v-if="proposal.travelPlan">
              <router-link :to="{ name: 'TravelPlanView', params: { travelPlanId: proposal.travelPlan.id } }">{{
                proposal.travelPlan.travelName
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.airlineCompany')">Airline Company</span>
          </dt>
          <dd>
            <div v-if="proposal.airlineCompany">
              <router-link :to="{ name: 'AirlineCompanyView', params: { airlineCompanyId: proposal.airlineCompany.id } }">{{
                proposal.airlineCompany.name
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.hotel')">Hotel</span>
          </dt>
          <dd>
            <div v-if="proposal.hotel">
              <router-link :to="{ name: 'HotelView', params: { hotelId: proposal.hotel.id } }">{{ proposal.hotel.name }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./proposal-details.component.ts"></script>
