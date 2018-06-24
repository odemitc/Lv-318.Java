import {Injectable} from '@angular/core';
import {TokenStorage} from '../token/token-storage';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/do';
import {environment} from '../../../../environments/environment';


@Injectable()
export class InterceptorService implements HttpInterceptor {

  private accessTokenHeader = environment.accessTokenHeader;
  private serverURL = environment.serverURL;

  constructor(private tokenStorage: TokenStorage) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.url.startsWith(this.serverURL) && this.tokenStorage.getAccessToken() && !this.tokenStorage.isExpired()) {
      req = this.addAuthHeaderToRequest(req);
    }
    return next.handle(req);
  }

  private addAuthHeaderToRequest(request: HttpRequest<any>): HttpRequest<any> {
    return request.clone({
      headers: request.headers.append(this.accessTokenHeader, this.tokenStorage.getAccessToken())
    });
  }
}
