import { Component } from '@angular/core';
import { FormGroup,FormBuilder,FormControl } from '@angular/forms';
import { AppuserService } from 'src/app/appuser.service';

@Component({
  selector: 'app-placementshowdata',
  templateUrl: './placementshowdata.component.html',
  styleUrls: ['./placementshowdata.component.css']
})
export class PlacementshowdataComponent {
 
  placementdata : any = [];

  constructor(private service : AppuserService) {}

  ngOnInit()
  {
      this.service.getPlacementData().subscribe(
        r1 =>
        {
        this.placementdata = r1;
        console.log(this.placementdata);
        }
      )
  }

   reversedPlacementdata() {
    return this.placementdata.slice().reverse();
  }
}
