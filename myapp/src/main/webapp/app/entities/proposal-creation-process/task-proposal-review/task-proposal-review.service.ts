import axios from 'axios';
import { TaskProposalReviewContext } from './task-proposal-review.model';

const baseApiUrl = 'api/proposal-creation-process/task-proposal-review';

export default class TaskProposalReviewService {
  public loadContext(taskId: number): Promise<TaskProposalReviewContext> {
    return new Promise<TaskProposalReviewContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskProposalReviewContext> {
    return new Promise<TaskProposalReviewContext>((resolve, reject) => {
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

  public complete(taskProposalReviewContext: TaskProposalReviewContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskProposalReviewContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
