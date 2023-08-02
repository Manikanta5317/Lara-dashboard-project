import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { AppuserService } from 'src/app/appuser.service';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent {

  courseForm : FormGroup;
  saveMessage : any;
  updateMessage : any;
  coursedata : any = [];
  hiddenu : boolean = true;
  hiddens : boolean = false;

   newCourseData = 
   {
     "id" :  "",
     "courseName" : "",
     "StartDate" : "",
     "courseEndDate" : "",
     "demoStartDate" : "",
     "demoEndDate" : "",
     "scholarshipDate": "",
     "Hours" : ""
   }

  constructor(private formBuilder: FormBuilder,private service : AppuserService,private http : HttpClient ) { 
    this.courseForm = this.formBuilder.group({
      courseName: ['', Validators.required],
      startDate: ['', Validators.required],
      hours : ['',Validators.required],
      demoStartDate : ['',Validators.required],
      demoEndDate: ['', Validators.required],
      scholarshipDate : ['',Validators.required]
    });
  }

  save(data : any)
  {
    console.log(this.courseForm.value)
    this.service.courseDataSave(this.courseForm.value);
    this.saveMessage = "Data Saved Successfully Please Refresh the page";
   }

   ngOnInit()
  {
      this.service.getCourseData().subscribe(
        data=>
        {
        this.coursedata = data;
        console.log(this.coursedata);


        }
      )
  }

  updateEntry(index: number) {
    this.hiddenu = false;
    this.hiddens = true;
    const entryToUpdate = this.coursedata[index];
    var courseName = document.getElementById("courseName") as HTMLInputElement;
    var StartDate = document.getElementById("startDate") as HTMLInputElement;
    var courseEndDate = document.getElementById("courseEndDate") as HTMLInputElement;
    var demoStartDate = document.getElementById("demoStartDate") as HTMLInputElement;
    var demoEndDate = document.getElementById("demoEndDate") as HTMLInputElement;
    var Hours = document.getElementById("hours") as HTMLInputElement;
    var ScholarshipDate = document.getElementById("scholarshipDate") as HTMLInputElement;

    courseName.value = this.coursedata[index].courseName;
    StartDate.value = this.coursedata[index].CourseStartDate;
    courseEndDate.value = this.coursedata[index].CourseEndDate;
    demoStartDate.value = this.coursedata[index].DemoStartDate;
    demoEndDate.value = this.coursedata[index].DemoEndDate;
    ScholarshipDate.value = this.coursedata[index].ScholarshipDate;
    Hours.value = this.coursedata[index].Hours;
    this.newCourseData.id = this.coursedata[index].id;

    

    
 
    


    

    // console.log('Updating Entry:', entryToUpdate);
  }

  changes()
  {
    
    var courseName = document.getElementById("courseName") as HTMLInputElement;
    var StartDate = document.getElementById("startDate") as HTMLInputElement;
    var courseEndDate = document.getElementById("courseEndDate") as HTMLInputElement;
    var demoStartDate = document.getElementById("demoStartDate") as HTMLInputElement;
    var demoEndDate = document.getElementById("demoEndDate") as HTMLInputElement;
    var Hours = document.getElementById("hours") as HTMLInputElement;
    var scholarshipDate = document.getElementById("scholarshipDate") as HTMLInputElement;



   this.newCourseData.courseName = courseName.value;
   this.newCourseData.StartDate = StartDate.value;
   this.newCourseData.courseEndDate = courseEndDate.value;
   this.newCourseData.demoStartDate = demoStartDate.value;
   this.newCourseData.demoEndDate = demoEndDate.value;
   this.newCourseData.Hours = Hours.value;
   this.newCourseData.scholarshipDate = scholarshipDate.value;

   console.log(this.newCourseData);
   

   
     this.service.updateCourseData(this.newCourseData);
    this.updateMessage = "Updated SuccessFully Please Refresh the page";
     

    


  }
   
}
