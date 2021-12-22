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
// prettier-ignore
const ProposalCreationProcess_TaskAnalyzeCustomerFeedbackDetails = () => import('@/entities/proposal-creation-process/task-analyze-customer-feedback/task-analyze-customer-feedback-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskAnalyzeCustomerFeedbackExecute = () => import('@/entities/proposal-creation-process/task-analyze-customer-feedback/task-analyze-customer-feedback-execute.vue');
// prettier-ignore
const Customer = () => import('@/entities/customer/customer.vue');
// prettier-ignore
const CustomerUpdate = () => import('@/entities/customer/customer-update.vue');
// prettier-ignore
const CustomerDetails = () => import('@/entities/customer/customer-details.vue');
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
const ProposalCreationProcess_TaskAnalyzeCustomerFeedbackDetails = () => import('@/entities/proposal-creation-process/task-analyze-customer-feedback/task-analyze-customer-feedback-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskAnalyzeCustomerFeedbackExecute = () => import('@/entities/proposal-creation-process/task-analyze-customer-feedback/task-analyze-customer-feedback-execute.vue');
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
// prettier-ignore
const Hotel = () => import('@/entities/hotel/hotel.vue');
// prettier-ignore
const HotelUpdate = () => import('@/entities/hotel/hotel-update.vue');
// prettier-ignore
const HotelDetails = () => import('@/entities/hotel/hotel-details.vue');
// prettier-ignore
const AirlineCompany = () => import('@/entities/airline-company/airline-company.vue');
// prettier-ignore
const AirlineCompanyUpdate = () => import('@/entities/airline-company/airline-company-update.vue');
// prettier-ignore
const AirlineCompanyDetails = () => import('@/entities/airline-company/airline-company-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskProposalReviewDetails = () => import('@/entities/proposal-creation-process/task-proposal-review/task-proposal-review-details.vue');
// prettier-ignore
const ProposalCreationProcess_TaskProposalReviewExecute = () => import('@/entities/proposal-creation-process/task-proposal-review/task-proposal-review-execute.vue');
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
  {
    path: '/process-definition/ProposalCreationProcess/task/AnalyzeCustomerFeedback/:taskInstanceId/view',
    name: 'ProposalCreationProcess_TaskAnalyzeCustomerFeedbackDetails',
    component: ProposalCreationProcess_TaskAnalyzeCustomerFeedbackDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/AnalyzeCustomerFeedback/:taskInstanceId/execute',
    name: 'ProposalCreationProcess_TaskAnalyzeCustomerFeedbackExecute',
    component: ProposalCreationProcess_TaskAnalyzeCustomerFeedbackExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/customer',
    name: 'Customer',
    component: Customer,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/customer/new',
    name: 'CustomerCreate',
    component: CustomerUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/customer/:customerId/edit',
    name: 'CustomerEdit',
    component: CustomerUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/customer/:customerId/view',
    name: 'CustomerView',
    component: CustomerDetails,
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
    path: '/process-definition/ProposalCreationProcess/task/AnalyzeCustomerFeedback/:taskInstanceId/view',
    name: 'ProposalCreationProcess_TaskAnalyzeCustomerFeedbackDetails',
    component: ProposalCreationProcess_TaskAnalyzeCustomerFeedbackDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/AnalyzeCustomerFeedback/:taskInstanceId/execute',
    name: 'ProposalCreationProcess_TaskAnalyzeCustomerFeedbackExecute',
    component: ProposalCreationProcess_TaskAnalyzeCustomerFeedbackExecute,
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
  {
    path: '/hotel',
    name: 'Hotel',
    component: Hotel,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/hotel/new',
    name: 'HotelCreate',
    component: HotelUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/hotel/:hotelId/edit',
    name: 'HotelEdit',
    component: HotelUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/hotel/:hotelId/view',
    name: 'HotelView',
    component: HotelDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/airline-company',
    name: 'AirlineCompany',
    component: AirlineCompany,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/airline-company/new',
    name: 'AirlineCompanyCreate',
    component: AirlineCompanyUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/airline-company/:airlineCompanyId/edit',
    name: 'AirlineCompanyEdit',
    component: AirlineCompanyUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/airline-company/:airlineCompanyId/view',
    name: 'AirlineCompanyView',
    component: AirlineCompanyDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/ProposalReview/:taskInstanceId/view',
    name: 'ProposalCreationProcess_TaskProposalReviewDetails',
    component: ProposalCreationProcess_TaskProposalReviewDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/ProposalCreationProcess/task/ProposalReview/:taskInstanceId/execute',
    name: 'ProposalCreationProcess_TaskProposalReviewExecute',
    component: ProposalCreationProcess_TaskProposalReviewExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
