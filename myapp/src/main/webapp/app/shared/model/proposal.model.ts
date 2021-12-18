export interface IProposal {
  id?: number;
  name?: string | null;
  customerName?: string | null;
  customerEmail?: string | null;
  state?: string | null;
  travelServices?: string | null;
}

export class Proposal implements IProposal {
  constructor(
    public id?: number,
    public name?: string | null,
    public customerName?: string | null,
    public customerEmail?: string | null,
    public state?: string | null,
    public travelServices?: string | null
  ) {}
}
