import { DatePipe } from '@angular/common';
import { Statement } from '@angular/compiler';
import { Component } from '@angular/core';
import { AppuserService } from 'src/app/appuser.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[DatePipe]
})
export class HomeComponent {
fetchList  :any=[]
listRecords:any;

  constructor(private adminService:AppuserService){
    
  }
  ngOnInit(){
    this.adminService.getclass().subscribe(stat=>{
       this.fetchList = stat;
       localStorage.setItem("data",JSON.stringify(stat));
       this.listRecords=localStorage.getItem('data');
       console.log(this.fetchList);
    })
 }
}
