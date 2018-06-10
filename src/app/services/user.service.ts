import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {User} from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {
  }

  private userUrl = 'http://localhost:8080/user';


  public deleteUser(user) {
    return this.http.delete(this.userUrl, user);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }
  getUser(login) {
    return this.http.get<User>(this.userUrl + '/in', {
      params: {
        email: login.email.toString(),
        password: login.password.toString(),

      }
      });
  }
}
