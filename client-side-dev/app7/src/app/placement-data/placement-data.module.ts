import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlacementDataRoutingModule } from './placement-data-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlacementdataComponent } from './placementdata/placementdata.component';
import { PlacementshowdataComponent } from './placementshowdata/placementshowdata.component';


@NgModule({
  declarations: [
    PlacementdataComponent,
    PlacementshowdataComponent
  ],
  imports: [
    CommonModule,
    PlacementDataRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    PlacementdataComponent,
    PlacementshowdataComponent
  ]
})
export class PlacementDataModule { }
