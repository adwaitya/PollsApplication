import { HttpInterceptor, HttpResponse, HttpErrorResponse, HttpEvent, HttpRequest, HttpHandler } from '@angular/common/http';
import { Injector } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../../../core/services/auth.service';
import 'rxjs/add/operator/do';
export class TokenInterceptor implements HttpInterceptor {
    constructor(){
        
    }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (!req.headers.has('Content-Type')) {
            req = req.clone({ headers: req.headers.set('Content-Type', 'application/json') });
        }

        req = req.clone({ headers: req.headers.set('Accept', 'application/json') });
        // start our loader here
        // this.spinnerService.show();

        return next.handle(req).do((event: HttpEvent<any>) => {
            // if the event is for http response
            if (event instanceof HttpResponse) {

                // stop our loader here
                // this.spinnerService.hide();
            }

        }, (err: any) => {
            // this.blockUI.stop();
            // if any error (not for just HttpResponse) we stop our loader bar
            //   this.spinnerService.hide();
        });
    }
}