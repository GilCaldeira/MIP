import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskAnalyzeCustomerFeedbackService from './task-analyze-customer-feedback.service';
import { TaskAnalyzeCustomerFeedbackContext } from './task-analyze-customer-feedback.model';

@Component
export default class TaskAnalyzeCustomerFeedbackDetailsComponent extends Vue {
  private taskAnalyzeCustomerFeedbackService: TaskAnalyzeCustomerFeedbackService = new TaskAnalyzeCustomerFeedbackService();
  private taskContext: TaskAnalyzeCustomerFeedbackContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskAnalyzeCustomerFeedbackService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
