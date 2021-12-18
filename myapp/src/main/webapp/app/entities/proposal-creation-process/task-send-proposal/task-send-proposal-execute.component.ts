import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskSendProposalService from './task-send-proposal.service';
import { TaskSendProposalContext } from './task-send-proposal.model';

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
export default class TaskSendProposalExecuteComponent extends Vue {
  private taskSendProposalService: TaskSendProposalService = new TaskSendProposalService();
  private taskContext: TaskSendProposalContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskSendProposalService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskSendProposalService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
