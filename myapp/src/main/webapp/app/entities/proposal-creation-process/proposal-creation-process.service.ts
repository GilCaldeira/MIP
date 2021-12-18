import axios from 'axios';

import { IProposalCreationProcess } from '@/shared/model/proposal-creation-process.model';

const baseApiUrl = 'api/proposal-creation-processes';

export default class ProposalCreationProcessService {
  public find(id: number): Promise<IProposalCreationProcess> {
    return new Promise<IProposalCreationProcess>((resolve, reject) => {
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

  public create(entity: IProposalCreationProcess): Promise<IProposalCreationProcess> {
    return new Promise<IProposalCreationProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
