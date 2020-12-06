import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApimodalService {

  private REST_API_SERVER = "http://localhost:8081/api/users/api";


  constructor(private http:HttpClient) { }


  public sendGetRequest(){
    return this.http.get(this.REST_API_SERVER);
  }




}
