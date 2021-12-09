import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { BasicApiService } from './basic-api.service';
import { LLDDHealthProblem } from './model/lldd-health-problem';
import { AppConfigService } from './service/app-config.service';
import { MessageService } from './service/message.service';

@Injectable({
  providedIn: 'root'
})
export class LLDDHealthProblemService extends BasicApiService {

  private url = '/lldd-health-problems';

  constructor(
    protected config: AppConfigService,
    protected http: HttpClient,
    protected messageService: MessageService    
  ) {
    super(http, messageService);
    this.url = config.getConfig().apiUrl + '/lldd-health-problems';
   }

   getLLDDHealthProblems(): Observable<LLDDHealthProblem[]> {
    return this.http.get<LLDDHealthProblem[]>(this.url)
    .pipe(
      tap(_ => this.log('fetched LlddHealthProblems')),
        catchError(this.handleError<LLDDHealthProblem[]>('getLLDDHealthProblems', []))
      );
  }
}
