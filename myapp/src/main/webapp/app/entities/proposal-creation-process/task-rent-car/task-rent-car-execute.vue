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
              <label class="form-control-label" v-text="$t('myappApp.taskRentCar.travelName')" for="task-rent-car-travelName"
                >Travel Name</label
              >
              <input
                type="text"
                class="form-control"
                name="travelName"
                id="task-rent-car-travelName"
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
              <label class="form-control-label" v-text="$t('myappApp.taskRentCar.travelStartDate')" for="task-rent-car-travelStartDate"
                >Travel Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-rent-car-travelStartDate"
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
              <label class="form-control-label" v-text="$t('myappApp.taskRentCar.travelEndDate')" for="task-rent-car-travelEndDate"
                >Travel End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-rent-car-travelEndDate"
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
              <label class="form-control-label" v-text="$t('myappApp.taskRentCar.carBookingNumber')" for="task-rent-car-carBookingNumber"
                >Car Booking Number</label
              >
              <input
                type="text"
                class="form-control"
                name="carBookingNumber"
                id="task-rent-car-carBookingNumber"
                data-cy="carBookingNumber"
                :class="{
                  valid: !$v.taskContext.proposalCreationProcess.proposal.carBookingNumber.$invalid,
                  invalid: $v.taskContext.proposalCreationProcess.proposal.carBookingNumber.$invalid,
                }"
                v-model="$v.taskContext.proposalCreationProcess.proposal.carBookingNumber.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskRentCar.rentalCarCompany')" for="task-rent-car-rentalCarCompany"
                >Rental Car Company</label
              >
              <select
                class="form-control"
                id="task-rent-car-rentalCarCompany"
                data-cy="rentalCarCompany"
                name="rentalCarCompany"
                v-model="taskContext.proposalCreationProcess.proposal.rentalCarCompany"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.proposalCreationProcess.proposal.rentalCarCompany &&
                    rentalCarCompanyOption.id === taskContext.proposalCreationProcess.proposal.rentalCarCompany.id
                      ? taskContext.proposalCreationProcess.proposal.rentalCarCompany
                      : rentalCarCompanyOption
                  "
                  v-for="rentalCarCompanyOption in rentalCarCompanies"
                  :key="rentalCarCompanyOption.id"
                >
                  {{ rentalCarCompanyOption.name }}
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

<script lang="ts" src="./task-rent-car-execute.component.ts"></script>
