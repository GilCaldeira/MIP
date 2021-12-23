import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRentCarService from './task-rent-car.service';
import { TaskRentCarContext } from './task-rent-car.model';

@Component
export default class TaskRentCarDetailsComponent extends Vue {
  private taskRentCarService: TaskRentCarService = new TaskRentCarService();
  private taskContext: TaskRentCarContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRentCarService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
