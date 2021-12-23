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
              <label class="form-control-label" v-text="$t('myappApp.taskAddAccessCredentials.customerName')">customerName</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskAddAccessCredentials.travelStartDate')">travelStartDate</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskAddAccessCredentials.travelEndDate')">travelEndDate</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskAddAccessCredentials.applicationUserName')"
                >applicationUserName</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="applicationUserName"
                id="proposal-applicationUserName"
                data-cy="applicationUserName"
                v-model="taskContext.proposalCreationProcess.proposal.applicationUserName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskAddAccessCredentials.applicationPassword')"
                >applicationPassword</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="applicationPassword"
                id="proposal-applicationPassword"
                data-cy="applicationPassword"
                v-model="taskContext.proposalCreationProcess.proposal.applicationPassword"
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
          :to="`/process-definition/ProposalCreationProcess/task/AddAccessCredentials/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-add-access-credentials-details.component.ts"></script>
