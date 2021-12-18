<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="myappApp.proposalCreationStartForm.home.createOrEditLabel"
          data-cy="ProposalCreationStartFormCreateUpdateHeading"
          v-text="$t('myappApp.proposalCreationStartForm.home.createOrEditLabel')"
        >
          Create or edit a ProposalCreationStartForm
        </h2>
        <div v-if="proposalCreationProcess.processInstance">
          <akip-show-process-definition :processDefinition="proposalCreationProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="proposalCreationProcess.proposal">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('myappApp.proposalCreationStartForm.name')"
                    for="proposal-creation-start-form-name"
                    >Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="proposal-creation-start-form-name"
                    data-cy="name"
                    :class="{
                      valid: !$v.proposalCreationProcess.proposal.name.$invalid,
                      invalid: $v.proposalCreationProcess.proposal.name.$invalid,
                    }"
                    v-model="$v.proposalCreationProcess.proposal.name.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.proposalCreationProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./proposal-creation-start-form-init.component.ts"></script>
