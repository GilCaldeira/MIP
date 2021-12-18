import axios from 'axios';
import { TaskSendProposalContext } from './task-send-proposal.model';

const baseApiUrl = 'api/proposal-creation-process/task-send-proposal';

export default class TaskSendProposalService {
  public loadContext(taskId: number): Promise<TaskSendProposalContext> {
    return new Promise<TaskSendProposalContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskSendProposalContext> {
    return new Promise<TaskSendProposalContext>((resolve, reject) => {
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

  public complete(taskSendProposalContext: TaskSendProposalContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskSendProposalContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
