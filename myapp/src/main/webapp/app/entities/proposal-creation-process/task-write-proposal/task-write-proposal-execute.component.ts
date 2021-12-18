import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskWriteProposalService from './task-write-proposal.service';
import { TaskWriteProposalContext } from './task-write-proposal.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        name: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskWriteProposalExecuteComponent extends Vue {
  private taskWriteProposalService: TaskWriteProposalService = new TaskWriteProposalService();
  private taskContext: TaskWriteProposalContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskWriteProposalService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskWriteProposalService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
