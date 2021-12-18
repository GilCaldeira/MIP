import { Component, Vue, Inject } from 'vue-property-decorator';

import { ITravelPlan, TravelPlan } from '@/shared/model/travel-plan.model';
import TravelPlanService from './travel-plan.service';

const validations: any = {
  travelPlan: {
    travelName: {},
    travelStartDate: {},
    travelEndDate: {},
    customerName: {},
    travelServices: {},
  },
};

@Component({
  validations,
})
export default class TravelPlanUpdate extends Vue {
  @Inject('travelPlanService') private travelPlanService: () => TravelPlanService;
  public travelPlan: ITravelPlan = new TravelPlan();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.travelPlanId) {
        vm.retrieveTravelPlan(to.params.travelPlanId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.travelPlan.id) {
      this.travelPlanService()
        .update(this.travelPlan)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('myappApp.travelPlan.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.travelPlanService()
        .create(this.travelPlan)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('myappApp.travelPlan.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public retrieveTravelPlan(travelPlanId): void {
    this.travelPlanService()
      .find(travelPlanId)
      .then(res => {
        this.travelPlan = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
