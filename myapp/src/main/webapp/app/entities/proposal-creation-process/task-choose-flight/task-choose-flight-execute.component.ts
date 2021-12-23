import { Component, Vue, Inject } from 'vue-property-decorator';

import AirlineCompanyService from '@/entities/airline-company/airline-company.service';
import { IAirlineCompany } from '@/shared/model/airline-company.model';

import TaskChooseFlightService from './task-choose-flight.service';
import { TaskChooseFlightContext } from './task-choose-flight.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        travelName: {},
        travelStartDate: {},
        travelEndDate: {},
        airlineTicketNumber: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskChooseFlightExecuteComponent extends Vue {
  private taskChooseFlightService: TaskChooseFlightService = new TaskChooseFlightService();
  private taskContext: TaskChooseFlightContext = {};

  @Inject('airlineCompanyService') private airlineCompanyService: () => AirlineCompanyService;

  public airlineCompanies: IAirlineCompany[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
      vm.initRelationships();
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskChooseFlightService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskChooseFlightService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.airlineCompanyService()
      .retrieve()
      .then(res => {
        this.airlineCompanies = res.data;
      });
  }
}
