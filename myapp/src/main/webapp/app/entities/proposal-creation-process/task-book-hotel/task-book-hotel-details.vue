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
              <label class="form-control-label" v-text="$t('myappApp.taskBookHotel.travelName')">travelName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="travelName"
                id="proposal-travelName"
                data-cy="travelName"
                v-model="taskContext.proposalCreationProcess.proposal.travelName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskBookHotel.travelStartDate')">travelStartDate</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskBookHotel.travelEndDate')">travelEndDate</label>
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
              <label class="form-control-label" v-text="$t('myappApp.taskBookHotel.airlineTicketNumber')">airlineTicketNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="airlineTicketNumber"
                id="proposal-airlineTicketNumber"
                data-cy="airlineTicketNumber"
                v-model="taskContext.proposalCreationProcess.proposal.airlineTicketNumber"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskBookHotel.hotelBookingNumber')">hotelBookingNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="hotelBookingNumber"
                id="proposal-hotelBookingNumber"
                data-cy="hotelBookingNumber"
                v-model="taskContext.proposalCreationProcess.proposal.hotelBookingNumber"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('myappApp.taskBookHotel.hotel')" for="task-book-hotel-hotel">Hotel</label>
              <input
                v-if="taskContext.proposalCreationProcess.proposal.hotel"
                readonly
                type="text"
                class="form-control"
                name="hotel"
                id="proposal-hotel"
                data-cy="hotel"
                :value="taskContext.proposalCreationProcess.proposal.hotel.name"
              />
              <input v-else readonly type="text" class="form-control" name="hotel" id="proposal-hotel" data-cy="hotel" value="" />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/ProposalCreationProcess/task/BookHotel/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-book-hotel-details.component.ts"></script>
