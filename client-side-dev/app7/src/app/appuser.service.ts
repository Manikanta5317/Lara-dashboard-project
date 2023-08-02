import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppuserService {

  constructor(private http:HttpClient) { }

  url : String = 'http://localhost:9093/';
  updateMessage : any;
  saveMessage : any;


     PlacementDataSave(form : any)
     {
        this.http.post(this.url + 'placement',form).subscribe(
          r1 =>
          {
            console.log(r1);
            
           
            var data = JSON.stringify(r1);

          }
        );
     }

     getPlacementData()
     {
       return this.http.get(this.url + 'placement');
     }

     updatePlacementData(data : any)
     {
      // console.log(form);
      
        this.http.put<any>(this.url + 'placement/update',data).subscribe(
          r1 =>
          {
            this.updateMessage = r1.message;
            console.log(this.updateMessage);
            
          }
        )
        console.log('done');
        
     }

     courseDataSave(form : any)
     {
        this.http.post(this.url + 'course',form).subscribe(
          r1 =>
          {
            
            var data = JSON.stringify(r1);

          }
        );
     }

     getCourseData()
     {
       return this.http.get(this.url + 'course');
     }

     updateCourseData(data : any)
     {
      // console.log(form);
      
        this.http.put<any>(this.url + 'course/update',data).subscribe(
          r1 =>
          {
            this.updateMessage = r1.message;
            console.log(this.updateMessage);
            
          }
        )
        console.log('done');
        
     }

     addclass(addclass:any){
      return this.http.post("http://localhost:9050/schedule/save",addclass)
    }

    getclass(){
      return this.http.get("http://localhost:9050/schedule/fetch");
    }

    updateclass(updateClass:any){
      return this.http.post("http://localhost:9050/schedule/update",updateClass);
    }


}
