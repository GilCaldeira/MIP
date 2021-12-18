import { Component, Vue, Inject } from 'vue-property-decorator';

import { IProposal } from '@/shared/model/proposal.model';
import ProposalService from './proposal.service';

@Component
export default class ProposalDetails extends Vue {
  @Inject('proposalService') private proposalService: () => ProposalService;
  public proposal: IProposal = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.proposalId) {
        vm.retrieveProposal(to.params.proposalId);
      }
    });
  }

  public retrieveProposal(proposalId) {
    this.proposalService()
      .find(proposalId)
      .then(res => {
        this.proposal = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
