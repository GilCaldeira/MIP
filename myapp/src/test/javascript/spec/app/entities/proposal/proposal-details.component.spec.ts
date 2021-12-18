/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import ProposalDetailComponent from '@/entities/proposal/proposal-details.vue';
import ProposalClass from '@/entities/proposal/proposal-details.component';
import ProposalService from '@/entities/proposal/proposal.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Proposal Management Detail Component', () => {
    let wrapper: Wrapper<ProposalClass>;
    let comp: ProposalClass;
    let proposalServiceStub: SinonStubbedInstance<ProposalService>;

    beforeEach(() => {
      proposalServiceStub = sinon.createStubInstance<ProposalService>(ProposalService);

      wrapper = shallowMount<ProposalClass>(ProposalDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { proposalService: () => proposalServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundProposal = { id: 123 };
        proposalServiceStub.find.resolves(foundProposal);

        // WHEN
        comp.retrieveProposal(123);
        await comp.$nextTick();

        // THEN
        expect(comp.proposal).toBe(foundProposal);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundProposal = { id: 123 };
        proposalServiceStub.find.resolves(foundProposal);

        // WHEN
        comp.beforeRouteEnter({ params: { proposalId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.proposal).toBe(foundProposal);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
