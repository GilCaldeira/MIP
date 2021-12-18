import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCheckTravelPlanService from './task-check-travel-plan.service';
import { TaskCheckTravelPlanContext } from './task-check-travel-plan.model';

@Component
export default class TaskCheckTravelPlanDetailsComponent extends Vue {
  private taskCheckTravelPlanService: TaskCheckTravelPlanService = new TaskCheckTravelPlanService();
  private taskContext: TaskCheckTravelPlanContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskCheckTravelPlanService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
