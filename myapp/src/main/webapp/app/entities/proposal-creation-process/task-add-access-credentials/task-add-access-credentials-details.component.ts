import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskAddAccessCredentialsService from './task-add-access-credentials.service';
import { TaskAddAccessCredentialsContext } from './task-add-access-credentials.model';

@Component
export default class TaskAddAccessCredentialsDetailsComponent extends Vue {
  private taskAddAccessCredentialsService: TaskAddAccessCredentialsService = new TaskAddAccessCredentialsService();
  private taskContext: TaskAddAccessCredentialsContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskAddAccessCredentialsService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
