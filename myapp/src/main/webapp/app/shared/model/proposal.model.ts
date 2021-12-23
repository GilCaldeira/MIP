import { ICustomer } from '@/shared/model/customer.model';
import { ITravelPlan } from '@/shared/model/travel-plan.model';
import { IAirlineCompany } from '@/shared/model/airline-company.model';
import { IHotel } from '@/shared/model/hotel.model';
import { IRentalCarCompany } from '@/shared/model/rental-car-company.model';

export interface IProposal {
  id?: number;
  name?: string | null;
  customerName?: string | null;
  customerEmail?: string | null;
  travelName?: string | null;
  travelStartDate?: Date | null;
  travelEndDate?: Date | null;
  travelType?: string | null;
  suggestedAirlines?: string | null;
  suggestedHotels?: string | null;
  otherSuggestedTravelServices?: string | null;
  state?: string | null;
  customerFeedback?: string | null;
  examplesOtherTravelServices?: string | null;
  airlineTicketNumber?: string | null;
  hotelBookingNumber?: string | null;
  carBookingNumber?: string | null;
  carRentalIncluded?: boolean | null;
  applicationUserName?: string | null;
  applicationPassword?: string | null;
  customer?: ICustomer | null;
  travelPlan?: ITravelPlan | null;
  airlineCompany?: IAirlineCompany | null;
  hotel?: IHotel | null;
  rentalCarCompany?: IRentalCarCompany | null;
}

export class Proposal implements IProposal {
  constructor(
    public id?: number,
    public name?: string | null,
    public customerName?: string | null,
    public customerEmail?: string | null,
    public travelName?: string | null,
    public travelStartDate?: Date | null,
    public travelEndDate?: Date | null,
    public travelType?: string | null,
    public suggestedAirlines?: string | null,
    public suggestedHotels?: string | null,
    public otherSuggestedTravelServices?: string | null,
    public state?: string | null,
    public customerFeedback?: string | null,
    public examplesOtherTravelServices?: string | null,
    public airlineTicketNumber?: string | null,
    public hotelBookingNumber?: string | null,
    public carBookingNumber?: string | null,
    public carRentalIncluded?: boolean | null,
    public applicationUserName?: string | null,
    public applicationPassword?: string | null,
    public customer?: ICustomer | null,
    public travelPlan?: ITravelPlan | null,
    public airlineCompany?: IAirlineCompany | null,
    public hotel?: IHotel | null,
    public rentalCarCompany?: IRentalCarCompany | null
  ) {
    this.carRentalIncluded = this.carRentalIncluded ?? false;
  }
}
