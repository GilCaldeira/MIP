import axios from 'axios';
import { TaskBookHotelContext } from './task-book-hotel.model';

const baseApiUrl = 'api/proposal-creation-process/task-book-hotel';

export default class TaskBookHotelService {
  public loadContext(taskId: number): Promise<TaskBookHotelContext> {
    return new Promise<TaskBookHotelContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskBookHotelContext> {
    return new Promise<TaskBookHotelContext>((resolve, reject) => {
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

  public complete(taskBookHotelContext: TaskBookHotelContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskBookHotelContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
