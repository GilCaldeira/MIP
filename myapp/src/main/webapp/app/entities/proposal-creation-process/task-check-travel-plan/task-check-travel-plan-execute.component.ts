import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCheckTravelPlanService from './task-check-travel-plan.service';
import { TaskCheckTravelPlanContext } from './task-check-travel-plan.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        travelName: {},
        customerName: {},
        travelStartDate: {},
        travelEndDate: {},
        travelType: {},
        suggestedAirlines: {},
        suggestedHotels: {},
        otherTravelServices: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskCheckTravelPlanExecuteComponent extends Vue {
  private taskCheckTravelPlanService: TaskCheckTravelPlanService = new TaskCheckTravelPlanService();
  private taskContext: TaskCheckTravelPlanContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskCheckTravelPlanService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskCheckTravelPlanService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
