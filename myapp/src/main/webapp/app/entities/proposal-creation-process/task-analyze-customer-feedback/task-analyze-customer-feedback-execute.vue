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
                v-text="$t('myappApp.taskAnalyzeCustomerFeedback.name')"
                for="task-analyze-customer-feedback-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-analyze-customer-feedback-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.name.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.name.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.name.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskAnalyzeCustomerFeedback.customerName')"
                for="task-analyze-customer-feedback-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-analyze-customer-feedback-customerName"
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
                v-text="$t('myappApp.taskAnalyzeCustomerFeedback.customerEmail')"
                for="task-analyze-customer-feedback-customerEmail"
                >Customer Email</label
              >
              <input
                type="text"
                class="form-control"
                name="customerEmail"
                id="task-analyze-customer-feedback-customerEmail"
                readonly
                data-cy="customerEmail"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.customerEmail.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.customerEmail.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.customerEmail.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskAnalyzeCustomerFeedback.state')"
                for="task-analyze-customer-feedback-state"
                >State</label
              >
              <input
                type="text"
                class="form-control"
                name="state"
                id="task-analyze-customer-feedback-state"
                readonly
                data-cy="state"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.state.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.state.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.state.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskAnalyzeCustomerFeedback.customerFeedback')"
                for="task-analyze-customer-feedback-customerFeedback"
                >Customer Feedback</label
              >
              <input
                type="text"
                class="form-control"
                name="customerFeedback"
                id="task-analyze-customer-feedback-customerFeedback"
                readonly
                data-cy="customerFeedback"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.customerFeedback.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.customerFeedback.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.customerFeedback.$model"
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

<script lang="ts" src="./task-analyze-customer-feedback-execute.component.ts"></script>
