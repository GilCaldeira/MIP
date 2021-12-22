import { Component, Vue, Inject } from 'vue-property-decorator';

import AirlineCompanyService from '@/entities/airline-company/airline-company.service';
import { IAirlineCompany } from '@/shared/model/airline-company.model';

import HotelService from '@/entities/hotel/hotel.service';
import { IHotel } from '@/shared/model/hotel.model';

import TaskWriteProposalService from './task-write-proposal.service';
import { TaskWriteProposalContext } from './task-write-proposal.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        travelName: {},
        customerName: {},
        travelStartDate: {},
        travelEndDate: {},
        examplesOtherTravelServices: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskWriteProposalExecuteComponent extends Vue {
  private taskWriteProposalService: TaskWriteProposalService = new TaskWriteProposalService();
  private taskContext: TaskWriteProposalContext = {};

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
    this.taskWriteProposalService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskWriteProposalService.complete(this.taskContext).then(res => {
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
