<template>
  <div>
    <h2 id="page-heading" data-cy="TravelPlanHeading">
      <span v-text="$t('myappApp.travelPlan.home.title')" id="travel-plan-heading">Travel Plans</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myappApp.travelPlan.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'TravelPlanCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-travel-plan"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('myappApp.travelPlan.home.createLabel')"> Create a new Travel Plan </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && travelPlans && travelPlans.length === 0">
      <span v-text="$t('myappApp.travelPlan.home.notFound')">No travelPlans found</span>
    </div>
    <div class="table-responsive" v-if="travelPlans && travelPlans.length > 0">
      <table class="table table-striped" aria-describedby="travelPlans">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.travelName')">Travel Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.travelStartDate')">Travel Start Date</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.travelEndDate')">Travel End Date</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.travelType')">Travel Type</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.suggestedAirlines')">Suggested Airlines</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.suggestedHotels')">Suggested Hotels</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.otherTravelServices')">Other Travel Services</span></th>
            <th scope="row"><span v-text="$t('myappApp.travelPlan.customer')">Customer</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="travelPlan in travelPlans" :key="travelPlan.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'TravelPlanView', params: { travelPlanId: travelPlan.id } }">{{ travelPlan.id }}</router-link>
            </td>
            <td>{{ travelPlan.travelName }}</td>
            <td>{{ travelPlan.travelStartDate }}</td>
            <td>{{ travelPlan.travelEndDate }}</td>
            <td>{{ travelPlan.travelType }}</td>
            <td>{{ travelPlan.suggestedAirlines }}</td>
            <td>{{ travelPlan.suggestedHotels }}</td>
            <td>{{ travelPlan.otherTravelServices }}</td>
            <td>
              <div v-if="travelPlan.customer">
                <router-link :to="{ name: 'CustomerView', params: { customerId: travelPlan.customer.id } }">{{
                  travelPlan.customer.name
                }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'TravelPlanView', params: { travelPlanId: travelPlan.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'TravelPlanEdit', params: { travelPlanId: travelPlan.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(travelPlan)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="myappApp.travelPlan.delete.question" data-cy="travelPlanDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-travelPlan-heading" v-text="$t('myappApp.travelPlan.delete.question', { id: removeId })">
          Are you sure you want to delete this Travel Plan?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-travelPlan"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeTravelPlan()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./travel-plan.component.ts"></script>
