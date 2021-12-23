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
              <label class="form-control-label" v-text="$t('myappApp.taskChooseFlight.travelName')">travelName</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskChooseFlight.travelStartDate')">travelStartDate</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskChooseFlight.travelEndDate')">travelEndDate</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskChooseFlight.airlineTicketNumber')">airlineTicketNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="airlineTicketNumber"
                id="proposal-airlineTicketNumber"
                data-cy="airlineTicketNumber"
                v-model="taskContext.proposalCreationProcess.proposal.airlineTicketNumber"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskChooseFlight.airlineCompany')"
                for="task-choose-flight-airlineCompany"
                >Airline Company</label
              >
              <input
                v-if="taskContext.proposalCreationProcess.proposal.airlineCompany"
                readonly
                type="text"
                class="form-control"
                name="airlineCompany"
                id="proposal-airlineCompany"
                data-cy="airlineCompany"
                :value="taskContext.proposalCreationProcess.proposal.airlineCompany.name"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="airlineCompany"
                id="proposal-airlineCompany"
                data-cy="airlineCompany"
                value=""
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
          :to="`/process-definition/ProposalCreationProcess/task/ChooseFlight/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-choose-flight-details.component.ts"></script>
