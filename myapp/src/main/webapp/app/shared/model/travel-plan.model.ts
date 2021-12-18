export interface ITravelPlan {
  id?: number;
  travelName?: string | null;
  travelStartDate?: Date | null;
  travelEndDate?: Date | null;
  customerName?: string | null;
  travelServices?: string | null;
}

export class TravelPlan implements ITravelPlan {
  constructor(
    public id?: number,
    public travelName?: string | null,
    public travelStartDate?: Date | null,
    public travelEndDate?: Date | null,
    public customerName?: string | null,
    public travelServices?: string | null
  ) {}
}
