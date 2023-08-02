import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlacementDataModule } from './placement-data.module';
import { PlacementshowdataComponent } from './placementshowdata/placementshowdata.component';
import { PlacementdataComponent } from './placementdata/placementdata.component';

const routes: Routes = [
  {
  path : 'placementshow',component : PlacementshowdataComponent
  },
  {
    path : 'placementdata',component : PlacementdataComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlacementDataRoutingModule { }
