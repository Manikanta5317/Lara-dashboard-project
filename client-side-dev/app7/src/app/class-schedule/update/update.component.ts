import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AppuserService } from 'src/app/appuser.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent { 
  classScheduleRecords:any=[];
  content=''
  msgOk=false;
  msgDanger=false;

  updateForm:FormGroup;
  constructor(formBuilder:FormBuilder,private adminService:AppuserService){
    this.updateForm=formBuilder.group({
      id:new FormControl('',Validators.required),
      time: new FormControl('',Validators.required),
       batchName: new FormControl('',Validators.required),
       instructor: new FormControl('',Validators.required),
       classType: new FormControl('',Validators.required),
       topic: new FormControl('',Validators.required),
    })
  }

  ngOnInit(){
    this.adminService.getclass().subscribe(stat=>{
        this.classScheduleRecords=stat;
    })
  }


  updateEntry(index: number) {
    const data = this.classScheduleRecords[index];
    // console.log("mak 1 : " + data);
    // console.log("mak 2 : " + this.classScheduleRecords[index]);
    console.log(this.classScheduleRecords);
    
    this.updateForm.patchValue({
      id: data.id,
      time: data.time,
      batchName: data.batchName,
      instructor: data.instructor,
      classType: data.classType,
      topic: data.topic
    });
  }

  update(){
     console.log(this.updateForm.value)
     this.adminService.updateclass(this.updateForm.value).subscribe(stat=>{
       let data:any=stat.valueOf();
      //  console.log("mak 4  ::: " + data)
       if(data['status']=true){
         this.msgOk=true;
         this.content=data['message']
       }
       else{
         this.msgDanger=true;
         this.content=data['message']
       }
     })
     setTimeout(() => {
      window.location.reload();
     }, 1000);
  }
    
  // *************************************Getters*************************
  get id(){
    return this.updateForm.get('id')
  }

  get time(){
    return this.updateForm.get('time');
  }

  get batchName(){
    return this.updateForm.get('batchName');
  }

  get instructor(){
    return this.updateForm.get('instructor');
  }

  get classType(){
    return this.updateForm.get('classType');
  }

  get topic(){
    return this.updateForm.get('topic');
  }
}
