import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IProposal } from '@/shared/model/proposal.model';

import ProposalService from './proposal.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Proposal extends Vue {
  @Inject('proposalService') private proposalService: () => ProposalService;
  private removeId: number = null;

  public proposals: IProposal[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllProposals();
  }

  public clear(): void {
    this.retrieveAllProposals();
  }

  public retrieveAllProposals(): void {
    this.isFetching = true;

    this.proposalService()
      .retrieve()
      .then(
        res => {
          this.proposals = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
