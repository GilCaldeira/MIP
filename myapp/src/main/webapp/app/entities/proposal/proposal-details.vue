<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="proposal">
        <h2 class="jh-entity-heading" data-cy="proposalDetailsHeading">
          <span v-text="$t('myappApp.proposal.detail.title')">Proposal</span> {{ proposal.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('myappApp.proposal.name')">Name</span>
          </dt>
          <dd>
            <span>{{ proposal.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.customerName')">Customer Name</span>
          </dt>
          <dd>
            <span>{{ proposal.customerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.customerEmail')">Customer Email</span>
          </dt>
          <dd>
            <span>{{ proposal.customerEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.state')">State</span>
          </dt>
          <dd>
            <span>{{ proposal.state }}</span>
          </dd>
          <dt>
            <span v-text="$t('myappApp.proposal.travelServices')">Travel Services</span>
          </dt>
          <dd>
            <span>{{ proposal.travelServices }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./proposal-details.component.ts"></script>
