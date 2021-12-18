import axios from 'axios';
import { TaskCheckTravelPlanContext } from './task-check-travel-plan.model';

const baseApiUrl = 'api/proposal-creation-process/task-check-travel-plan';

export default class TaskCheckTravelPlanService {
  public loadContext(taskId: number): Promise<TaskCheckTravelPlanContext> {
    return new Promise<TaskCheckTravelPlanContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskCheckTravelPlanContext> {
    return new Promise<TaskCheckTravelPlanContext>((resolve, reject) => {
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

  public complete(taskCheckTravelPlanContext: TaskCheckTravelPlanContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskCheckTravelPlanContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
