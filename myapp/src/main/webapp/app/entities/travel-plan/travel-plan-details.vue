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
            <span v-text="$t('myappApp.travelPlan.customerName')">Customer Name</span>
          </dt>
          <dd>
            <span>{{ travelPlan.customerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.travelPlan.travelServices')">Travel Services</span>
          </dt>
          <dd>
            <span>{{ travelPlan.travelServices }}</span>
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
