import { Component, Vue, Inject } from 'vue-property-decorator';

import CustomerService from '@/entities/customer/customer.service'; //
import { ICustomer } from '@/shared/model/customer.model';

import TravelPlanService from '@/entities/travel-plan/travel-plan.service'; //
import { ITravelPlan } from '@/shared/model/travel-plan.model';

import { IProposalCreationProcess, ProposalCreationProcess } from '@/shared/model/proposal-creation-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Proposal } from '@/shared/model/proposal.model';
import ProposalCreationProcessService from './proposal-creation-process.service';

const validations: any = {
  proposalCreationProcess: {
    proposal: {
      name: {},
    },
  },
};

@Component({
  validations,
})
export default class ProposalCreationStartFormInitComponent extends Vue {
  @Inject('proposalCreationProcessService') private proposalCreationProcessService: () => ProposalCreationProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'ProposalCreationProcess';
  public proposalCreationProcess: IProposalCreationProcess = new ProposalCreationProcess();

  @Inject('customerService') private customerService: () => CustomerService;

  public customers: ICustomer[] = [];

  @Inject('travelPlanService') private travelPlanService: () => TravelPlanService;

  public travelPlans: ITravelPlan[] = [];

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initProposalCreationStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.proposalCreationProcessService()
      .create(this.proposalCreationProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('myappApp.proposalCreationStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initProposalCreationStartForm(): void {
    this.proposalCreationProcess.proposal = new Proposal();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.proposalCreationProcess.processInstance = new ProcessInstance();
      this.proposalCreationProcess.processInstance.processDefinition = res;
    });
    this.customerService()
      .retrieve()
      .then(res => {
        this.customers = res.data;
      });
    this.travelPlanService()
      .retrieve()
      .then(res => {
        this.travelPlans = res.data;
      });
  }
}
