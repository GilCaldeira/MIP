<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="travelPlan">
        <h2 class="jh-entity-heading" data-cy="travelPlanDetailsHeading">
          <span v-text="$t('myappApp.travelPlan.detail.title')">TravelPlan</span> {{ travelPlan.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('myappApp.travelPlan.travelName')">Travel Name</span>
          </dt>
          <dd>
            <span>{{ travelPlan.travelName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.travelStartDate')">Travel Start Date</span>
          </dt>
          <dd>
            <span>{{ travelPlan.travelStartDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.travelEndDate')">Travel End Date</span>
          </dt>
          <dd>
            <span>{{ travelPlan.travelEndDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.travelType')">Travel Type</span>
          </dt>
          <dd>
            <span>{{ travelPlan.travelType }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.suggestedAirlines')">Suggested Airlines</span>
          </dt>
          <dd>
            <span>{{ travelPlan.suggestedAirlines }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.suggestedHotels')">Suggested Hotels</span>
          </dt>
          <dd>
            <span>{{ travelPlan.suggestedHotels }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.otherSuggestedTravelServices')">Other Suggested Travel Services</span>
          </dt>
          <dd>
            <span>{{ travelPlan.otherSuggestedTravelServices }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.carRentalIncluded')">Car Rental Included</span>
          </dt>
          <dd>
            <span>{{ travelPlan.carRentalIncluded }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.customer')">Customer</span>
          </dt>
          <dd>
            <div v-if="travelPlan.customer">
              <router-link :to="{ name: 'CustomerView', params: { customerId: travelPlan.customer.id } }">{{
                travelPlan.customer.name
              }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="travelPlan.id"
          :to="{ name: 'TravelPlanEdit', params: { travelPlanId: travelPlan.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./travel-plan-details.component.ts"></script>
