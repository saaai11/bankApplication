import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-addbalance',
  templateUrl: './addbalance.component.html',
  styleUrls: ['./addbalance.component.css']
})
export class AddbalanceComponent implements OnInit {

  myForm: FormGroup;



  constructor(private http : HttpClient, private fb : FormBuilder) { }

  onSubmit(myForm){

let body = {
  "amount" : myForm.value.amount
}


  let url =   'http://localhost:8081/api/Accountbalance/update/'+localStorage.getItem("accountNo");

  this.http.put(url, body, {headers : new HttpHeaders({

    'Content-Type' : 'application/json'

  })
  }).subscribe(data=>{
    console.log(data + "   data");
  });



  }

  ngOnInit() {

    this.myForm = this.fb.group({
  amount: ['', Validators.required]
   });

  }

}
