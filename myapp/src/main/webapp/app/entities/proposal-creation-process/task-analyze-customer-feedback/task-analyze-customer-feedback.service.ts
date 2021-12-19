import axios from 'axios';
import { TaskAnalyzeCustomerFeedbackContext } from './task-analyze-customer-feedback.model';

const baseApiUrl = 'api/proposal-creation-process/task-analyze-customer-feedback';

export default class TaskAnalyzeCustomerFeedbackService {
  public loadContext(taskId: number): Promise<TaskAnalyzeCustomerFeedbackContext> {
    return new Promise<TaskAnalyzeCustomerFeedbackContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskAnalyzeCustomerFeedbackContext> {
    return new Promise<TaskAnalyzeCustomerFeedbackContext>((resolve, reject) => {
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

  public complete(taskAnalyzeCustomerFeedbackContext: TaskAnalyzeCustomerFeedbackContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskAnalyzeCustomerFeedbackContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
