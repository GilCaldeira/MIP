import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBookHotelService from './task-book-hotel.service';
import { TaskBookHotelContext } from './task-book-hotel.model';

@Component
export default class TaskBookHotelDetailsComponent extends Vue {
  private taskBookHotelService: TaskBookHotelService = new TaskBookHotelService();
  private taskContext: TaskBookHotelContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskBookHotelService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
