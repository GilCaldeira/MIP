import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskSendProposalService from './task-send-proposal.service';
import { TaskSendProposalContext } from './task-send-proposal.model';

@Component
export default class TaskSendProposalDetailsComponent extends Vue {
  private taskSendProposalService: TaskSendProposalService = new TaskSendProposalService();
  private taskContext: TaskSendProposalContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskSendProposalService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
