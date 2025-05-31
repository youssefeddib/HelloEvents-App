import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        console.error('🔍 Intercepteur d\'erreur HTTP:');
        console.error('URL:', request.url);
        console.error('Méthode:', request.method);
        console.error('Headers:', request.headers.keys());
        console.error('Corps de la requête:', request.body);
        console.error('Statut de l\'erreur:', error.status);
        console.error('Message d\'erreur:', error.message);

        if (error.status === 0) {
          // Erreur de connexion ou CORS
          const errorDetails = {
            url: request.url,
            method: request.method,
            headers: request.headers.keys(),
            error: error.message,
            type: error.type,
            name: error.name
          };
          console.error('Détails de l\'erreur de connexion:', errorDetails);
        }

        return throwError(() => error);
      })
    );
  }
} 