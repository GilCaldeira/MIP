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
                v-text="$t('myappApp.taskAddAccessCredentials.customerName')"
                for="task-add-access-credentials-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-add-access-credentials-customerName"
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
                v-text="$t('myappApp.taskAddAccessCredentials.travelStartDate')"
                for="task-add-access-credentials-travelStartDate"
                >Travel Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-add-access-credentials-travelStartDate"
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
                v-text="$t('myappApp.taskAddAccessCredentials.travelEndDate')"
                for="task-add-access-credentials-travelEndDate"
                >Travel End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-add-access-credentials-travelEndDate"
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
                v-text="$t('myappApp.taskAddAccessCredentials.applicationUserName')"
                for="task-add-access-credentials-applicationUserName"
                >Application User Name</label
              >
              <input
                type="text"
                class="form-control"
                name="applicationUserName"
                id="task-add-access-credentials-applicationUserName"
                data-cy="applicationUserName"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.applicationUserName.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.applicationUserName.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.applicationUserName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskAddAccessCredentials.applicationPassword')"
                for="task-add-access-credentials-applicationPassword"
                >Application Password</label
              >
              <input
                type="text"
                class="form-control"
                name="applicationPassword"
                id="task-add-access-credentials-applicationPassword"
                data-cy="applicationPassword"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.applicationPassword.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.applicationPassword.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.applicationPassword.$model"
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

<script lang="ts" src="./task-add-access-credentials-execute.component.ts"></script>
