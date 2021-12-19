import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskAnalyzeCustomerFeedbackService from './task-analyze-customer-feedback.service';
import { TaskAnalyzeCustomerFeedbackContext } from './task-analyze-customer-feedback.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        name: {},
        customerName: {},
        customerEmail: {},
        state: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskAnalyzeCustomerFeedbackExecuteComponent extends Vue {
  private taskAnalyzeCustomerFeedbackService: TaskAnalyzeCustomerFeedbackService = new TaskAnalyzeCustomerFeedbackService();
  private taskContext: TaskAnalyzeCustomerFeedbackContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskAnalyzeCustomerFeedbackService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskAnalyzeCustomerFeedbackService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
