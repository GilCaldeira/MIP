import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const TravelPlan = () => import('@/entities/travel-plan/travel-plan.vue');
// prettier-ignore
const TravelPlanDetails = () => import('@/entities/travel-plan/travel-plan-details.vue');
// prettier-ignore
const TravelPlan = () => import('@/entities/travel-plan/travel-plan.vue');
// prettier-ignore
const TravelPlanUpdate = () => import('@/entities/travel-plan/travel-plan-update.vue');
// prettier-ignore
const TravelPlanDetails = () => import('@/entities/travel-plan/travel-plan-details.vue');
// prettier-ignore
const Proposal = () => import('@/entities/proposal/proposal.vue');
// prettier-ignore
const ProposalDetails = () => import('@/entities/proposal/proposal-details.vue');
// prettier-ignore
const ProposalCreationProcessDetails = () => import('@/entities/proposal-creation-process/proposal-creation-process-details.vue');
// prettier-ignore
const ProposalCreationProcessList = () => import('@/entities/proposal-creation-process/proposal-creation-process-list.vue');
// prettier-ignore
const ProposalCreationStartFormInit = () => import('@/entities/proposal-creation-process/proposal-creation-start-form-init.vue');
// prettier-ignore
const ProposalCreationProcess_TaskCheckTravelPlanDetails = () => import('@/entities/proposal-creation-process/task-check-travel-plan/task-check-travel-plan-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskCheckTravelPlanExecute = () => import('@/entities/proposal-creation-process/task-check-travel-plan/task-check-travel-plan-execute.vue');
// prettier-ignore
const ProposalCreationProcess_TaskSendProposalDetails = () => import('@/entities/proposal-creation-process/task-send-proposal/task-send-proposal-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskSendProposalExecute = () => import('@/entities/proposal-creation-process/task-send-proposal/task-send-proposal-execute.vue');
// prettier-ignore
const ProposalCreationProcess_TaskWriteProposalDetails = () => import('@/entities/proposal-creation-process/task-write-proposal/task-write-proposal-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskWriteProposalExecute = () => import('@/entities/proposal-creation-process/task-write-proposal/task-write-proposal-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/travel-plan',
    name: 'TravelPlan',
    component: TravelPlan,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/travel-plan/:travelPlanId/view',
    name: 'TravelPlanView',
    component: TravelPlanDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/proposal',
    name: 'Proposal',
    component: Proposal,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/proposal/:proposalId/view',
    name: 'ProposalView',
    component: ProposalDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/instance/:processInstanceId/view',
    name: 'ProposalCreationProcessView',
    component: ProposalCreationProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/instances',
    name: 'ProposalCreationProcessList',
    component: ProposalCreationProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/init',
    name: 'ProposalCreationStartFormInit',
    component: ProposalCreationStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/CheckTravelPlan/:taskInstanceId/view',
    name: 'ProposalCreationProcess_TaskCheckTravelPlanDetails',
    component: ProposalCreationProcess_TaskCheckTravelPlanDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/CheckTravelPlan/:taskInstanceId/execute',
    name: 'ProposalCreationProcess_TaskCheckTravelPlanExecute',
    component: ProposalCreationProcess_TaskCheckTravelPlanExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/SendProposal/:taskInstanceId/view',
    name: 'ProposalCreationProcess_TaskSendProposalDetails',
    component: ProposalCreationProcess_TaskSendProposalDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/SendProposal/:taskInstanceId/execute',
    name: 'ProposalCreationProcess_TaskSendProposalExecute',
    component: ProposalCreationProcess_TaskSendProposalExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/WriteProposal/:taskInstanceId/view',
    name: 'ProposalCreationProcess_TaskWriteProposalDetails',
    component: ProposalCreationProcess_TaskWriteProposalDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/WriteProposal/:taskInstanceId/execute',
    name: 'ProposalCreationProcess_TaskWriteProposalExecute',
    component: ProposalCreationProcess_TaskWriteProposalExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
