import { Component, EventEmitter, Input, Output, SimpleChange } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  @Output() showDashboard=new EventEmitter<boolean>();
  
  @Input() showAdminPanel=true;
   
  ngOnChanges(changes:SimpleChange){
     console.log("from header component");
  }

   showDashboardEvent(event:any){
      this.showDashboard.emit(true);
      event.preventDefault();
   }

   logout(event:any){
     console.log("logout component");
   }
}
