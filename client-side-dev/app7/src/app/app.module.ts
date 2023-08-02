import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import { ComModuleModule } from './com-module/com-module.module';
import { ClassScheduleModule } from './class-schedule/class-schedule.module';
import { PlacementDataModule } from './placement-data/placement-data.module';
import { CourseDataModule } from './course-data/course-data.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ComModuleModule,
    ClassScheduleModule,
    CourseDataModule,
    PlacementDataModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
