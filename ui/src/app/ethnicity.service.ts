import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { AppConfigService } from './service/app-config.service';

import { Ethnicity } from './model/ethnicity';
import { MessageService } from './service/message.service';
import { BasicApiService } from './basic-api.service';

@Injectable({
  providedIn: 'root'
})
export class EthnicityService extends BasicApiService {

  private url = '/ethnicities';

  constructor(
    protected config: AppConfigService,
    protected http: HttpClient,
    protected messageService: MessageService    
  ) {
    super(http, messageService);
    this.url = config.getConfig().apiUrl + '/ethnicities';
   }

   getEthnicities(): Observable<Ethnicity[]> {
    return this.http.get<Ethnicity[]>(this.url)
    .pipe(
      tap(_ => this.log('fetched ethnicities')),
        catchError(this.handleError<Ethnicity[]>('getEthnicities', []))
      );
  }
}
