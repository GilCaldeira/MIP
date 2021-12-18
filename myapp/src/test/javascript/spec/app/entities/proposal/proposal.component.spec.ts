/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ProposalComponent from '@/entities/proposal/proposal.vue';
import ProposalClass from '@/entities/proposal/proposal.component';
import ProposalService from '@/entities/proposal/proposal.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Proposal Management Component', () => {
    let wrapper: Wrapper<ProposalClass>;
    let comp: ProposalClass;
    let proposalServiceStub: SinonStubbedInstance<ProposalService>;

    beforeEach(() => {
      proposalServiceStub = sinon.createStubInstance<ProposalService>(ProposalService);
      proposalServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<ProposalClass>(ProposalComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          proposalService: () => proposalServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      proposalServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllProposals();
      await comp.$nextTick();

      // THEN
      expect(proposalServiceStub.retrieve.called).toBeTruthy();
      expect(comp.proposals[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
