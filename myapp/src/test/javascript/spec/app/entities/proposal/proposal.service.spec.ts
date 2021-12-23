/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import ProposalService from '@/entities/proposal/proposal.service';
import { Proposal } from '@/shared/model/proposal.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('Proposal Service', () => {
    let service: ProposalService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ProposalService();
      currentDate = new Date();
      elemDefault = new Proposal(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            travelStartDate: dayjs(currentDate).format(DATE_FORMAT),
            travelEndDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Proposal', async () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            customerName: 'BBBBBB',
            customerEmail: 'BBBBBB',
            travelName: 'BBBBBB',
            travelStartDate: dayjs(currentDate).format(DATE_FORMAT),
            travelEndDate: dayjs(currentDate).format(DATE_FORMAT),
            travelType: 'BBBBBB',
            suggestedAirlines: 'BBBBBB',
            suggestedHotels: 'BBBBBB',
            otherSuggestedTravelServices: 'BBBBBB',
            state: 'BBBBBB',
            customerFeedback: 'BBBBBB',
            examplesOtherTravelServices: 'BBBBBB',
            airlineTicketNumber: 'BBBBBB',
            hotelBookingNumber: 'BBBBBB',
            carBookingNumber: 'BBBBBB',
            carRentalIncluded: true,
            applicationUserName: 'BBBBBB',
            applicationPassword: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            travelStartDate: currentDate,
            travelEndDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Proposal', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
