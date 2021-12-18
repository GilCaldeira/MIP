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
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.customerName')" for="travel-plan-customerName"
              >Customer Name</label
            >
            <input
              type="text"
              class="form-control"
              name="customerName"
              id="travel-plan-customerName"
              data-cy="customerName"
              :class="{ valid: !$v.travelPlan.customerName.$invalid, invalid: $v.travelPlan.customerName.$invalid }"
              v-model="$v.travelPlan.customerName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('myappApp.travelPlan.travelServices')" for="travel-plan-travelServices"
              >Travel Services</label
            >
            <input
              type="text"
              class="form-control"
              name="travelServices"
              id="travel-plan-travelServices"
              data-cy="travelServices"
              :class="{ valid: !$v.travelPlan.travelServices.$invalid, invalid: $v.travelPlan.travelServices.$invalid }"
              v-model="$v.travelPlan.travelServices.$model"
            />
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
