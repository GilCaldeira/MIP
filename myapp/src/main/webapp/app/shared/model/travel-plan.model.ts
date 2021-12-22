import { ICustomer } from '@/shared/model/customer.model';

export interface ITravelPlan {
  id?: number;
  travelName?: string | null;
  travelStartDate?: Date | null;
  travelEndDate?: Date | null;
  travelType?: string | null;
  suggestedAirlines?: string | null;
  suggestedHotels?: string | null;
  otherTravelServices?: string | null;
  customer?: ICustomer | null;
}

export class TravelPlan implements ITravelPlan {
  constructor(
    public id?: number,
    public travelName?: string | null,
    public travelStartDate?: Date | null,
    public travelEndDate?: Date | null,
    public travelType?: string | null,
    public suggestedAirlines?: string | null,
    public suggestedHotels?: string | null,
    public otherTravelServices?: string | null,
    public customer?: ICustomer | null
  ) {}
}
