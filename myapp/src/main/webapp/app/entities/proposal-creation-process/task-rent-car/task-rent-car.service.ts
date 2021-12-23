import axios from 'axios';
import { TaskRentCarContext } from './task-rent-car.model';

const baseApiUrl = 'api/proposal-creation-process/task-rent-car';

export default class TaskRentCarService {
  public loadContext(taskId: number): Promise<TaskRentCarContext> {
    return new Promise<TaskRentCarContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskRentCarContext> {
    return new Promise<TaskRentCarContext>((resolve, reject) => {
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

  public complete(taskRentCarContext: TaskRentCarContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRentCarContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
