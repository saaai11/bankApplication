import { Component, OnInit } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';



@Component({
  selector: 'app-accountstatement',
  templateUrl: './accountstatement.component.html',
  styleUrls: ['./accountstatement.component.css']
})
export class AccountstatementComponent implements OnInit {

  transactions : any;

  constructor(private http: HttpClient) { }

  ngOnInit() {

    let url = 'http://localhost:8081/api/transactions/account/'+localStorage.getItem("accountNo");

this.http.get(url, {
  headers : new HttpHeaders({
    'Content-type' : 'application/json'
  })
}).subscribe(data =>{

this.transactions = data;

  console.log(data+'' + "  data");
});


  }

}
