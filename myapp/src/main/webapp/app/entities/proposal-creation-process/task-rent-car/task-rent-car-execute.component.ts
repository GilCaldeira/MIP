import { Component, Vue, Inject } from 'vue-property-decorator';

import RentalCarCompanyService from '@/entities/rental-car-company/rental-car-company.service';
import { IRentalCarCompany } from '@/shared/model/rental-car-company.model';

import TaskRentCarService from './task-rent-car.service';
import { TaskRentCarContext } from './task-rent-car.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        travelName: {},
        travelStartDate: {},
        travelEndDate: {},
        carBookingNumber: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRentCarExecuteComponent extends Vue {
  private taskRentCarService: TaskRentCarService = new TaskRentCarService();
  private taskContext: TaskRentCarContext = {};

  @Inject('rentalCarCompanyService') private rentalCarCompanyService: () => RentalCarCompanyService;

  public rentalCarCompanies: IRentalCarCompany[] = [];
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
    this.taskRentCarService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRentCarService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.rentalCarCompanyService()
      .retrieve()
      .then(res => {
        this.rentalCarCompanies = res.data;
      });
  }
}
