import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { AppConfigService } from './app-config.service';

import { MessageService } from './message.service';
import { Student } from '../model/student';
import { BasicApiService } from '../basic-api.service';


@Injectable({
  providedIn: 'root'
})
export class StudentService extends BasicApiService {

  private url = '/students';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:8080'
   })
  };

  constructor(
    protected config: AppConfigService,
    protected http: HttpClient,
    protected messageService: MessageService
  ) {
    super(http, messageService);
    this.url = config.getConfig().apiUrl + '/students';
  }

  /** GET student by LinkId. Will 404 if id not found */
  getByLinkId(linkId: string): Observable<Student> {
    const url = `${this.url}?LinkId=${linkId}`;
    return this.http.get<Student>(url).pipe(
      tap(_ => this.log(`fetched student with LinkId=${linkId}`)),
      catchError(this.handleError<Student>(`getByLinkId linkId=${linkId}`))
    );
  }

  save(student: Student, id: string): Observable<Student>{
    console.log('Attempting Acceptance registration update');
    const url = `${this.url}/acceptance-registration`;
    return this.http.post<Student>(url, student, this.httpOptions).pipe(
      tap(_ => this.log(`updating student accepting registration form: ${student}`)),
      catchError(this.handleError<Student>(`update studentAcceptanceRegistration=${student}`))
    );
  }

}
