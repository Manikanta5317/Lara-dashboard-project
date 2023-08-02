import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AppuserService } from 'src/app/appuser.service';

@Component({
  selector: 'app-addclass',
  templateUrl: './addclass.component.html',
  styleUrls: ['./addclass.component.css']
})
export class AddclassComponent {

  msgOk=false;
  msgDanger=false;
  content=''
  addForm:FormGroup;
  Message=''


  constructor(formBuilder:FormBuilder,private adminService:AppuserService){
     this.addForm=formBuilder.group({
       time: new FormControl('',Validators.required),
       batchName: new FormControl('',Validators.required),
       instructor: new FormControl('',Validators.required),
       classType: new FormControl('',Validators.required),
       topic: new FormControl('',Validators.required),
     })
  }
  
  add(){
     console.log("from add method")
     this.adminService.addclass(this.addForm.value).subscribe(stat=>{
        this.Message="data saved successfully";
        let data:any= stat.valueOf();
        console.log(data.value);
        console.log(this.addForm.value);
        // console.log(data.value);
        
        if(data['status']==true){
           this.msgOk=true;
           this.content=data['message'];
           console.log(this.content);

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

 
   
// *******************************getter**********************8

  get time(){
    return this.addForm.get('time');
  }

  get batchName(){
    return this.addForm.get('batchName');
  }

  get instructor(){
    return this.addForm.get('instructor');
  }

  get classType(){
    return this.addForm.get('classType');
  }

  get topic(){
    return this.addForm.get('topic');
  }
}
