<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="proposalCreationProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="proposalCreationProcessDetailsHeading">
          <span v-text="$t('myappApp.proposalCreationProcess.detail.title')">ProposalCreationProcess</span> {{ proposalCreationProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="proposalCreationProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('myappApp.proposalCreationProcess.detail.title')">ProposalCreationProcess</span> #{{
              proposalCreationProcess.id
            }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="proposalCreationProcess.proposal">
              <h5 class="card-header">
                <span class="title"> Proposal #{{ proposalCreationProcess.proposal.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="name"
                    id="proposal-name"
                    data-cy="name"
                    v-model="proposalCreationProcess.proposal.name"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.customerName')">customerName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerName"
                    id="proposal-customerName"
                    data-cy="customerName"
                    v-model="proposalCreationProcess.proposal.customerName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.customerEmail')">customerEmail</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerEmail"
                    id="proposal-customerEmail"
                    data-cy="customerEmail"
                    v-model="proposalCreationProcess.proposal.customerEmail"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.travelName')">travelName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="travelName"
                    id="proposal-travelName"
                    data-cy="travelName"
                    v-model="proposalCreationProcess.proposal.travelName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.travelStartDate')">travelStartDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="travelStartDate"
                    id="proposal-travelStartDate"
                    data-cy="travelStartDate"
                    v-model="proposalCreationProcess.proposal.travelStartDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.travelEndDate')">travelEndDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="travelEndDate"
                    id="proposal-travelEndDate"
                    data-cy="travelEndDate"
                    v-model="proposalCreationProcess.proposal.travelEndDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.travelType')">travelType</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="travelType"
                    id="proposal-travelType"
                    data-cy="travelType"
                    v-model="proposalCreationProcess.proposal.travelType"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.suggestedAirlines')"
                    >suggestedAirlines</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="suggestedAirlines"
                    id="proposal-suggestedAirlines"
                    data-cy="suggestedAirlines"
                    v-model="proposalCreationProcess.proposal.suggestedAirlines"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.suggestedHotels')">suggestedHotels</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="suggestedHotels"
                    id="proposal-suggestedHotels"
                    data-cy="suggestedHotels"
                    v-model="proposalCreationProcess.proposal.suggestedHotels"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.otherTravelServices')"
                    >otherTravelServices</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="otherTravelServices"
                    id="proposal-otherTravelServices"
                    data-cy="otherTravelServices"
                    v-model="proposalCreationProcess.proposal.otherTravelServices"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.state')">state</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="state"
                    id="proposal-state"
                    data-cy="state"
                    v-model="proposalCreationProcess.proposal.state"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myappApp.proposalCreationProcess.customer')"
                    for="proposal-creation-process-customer"
                    >Customer</label
                  >
                  <input
                    v-if="proposalCreationProcess.proposal.customer"
                    readonly
                    type="text"
                    class="form-control"
                    name="customer"
                    id="proposal-customer"
                    data-cy="customer"
                    :value="proposalCreationProcess.proposal.customer.name"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="customer"
                    id="proposal-customer"
                    data-cy="customer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myappApp.proposalCreationProcess.travelPlan')"
                    for="proposal-creation-process-travelPlan"
                    >Travel Plan</label
                  >
                  <input
                    v-if="proposalCreationProcess.proposal.travelPlan"
                    readonly
                    type="text"
                    class="form-control"
                    name="travelPlan"
                    id="proposal-travelPlan"
                    data-cy="travelPlan"
                    :value="proposalCreationProcess.proposal.travelPlan.travelName"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="travelPlan"
                    id="proposal-travelPlan"
                    data-cy="travelPlan"
                    value=""
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./proposal-creation-process-details.component.ts"></script>
