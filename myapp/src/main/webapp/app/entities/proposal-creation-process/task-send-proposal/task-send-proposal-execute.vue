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
              <label class="form-control-label" v-text="$t('myappApp.taskSendProposal.name')" for="task-send-proposal-name">Name</label>
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-send-proposal-name"
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
              <label class="form-control-label" v-text="$t('myappApp.taskSendProposal.customerName')" for="task-send-proposal-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-send-proposal-customerName"
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
                v-text="$t('myappApp.taskSendProposal.customerEmail')"
                for="task-send-proposal-customerEmail"
                >Customer Email</label
              >
              <input
                type="text"
                class="form-control"
                name="customerEmail"
                id="task-send-proposal-customerEmail"
                readonly
                data-cy="customerEmail"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.customerEmail.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.customerEmail.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.customerEmail.$model"
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

<script lang="ts" src="./task-send-proposal-execute.component.ts"></script>
