import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProposalCreationProcess } from '@/shared/model/proposal-creation-process.model';
import ProposalCreationProcessService from './proposal-creation-process.service';

@Component
export default class ProposalCreationProcessDetailsComponent extends Vue {
  @Inject('proposalCreationProcessService') private proposalCreationProcessService: () => ProposalCreationProcessService;
  public proposalCreationProcess: IProposalCreationProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveProposalCreationProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveProposalCreationProcess(proposalCreationProcessId) {
    this.isFetching = true;
    this.proposalCreationProcessService()
      .find(proposalCreationProcessId)
      .then(
        res => {
          this.proposalCreationProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
