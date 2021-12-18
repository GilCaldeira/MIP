<template>
  <div>
    <h2 id="page-heading" data-cy="ProposalHeading">
      <span v-text="$t('myappApp.proposal.home.title')" id="proposal-heading">Proposals</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('myappApp.proposal.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && proposals && proposals.length === 0">
      <span v-text="$t('myappApp.proposal.home.notFound')">No proposals found</span>
    </div>
    <div class="table-responsive" v-if="proposals && proposals.length > 0">
      <table class="table table-striped" aria-describedby="proposals">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.name')">Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.customerName')">Customer Name</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.customerEmail')">Customer Email</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.state')">State</span></th>
            <th scope="row"><span v-text="$t('myappApp.proposal.travelServices')">Travel Services</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="proposal in proposals" :key="proposal.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ProposalView', params: { proposalId: proposal.id } }">{{ proposal.id }}</router-link>
            </td>
            <td>{{ proposal.name }}</td>
            <td>{{ proposal.customerName }}</td>
            <td>{{ proposal.customerEmail }}</td>
            <td>{{ proposal.state }}</td>
            <td>{{ proposal.travelServices }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ProposalView', params: { proposalId: proposal.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="myappApp.proposal.delete.question" data-cy="proposalDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-proposal-heading" v-text="$t('myappApp.proposal.delete.question', { id: removeId })">
          Are you sure you want to delete this Proposal?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-proposal"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeProposal()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./proposal.component.ts"></script>
