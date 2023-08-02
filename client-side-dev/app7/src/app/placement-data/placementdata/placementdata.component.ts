import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { AppuserService } from 'src/app/appuser.service';

@Component({
  selector: 'app-placementdata',
  templateUrl: './placementdata.component.html',
  styleUrls: ['./placementdata.component.css']
})
export class PlacementdataComponent {
  placementForm : FormGroup;
  saveMessage : any;
  updateMessage : any;
  placementdata : any = [];
  hiddenu : boolean = true;
  hiddens : boolean = false;

   newPlacementData = 
   {
     "id" :  "",
     "date" : "",
     "companyName" : "",
     "studentAttended" : "",
     "studentPlaced" : "",
     "salaryPackage" : ""
   }

  constructor(private formBuilder: FormBuilder,private service : AppuserService,private http : HttpClient ) { 
    this.placementForm = this.formBuilder.group({
      companyName: ['', Validators.required],
      studentPlaced: ['', Validators.required],
      studentAttended: ['', Validators.required],
      salaryPackage : ['',Validators.required],
      date: ['', Validators.required]
    });
  }

  save(data : any)
  {
    this.service.PlacementDataSave(this.placementForm.value);
    this.saveMessage = "Data Saved Successfully Please Refresh the page";
    window.location.reload();
   }

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

  updateEntry(index: number) {
    this.hiddenu = false;
    this.hiddens = true;
    const entryToUpdate = this.placementdata[index];
    var date = document.getElementById("date") as HTMLInputElement;
    var studentAttended = document.getElementById("studentAttended") as HTMLInputElement;
    var studentPlaced = document.getElementById("studentPlaced") as HTMLInputElement;
    var salaryPackage = document.getElementById("salaryPackage") as HTMLInputElement;
    var companyName = document.getElementById("companyName") as HTMLInputElement;

    date.value = this.placementdata[index].date;
    studentAttended.value = this.placementdata[index].studentAttended;
    studentPlaced.value = this.placementdata[index].studentPlaced;
    salaryPackage.value = this.placementdata[index].studentPlaced;
    companyName.value = this.placementdata[index].companyName;
    this.newPlacementData.id = this.placementdata[index].id;

    
 
    


    

    // console.log('Updating Entry:', entryToUpdate);
  }

  changes()
  {
    
    var date = document.getElementById("date") as HTMLInputElement;
    var studentAttended = document.getElementById("studentAttended") as HTMLInputElement;
    var studentPlaced = document.getElementById("studentPlaced") as HTMLInputElement;
    var salaryPackage = document.getElementById("salaryPackage") as HTMLInputElement;
    var companyName = document.getElementById("companyName") as HTMLInputElement;
   console.log(date.value);


   this.newPlacementData.date = date.value;
   this.newPlacementData.companyName = companyName.value;
   this.newPlacementData.studentAttended = studentAttended.value;
   this.newPlacementData.studentPlaced = studentPlaced.value;
   this.newPlacementData.salaryPackage = salaryPackage.value;

   console.log(this.newPlacementData);
   
     this.service.updatePlacementData(this.newPlacementData);
    this.updateMessage = "Updated SuccessFully Please Refresh the page";
     

    


  }

}
