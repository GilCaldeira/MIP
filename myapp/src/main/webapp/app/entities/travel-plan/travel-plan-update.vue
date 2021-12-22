<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="myappApp.travelPlan.home.createOrEditLabel"
          data-cy="TravelPlanCreateUpdateHeading"
          v-text="$t('myappApp.travelPlan.home.createOrEditLabel')"
        >
          Create or edit a TravelPlan
        </h2>
        <div>
          <div class="form-group" v-if="travelPlan.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="travelPlan.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.travelName')" for="travel-plan-travelName">Travel Name</label>
            <input
              type="text"
              class="form-control"
              name="travelName"
              id="travel-plan-travelName"
              data-cy="travelName"
              :class="{ valid: !$v.travelPlan.travelName.$invalid, invalid: $v.travelPlan.travelName.$invalid }"
              v-model="$v.travelPlan.travelName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.travelStartDate')" for="travel-plan-travelStartDate"
              >Travel Start Date</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="travel-plan-travelStartDate"
                  v-model="$v.travelPlan.travelStartDate.$model"
                  name="travelStartDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="travel-plan-travelStartDate"
                data-cy="travelStartDate"
                type="text"
                class="form-control"
                name="travelStartDate"
                :class="{ valid: !$v.travelPlan.travelStartDate.$invalid, invalid: $v.travelPlan.travelStartDate.$invalid }"
                v-model="$v.travelPlan.travelStartDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.travelEndDate')" for="travel-plan-travelEndDate"
              >Travel End Date</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="travel-plan-travelEndDate"
                  v-model="$v.travelPlan.travelEndDate.$model"
                  name="travelEndDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="travel-plan-travelEndDate"
                data-cy="travelEndDate"
                type="text"
                class="form-control"
                name="travelEndDate"
                :class="{ valid: !$v.travelPlan.travelEndDate.$invalid, invalid: $v.travelPlan.travelEndDate.$invalid }"
                v-model="$v.travelPlan.travelEndDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.travelType')" for="travel-plan-travelType">Travel Type</label>
            <input
              type="text"
              class="form-control"
              name="travelType"
              id="travel-plan-travelType"
              data-cy="travelType"
              :class="{ valid: !$v.travelPlan.travelType.$invalid, invalid: $v.travelPlan.travelType.$invalid }"
              v-model="$v.travelPlan.travelType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.suggestedAirlines')" for="travel-plan-suggestedAirlines"
              >Suggested Airlines</label
            >
            <input
              type="text"
              class="form-control"
              name="suggestedAirlines"
              id="travel-plan-suggestedAirlines"
              data-cy="suggestedAirlines"
              :class="{ valid: !$v.travelPlan.suggestedAirlines.$invalid, invalid: $v.travelPlan.suggestedAirlines.$invalid }"
              v-model="$v.travelPlan.suggestedAirlines.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.suggestedHotels')" for="travel-plan-suggestedHotels"
              >Suggested Hotels</label
            >
            <input
              type="text"
              class="form-control"
              name="suggestedHotels"
              id="travel-plan-suggestedHotels"
              data-cy="suggestedHotels"
              :class="{ valid: !$v.travelPlan.suggestedHotels.$invalid, invalid: $v.travelPlan.suggestedHotels.$invalid }"
              v-model="$v.travelPlan.suggestedHotels.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('myappApp.travelPlan.otherSuggestedTravelServices')"
              for="travel-plan-otherSuggestedTravelServices"
              >Other Suggested Travel Services</label
            >
            <input
              type="text"
              class="form-control"
              name="otherSuggestedTravelServices"
              id="travel-plan-otherSuggestedTravelServices"
              data-cy="otherSuggestedTravelServices"
              :class="{
                valid: !$v.travelPlan.otherSuggestedTravelServices.$invalid,
                invalid: $v.travelPlan.otherSuggestedTravelServices.$invalid,
              }"
              v-model="$v.travelPlan.otherSuggestedTravelServices.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.customer')" for="travel-plan-customer">Customer</label>
            <select class="form-control" id="travel-plan-customer" data-cy="customer" name="customer" v-model="travelPlan.customer">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="travelPlan.customer && customerOption.id === travelPlan.customer.id ? travelPlan.customer : customerOption"
                v-for="customerOption in customers"
                :key="customerOption.id"
              >
                {{ customerOption.name }}
              </option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.travelPlan.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./travel-plan-update.component.ts"></script>
