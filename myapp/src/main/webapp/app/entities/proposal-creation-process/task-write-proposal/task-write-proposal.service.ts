import axios from 'axios';
import { TaskWriteProposalContext } from './task-write-proposal.model';

const baseApiUrl = 'api/proposal-creation-process/task-write-proposal';

export default class TaskWriteProposalService {
  public loadContext(taskId: number): Promise<TaskWriteProposalContext> {
    return new Promise<TaskWriteProposalContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskWriteProposalContext> {
    return new Promise<TaskWriteProposalContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskWriteProposalContext: TaskWriteProposalContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskWriteProposalContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
