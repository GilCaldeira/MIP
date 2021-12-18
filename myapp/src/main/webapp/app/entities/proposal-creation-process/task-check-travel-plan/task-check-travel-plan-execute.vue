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
              <label class="form-control-label" v-text="$t('myappApp.taskCheckTravelPlan.name')" for="task-check-travel-plan-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-check-travel-plan-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.name.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.name.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.name.$model"
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
