import axios from 'axios';
import { TaskAddAccessCredentialsContext } from './task-add-access-credentials.model';

const baseApiUrl = 'api/proposal-creation-process/task-add-access-credentials';

export default class TaskAddAccessCredentialsService {
  public loadContext(taskId: number): Promise<TaskAddAccessCredentialsContext> {
    return new Promise<TaskAddAccessCredentialsContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskAddAccessCredentialsContext> {
    return new Promise<TaskAddAccessCredentialsContext>((resolve, reject) => {
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

  public complete(taskAddAccessCredentialsContext: TaskAddAccessCredentialsContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskAddAccessCredentialsContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
