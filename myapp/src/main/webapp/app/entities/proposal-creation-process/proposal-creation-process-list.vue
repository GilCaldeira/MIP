<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="proposalCreationProcessDetailsHeading">
      <span v-text="$t('myappApp.proposalCreationProcess.home.title')">ProposalCreationProcess</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myappApp.proposalCreationProcess.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/ProposalCreationProcess/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('myappApp.proposalCreationProcess.home.createLabel')"> Create a new Travel Plan Process Instance </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && proposalCreationProcessList && proposalCreationProcessList.length === 0">
      <span v-text="$t('myappApp.proposalCreationProcess.home.notFound')">No proposalCreationProcess found</span>
    </div>
    <div class="table-responsive" v-if="proposalCreationProcessList && proposalCreationProcessList.length > 0">
      <table class="table table-striped" aria-describedby="proposalCreationProcessList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span>Process Instance</span></th>
            <th scope="row"><span>Proposal</span></th>
            <th scope="row"><span>Status</span></th>
            <th scope="row"><span>Start Date</span></th>
            <th scope="row"><span>End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="proposalCreationProcess in proposalCreationProcessList" :key="proposalCreationProcess.id" data-cy="entityTable">
            <td>{{ proposalCreationProcess.id }}</td>
            <td>
              <div v-if="proposalCreationProcess.processInstance">
                <router-link
                  :to="`/process-definition/ProposalCreationProcess/instance/${proposalCreationProcess.processInstance.id}/view`"
                >
                  {{ proposalCreationProcess.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="proposalCreationProcess.proposal">
                <router-link :to="{ name: 'ProposalView', params: { proposalId: proposalCreationProcess.proposal.id } }">{{
                  proposalCreationProcess.proposal.id
                }}</router-link>
              </div>
            </td>
            <td>
              <akip-show-process-instance-status
                :status="proposalCreationProcess.processInstance.status"
              ></akip-show-process-instance-status>
            </td>
            <td>
              {{
                proposalCreationProcess.processInstance.startDate
                  ? $d(Date.parse(proposalCreationProcess.processInstance.startDate), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                proposalCreationProcess.processInstance.endDate
                  ? $d(Date.parse(proposalCreationProcess.processInstance.endDate), 'short')
                  : ''
              }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/ProposalCreationProcess/instance/${proposalCreationProcess.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./proposal-creation-process-list.component.ts"></script>
