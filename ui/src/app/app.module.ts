import { NgModule, APP_INITIALIZER } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';

import { OrderModule } from 'ngx-order-pipe';


import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';

import { AppConfigService } from './service/app-config.service';

import { StudentDetailsComponent } from './student-details/student-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EthnicitySelectionComponent } from './ethnicity-selection/ethnicity-selection.component';

import { materialModules } from './material';
import { ApplicationConfirmationComponent } from './application-confirmation/application-confirmation.component';
import { LLDDHealthProblemSelectionComponent } from './lldd-health-problem-selection/lldd-health-problem-selection.component';

const appInitializerFn = (appConfig: AppConfigService) => {
  return () => {
    return appConfig.loadAppConfig();
  };
};
@NgModule({
  declarations: [
    AppComponent,
    routingComponents,

    StudentDetailsComponent,
    PageNotFoundComponent,
    EthnicitySelectionComponent,
    ApplicationConfirmationComponent,
    LLDDHealthProblemSelectionComponent,    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    OrderModule,
    materialModules
  ],
  providers: [
    AppConfigService,
    {
      provide: APP_INITIALIZER,
      useFactory: appInitializerFn,
      multi: true,
      deps: [AppConfigService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
