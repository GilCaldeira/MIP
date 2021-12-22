<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('myappApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.travelName')"
                for="task-check-travel-plan-travelName"
                >Travel Name</label
              >
              <input
                type="text"
                class="form-control"
                name="travelName"
                id="task-check-travel-plan-travelName"
                readonly
                data-cy="travelName"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.travelName.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.travelName.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.travelName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.customerName')"
                for="task-check-travel-plan-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-check-travel-plan-customerName"
                readonly
                data-cy="customerName"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.customerName.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.customerName.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.customerName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.travelStartDate')"
                for="task-check-travel-plan-travelStartDate"
                >Travel Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-check-travel-plan-travelStartDate"
                  readonly
                  data-cy="travelStartDate"
                  type="text"
                  class="form-control"
                  name="travelStartDate"
                  :class="{
                    valid: !$v.taskContext.proposalCreationProcess.proposal.travelStartDate.$invalid,
                    invalid: $v.taskContext.proposalCreationProcess.proposal.travelStartDate.$invalid,
                  }"
                  v-model="$v.taskContext.proposalCreationProcess.proposal.travelStartDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.travelEndDate')"
                for="task-check-travel-plan-travelEndDate"
                >Travel End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-check-travel-plan-travelEndDate"
                  readonly
                  data-cy="travelEndDate"
                  type="text"
                  class="form-control"
                  name="travelEndDate"
                  :class="{
                    valid: !$v.taskContext.proposalCreationProcess.proposal.travelEndDate.$invalid,
                    invalid: $v.taskContext.proposalCreationProcess.proposal.travelEndDate.$invalid,
                  }"
                  v-model="$v.taskContext.proposalCreationProcess.proposal.travelEndDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.travelType')"
                for="task-check-travel-plan-travelType"
                >Travel Type</label
              >
              <input
                type="text"
                class="form-control"
                name="travelType"
                id="task-check-travel-plan-travelType"
                readonly
                data-cy="travelType"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.travelType.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.travelType.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.travelType.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.suggestedAirlines')"
                for="task-check-travel-plan-suggestedAirlines"
                >Suggested Airlines</label
              >
              <input
                type="text"
                class="form-control"
                name="suggestedAirlines"
                id="task-check-travel-plan-suggestedAirlines"
                readonly
                data-cy="suggestedAirlines"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.suggestedAirlines.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.suggestedAirlines.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.suggestedAirlines.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.suggestedHotels')"
                for="task-check-travel-plan-suggestedHotels"
                >Suggested Hotels</label
              >
              <input
                type="text"
                class="form-control"
                name="suggestedHotels"
                id="task-check-travel-plan-suggestedHotels"
                readonly
                data-cy="suggestedHotels"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.suggestedHotels.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.suggestedHotels.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.suggestedHotels.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskCheckTravelPlan.otherSuggestedTravelServices')"
                for="task-check-travel-plan-otherSuggestedTravelServices"
                >Other Suggested Travel Services</label
              >
              <input
                type="text"
                class="form-control"
                name="otherSuggestedTravelServices"
                id="task-check-travel-plan-otherSuggestedTravelServices"
                readonly
                data-cy="otherSuggestedTravelServices"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.otherSuggestedTravelServices.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.otherSuggestedTravelServices.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.otherSuggestedTravelServices.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-check-travel-plan-execute.component.ts"></script>
