import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamListService {

  constructor( private http: HttpClient) { }

getAllTeams(): Observable<any> {
  return this.http.get("http://localhost:8080/team");
}
getAllTeamsByLeague(league:String): Observable<any> {
  return this.http.get("http://localhost:8080/team/by-league/" + league);
}
}
