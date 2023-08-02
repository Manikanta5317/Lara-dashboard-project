import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddclassComponent } from './addclass/addclass.component';
import { HomeComponent } from './home/home.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
  {
    path:'addclass',component:AddclassComponent
  },
  {
    path:'home',component:HomeComponent
  },
  {
    path:'update',component:UpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClassScheduleRoutingModule { }
