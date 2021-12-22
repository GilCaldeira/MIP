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
              <label class="form-control-label" v-text="$t('myappApp.taskWriteProposal.travelName')" for="task-write-proposal-travelName"
                >Travel Name</label
              >
              <input
                type="text"
                class="form-control"
                name="travelName"
                id="task-write-proposal-travelName"
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
                v-text="$t('myappApp.taskWriteProposal.customerName')"
                for="task-write-proposal-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-write-proposal-customerName"
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
                v-text="$t('myappApp.taskWriteProposal.travelStartDate')"
                for="task-write-proposal-travelStartDate"
                >Travel Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-write-proposal-travelStartDate"
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
                v-text="$t('myappApp.taskWriteProposal.travelEndDate')"
                for="task-write-proposal-travelEndDate"
                >Travel End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-write-proposal-travelEndDate"
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
                v-text="$t('myappApp.taskWriteProposal.examplesOtherTravelServices')"
                for="task-write-proposal-examplesOtherTravelServices"
                >Examples Other Travel Services</label
              >
              <input
                type="text"
                class="form-control"
                name="examplesOtherTravelServices"
                id="task-write-proposal-examplesOtherTravelServices"
                data-cy="examplesOtherTravelServices"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.examplesOtherTravelServices.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.examplesOtherTravelServices.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.examplesOtherTravelServices.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskWriteProposal.airlineCompany')"
                for="task-write-proposal-airlineCompany"
                >Airline Company</label
              >
              <select
                class="form-control"
                id="task-write-proposal-airlineCompany"
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
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskWriteProposal.hotel')" for="task-write-proposal-hotel"
                >Hotel</label
              >
              <select
                class="form-control"
                id="task-write-proposal-hotel"
                data-cy="hotel"
                name="hotel"
                v-model="taskContext.proposalCreationProcess.proposal.hotel"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.proposalCreationProcess.proposal.hotel &&
                    hotelOption.id === taskContext.proposalCreationProcess.proposal.hotel.id
                      ? taskContext.proposalCreationProcess.proposal.hotel
                      : hotelOption
                  "
                  v-for="hotelOption in hotels"
                  :key="hotelOption.id"
                >
                  {{ hotelOption.name }}
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

<script lang="ts" src="./task-write-proposal-execute.component.ts"></script>
