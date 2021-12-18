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
                  <label class="form-control-label" v-text="$t('myappApp.proposalCreationProcess.travelServices')">travelServices</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="travelServices"
                    id="proposal-travelServices"
                    data-cy="travelServices"
                    v-model="proposalCreationProcess.proposal.travelServices"
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
