import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

   showDashboardParent=false;

   constructor(){
    setTimeout(() => {
      localStorage.removeItem('data');
      return "ok"
    }, 24*60*60*1000);
   }

   showDashboardEvent(event:any){
     if(this.showDashboardParent) this.showDashboardParent=false
     else this.showDashboardParent=true;  
   }
  
   
  
}
