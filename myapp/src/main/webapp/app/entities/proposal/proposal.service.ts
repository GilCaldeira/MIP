import axios from 'axios';

import { IProposal } from '@/shared/model/proposal.model';

const baseApiUrl = 'api/proposals';

export default class ProposalService {
  public find(id: number): Promise<IProposal> {
    return new Promise<IProposal>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
