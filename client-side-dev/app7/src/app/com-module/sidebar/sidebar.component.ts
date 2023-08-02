import { Component, Input,SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  @Input() notShowDashboard = true;
  dashboardClick = false;
  sidebarDisplay = 'block';
  
  constructor(){
    console.log(this.notShowDashboard + "from cons")
  }

  ngOnChanges(changes: SimpleChanges){
    console.log(this.notShowDashboard + "from ngOnChanges")
    if (this.notShowDashboard) {
      this.dashboardClick = true
      this.notShowDashboard = false;
      console.log("from if")
    }
    else {
      this.dashboardClick = false;
      this.notShowDashboard = true;
      console.log("from else")
    }
    console.log(this.notShowDashboard + "from ngOnChanges")
  }

}
