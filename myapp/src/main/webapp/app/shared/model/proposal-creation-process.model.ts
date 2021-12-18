import { IProposal } from '@/shared/model/proposal.model';

export interface IProposalCreationProcess {
  id?: number;
  processInstance?: any | null;
  proposal?: IProposal | null;
}

export class ProposalCreationProcess implements IProposalCreationProcess {
  constructor(public id?: number, public processInstance?: any | null, public proposal?: IProposal | null) {}
}
