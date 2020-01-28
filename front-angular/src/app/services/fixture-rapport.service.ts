import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FixtureRapportService {

  constructor(private http: HttpClient) { }

  generateRapport(home:String,away:String): Observable<any> {
    return this.http.get("http://localhost:8080/fixture-rapport?home=" + home + "&away=" + away);
  }
}
