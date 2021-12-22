/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import TravelPlanService from '@/entities/travel-plan/travel-plan.service';
import { TravelPlan } from '@/shared/model/travel-plan.model';

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
  describe('TravelPlan Service', () => {
    let service: TravelPlanService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new TravelPlanService();
      currentDate = new Date();
      elemDefault = new TravelPlan(0, 'AAAAAAA', currentDate, currentDate, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
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

      it('should create a TravelPlan', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            travelStartDate: dayjs(currentDate).format(DATE_FORMAT),
            travelEndDate: dayjs(currentDate).format(DATE_FORMAT),
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

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a TravelPlan', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a TravelPlan', async () => {
        const returnedFromService = Object.assign(
          {
            travelName: 'BBBBBB',
            travelStartDate: dayjs(currentDate).format(DATE_FORMAT),
            travelEndDate: dayjs(currentDate).format(DATE_FORMAT),
            travelType: 'BBBBBB',
            suggestedAirlines: 'BBBBBB',
            suggestedHotels: 'BBBBBB',
            otherTravelServices: 'BBBBBB',
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
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a TravelPlan', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a TravelPlan', async () => {
        const patchObject = Object.assign(
          {
            travelType: 'BBBBBB',
            suggestedAirlines: 'BBBBBB',
            suggestedHotels: 'BBBBBB',
            otherTravelServices: 'BBBBBB',
          },
          new TravelPlan()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            travelStartDate: currentDate,
            travelEndDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a TravelPlan', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of TravelPlan', async () => {
        const returnedFromService = Object.assign(
          {
            travelName: 'BBBBBB',
            travelStartDate: dayjs(currentDate).format(DATE_FORMAT),
            travelEndDate: dayjs(currentDate).format(DATE_FORMAT),
            travelType: 'BBBBBB',
            suggestedAirlines: 'BBBBBB',
            suggestedHotels: 'BBBBBB',
            otherTravelServices: 'BBBBBB',
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

      it('should not return a list of TravelPlan', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a TravelPlan', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a TravelPlan', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
