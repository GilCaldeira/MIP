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
              <label class="form-control-label" v-text="$t('myappApp.taskChooseFlight.travelName')" for="task-choose-flight-travelName"
                >Travel Name</label
              >
              <input
                type="text"
                class="form-control"
                name="travelName"
                id="task-choose-flight-travelName"
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
                v-text="$t('myappApp.taskChooseFlight.travelStartDate')"
                for="task-choose-flight-travelStartDate"
                >Travel Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-choose-flight-travelStartDate"
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
                v-text="$t('myappApp.taskChooseFlight.travelEndDate')"
                for="task-choose-flight-travelEndDate"
                >Travel End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-choose-flight-travelEndDate"
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
                v-text="$t('myappApp.taskChooseFlight.airlineTicketNumber')"
                for="task-choose-flight-airlineTicketNumber"
                >Airline Ticket Number</label
              >
              <input
                type="text"
                class="form-control"
                name="airlineTicketNumber"
                id="task-choose-flight-airlineTicketNumber"
                data-cy="airlineTicketNumber"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.airlineTicketNumber.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.airlineTicketNumber.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.airlineTicketNumber.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskChooseFlight.airlineCompany')"
                for="task-choose-flight-airlineCompany"
                >Airline Company</label
              >
              <select
                class="form-control"
                id="task-choose-flight-airlineCompany"
                data-cy="airlineCompany"
                name="airlineCompany"
                v-model="taskContext.proposalCreationProcess.proposal.airlineCompany"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.proposalCreationProcess.proposal.airlineCompany &&
                    airlineCompanyOption.id === taskContext.proposalCreationProcess.proposal.airlineCompany.id
                      ? taskContext.proposalCreationProcess.proposal.airlineCompany
                      : airlineCompanyOption
                  "
                  v-for="airlineCompanyOption in airlineCompanies"
                  :key="airlineCompanyOption.id"
                >
                  {{ airlineCompanyOption.name }}
                </option>
              </select>
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

<script lang="ts" src="./task-choose-flight-execute.component.ts"></script>
