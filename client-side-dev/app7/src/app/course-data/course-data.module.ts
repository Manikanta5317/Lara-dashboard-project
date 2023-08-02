import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseDataRoutingModule } from './course-data-routing.module';
import { CourseComponent } from './course/course.component';
import { HttpClient } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CourseComponent
  ],
  imports: [
    CommonModule,
    CourseDataRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    CourseComponent
  ]
})
export class CourseDataModule { }
