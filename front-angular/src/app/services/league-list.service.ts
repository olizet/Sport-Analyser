import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeagueListService {

  constructor( private http: HttpClient) { }

getAllLeagues(): Observable<any> {
  return this.http.get("http://localhost:8080/league");
}
}
