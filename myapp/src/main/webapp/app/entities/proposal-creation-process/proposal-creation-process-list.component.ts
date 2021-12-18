import { Component, Vue, Inject } from 'vue-property-decorator';
import { IProposalCreationProcess } from '@/shared/model/proposal-creation-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import ProposalCreationProcessService from './proposal-creation-process.service';

@Component
export default class ProposalCreationProcessListComponent extends Vue {
  @Inject('proposalCreationProcessService') private proposalCreationProcessService: () => ProposalCreationProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'ProposalCreationProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public proposalCreationProcessList: IProposalCreationProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.proposalCreationProcessService()
      .retrieve()
      .then(
        res => {
          this.proposalCreationProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
