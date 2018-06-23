import { Component, OnInit, Input, Inject } from '@angular/core';
import { Question} from '../../../models/question.model';

import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  @Input() question : Question =new Question(); 
  

  constructor(private dialogRef: MatDialogRef<AddQuestionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any)
    {
      
    } 

  ngOnInit() {}
  
close(name: string) {  
  this.dialogRef.close();
  
}

add(name: string){
  if(!(name==null)){
  this.dialogRef.close({name} as Question);
  }
}

}
