import { Component, Vue, Inject } from 'vue-property-decorator';

import AirlineCompanyService from '@/entities/airline-company/airline-company.service';
import { IAirlineCompany } from '@/shared/model/airline-company.model';

import HotelService from '@/entities/hotel/hotel.service';
import { IHotel } from '@/shared/model/hotel.model';

import TaskProposalReviewService from './task-proposal-review.service';
import { TaskProposalReviewContext } from './task-proposal-review.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        name: {},
        travelName: {},
        customerName: {},
        travelStartDate: {},
        travelEndDate: {},
        travelType: {},
        examplesOtherTravelServices: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskProposalReviewExecuteComponent extends Vue {
  private taskProposalReviewService: TaskProposalReviewService = new TaskProposalReviewService();
  private taskContext: TaskProposalReviewContext = {};

  @Inject('airlineCompanyService') private airlineCompanyService: () => AirlineCompanyService;

  public airlineCompanies: IAirlineCompany[] = [];

  @Inject('hotelService') private hotelService: () => HotelService;

  public hotels: IHotel[] = [];
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
    this.taskProposalReviewService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskProposalReviewService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.airlineCompanyService()
      .retrieve()
      .then(res => {
        this.airlineCompanies = res.data;
      });
    this.hotelService()
      .retrieve()
      .then(res => {
        this.hotels = res.data;
      });
  }
}
