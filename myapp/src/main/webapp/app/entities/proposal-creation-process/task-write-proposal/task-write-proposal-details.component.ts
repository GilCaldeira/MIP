import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskWriteProposalService from './task-write-proposal.service';
import { TaskWriteProposalContext } from './task-write-proposal.model';

@Component
export default class TaskWriteProposalDetailsComponent extends Vue {
  private taskWriteProposalService: TaskWriteProposalService = new TaskWriteProposalService();
  private taskContext: TaskWriteProposalContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskWriteProposalService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
