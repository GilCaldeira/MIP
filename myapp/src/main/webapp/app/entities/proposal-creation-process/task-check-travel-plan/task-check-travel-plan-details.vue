<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('myappApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.travelName')">travelName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="travelName"
                id="proposal-travelName"
                data-cy="travelName"
                v-model="taskContext.proposalCreationProcess.proposal.travelName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.customerName')">customerName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerName"
                id="proposal-customerName"
                data-cy="customerName"
                v-model="taskContext.proposalCreationProcess.proposal.customerName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.travelStartDate')">travelStartDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="travelStartDate"
                id="proposal-travelStartDate"
                data-cy="travelStartDate"
                v-model="taskContext.proposalCreationProcess.proposal.travelStartDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.travelEndDate')">travelEndDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="travelEndDate"
                id="proposal-travelEndDate"
                data-cy="travelEndDate"
                v-model="taskContext.proposalCreationProcess.proposal.travelEndDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.travelType')">travelType</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="travelType"
                id="proposal-travelType"
                data-cy="travelType"
                v-model="taskContext.proposalCreationProcess.proposal.travelType"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.suggestedAirlines')">suggestedAirlines</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="suggestedAirlines"
                id="proposal-suggestedAirlines"
                data-cy="suggestedAirlines"
                v-model="taskContext.proposalCreationProcess.proposal.suggestedAirlines"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.suggestedHotels')">suggestedHotels</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="suggestedHotels"
                id="proposal-suggestedHotels"
                data-cy="suggestedHotels"
                v-model="taskContext.proposalCreationProcess.proposal.suggestedHotels"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.otherSuggestedTravelServices')"
                >otherSuggestedTravelServices</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="otherSuggestedTravelServices"
                id="proposal-otherSuggestedTravelServices"
                data-cy="otherSuggestedTravelServices"
                v-model="taskContext.proposalCreationProcess.proposal.otherSuggestedTravelServices"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/ProposalCreationProcess/task/CheckTravelPlan/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-check-travel-plan-details.component.ts"></script>
