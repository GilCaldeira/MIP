import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskAddAccessCredentialsService from './task-add-access-credentials.service';
import { TaskAddAccessCredentialsContext } from './task-add-access-credentials.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        customerName: {},
        travelStartDate: {},
        travelEndDate: {},
        applicationUserName: {},
        applicationPassword: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskAddAccessCredentialsExecuteComponent extends Vue {
  private taskAddAccessCredentialsService: TaskAddAccessCredentialsService = new TaskAddAccessCredentialsService();
  private taskContext: TaskAddAccessCredentialsContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskAddAccessCredentialsService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskAddAccessCredentialsService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
