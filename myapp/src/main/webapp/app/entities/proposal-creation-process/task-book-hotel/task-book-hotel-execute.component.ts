import { Component, Vue, Inject } from 'vue-property-decorator';

import HotelService from '@/entities/hotel/hotel.service';
import { IHotel } from '@/shared/model/hotel.model';

import TaskBookHotelService from './task-book-hotel.service';
import { TaskBookHotelContext } from './task-book-hotel.model';

const validations: any = {
  taskContext: {
    proposalCreationProcess: {
      proposal: {
        travelName: {},
        travelStartDate: {},
        travelEndDate: {},
        airlineTicketNumber: {},
        hotelBookingNumber: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskBookHotelExecuteComponent extends Vue {
  private taskBookHotelService: TaskBookHotelService = new TaskBookHotelService();
  private taskContext: TaskBookHotelContext = {};

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
    this.taskBookHotelService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskBookHotelService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.hotelService()
      .retrieve()
      .then(res => {
        this.hotels = res.data;
      });
  }
}
