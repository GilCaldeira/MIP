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
              <label class="form-control-label" v-text="$t('myappApp.taskProposalReview.name')" for="task-proposal-review-name">Name</label>
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-proposal-review-name"
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
              <label class="form-control-label" v-text="$t('myappApp.taskProposalReview.travelName')" for="task-proposal-review-travelName"
                >Travel Name</label
              >
              <input
                type="text"
                class="form-control"
                name="travelName"
                id="task-proposal-review-travelName"
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
                v-text="$t('myappApp.taskProposalReview.customerName')"
                for="task-proposal-review-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-proposal-review-customerName"
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
                v-text="$t('myappApp.taskProposalReview.travelStartDate')"
                for="task-proposal-review-travelStartDate"
                >Travel Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-proposal-review-travelStartDate"
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
                v-text="$t('myappApp.taskProposalReview.travelEndDate')"
                for="task-proposal-review-travelEndDate"
                >Travel End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-proposal-review-travelEndDate"
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
              <label class="form-control-label" v-text="$t('myappApp.taskProposalReview.travelType')" for="task-proposal-review-travelType"
                >Travel Type</label
              >
              <input
                type="text"
                class="form-control"
                name="travelType"
                id="task-proposal-review-travelType"
                readonly
                data-cy="travelType"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.travelType.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.travelType.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.travelType.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('myappApp.taskProposalReview.examplesOtherTravelServices')"
                for="task-proposal-review-examplesOtherTravelServices"
                >Examples Other Travel Services</label
              >
              <input
                type="text"
                class="form-control"
                name="examplesOtherTravelServices"
                id="task-proposal-review-examplesOtherTravelServices"
                readonly
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
                v-text="$t('myappApp.taskProposalReview.airlineCompany')"
                for="task-proposal-review-airlineCompany"
                >Airline Company</label
              >
              <select
                class="form-control"
                id="task-proposal-review-airlineCompany"
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
              <label class="form-control-label" v-text="$t('myappApp.taskProposalReview.hotel')" for="task-proposal-review-hotel"
                >Hotel</label
              >
              <select
                class="form-control"
                id="task-proposal-review-hotel"
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

<script lang="ts" src="./task-proposal-review-execute.component.ts"></script>
