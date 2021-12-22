import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskProposalReviewService from './task-proposal-review.service';
import { TaskProposalReviewContext } from './task-proposal-review.model';

@Component
export default class TaskProposalReviewDetailsComponent extends Vue {
  private taskProposalReviewService: TaskProposalReviewService = new TaskProposalReviewService();
  private taskContext: TaskProposalReviewContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskProposalReviewService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
