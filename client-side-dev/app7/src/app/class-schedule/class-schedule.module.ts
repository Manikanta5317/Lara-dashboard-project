import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClassScheduleRoutingModule } from './class-schedule-routing.module';
import { AddclassComponent } from './addclass/addclass.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { UpdateComponent } from './update/update.component';


@NgModule({
  declarations: [
    AddclassComponent,
    HomeComponent,
    UpdateComponent
  ],
  imports: [
    CommonModule,
    ClassScheduleRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    AddclassComponent,
    HomeComponent
  ]
})
export class ClassScheduleModule { }
