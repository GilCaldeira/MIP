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
              <label class="form-control-label" v-text="$t('myappApp.taskAnalyzeCustomerFeedback.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="name"
                id="proposal-name"
                data-cy="name"
                v-model="taskContext.proposalCreationProcess.proposal.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskAnalyzeCustomerFeedback.customerName')">customerName</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskAnalyzeCustomerFeedback.customerEmail')">customerEmail</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerEmail"
                id="proposal-customerEmail"
                data-cy="customerEmail"
                v-model="taskContext.proposalCreationProcess.proposal.customerEmail"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskAnalyzeCustomerFeedback.state')">state</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="state"
                id="proposal-state"
                data-cy="state"
                v-model="taskContext.proposalCreationProcess.proposal.state"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskAnalyzeCustomerFeedback.customerFeedback')"
                >customerFeedback</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="customerFeedback"
                id="proposal-customerFeedback"
                data-cy="customerFeedback"
                v-model="taskContext.proposalCreationProcess.proposal.customerFeedback"
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
          :to="`/process-definition/ProposalCreationProcess/task/AnalyzeCustomerFeedback/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-analyze-customer-feedback-details.component.ts"></script>
