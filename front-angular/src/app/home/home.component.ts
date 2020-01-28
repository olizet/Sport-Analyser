import { Component, OnInit } from '@angular/core';
import { Team } from '../models/team';
import { TeamListService } from '../services/team-list.service';
import { LeagueListService } from '../services/league-list.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class Home implements OnInit {
  teams: Team[];
  leagues: String[];

  constructor(private teamListService: TeamListService, private leagueListService: LeagueListService, private router: Router) { }

  fixtureForm = new FormGroup({
    home: new FormControl(''),
    away: new FormControl('')
  });

  ngOnInit() {
    this.teamListService.getAllTeams().subscribe(
      (dane) => {
        this.teams = dane;
      }
    )
    this.leagueListService.getAllLeagues().subscribe(
      (dane) => {
        this.leagues = dane;
      }
    )
  }

  getToRapport = function() {
    let homeTeam = this.fixtureForm.value.home;
    let awayTeam = this.fixtureForm.value.away;
    this.router.navigate(
      ['/fixture-rapport'],
      { queryParams: { 
          home: homeTeam,
          away: awayTeam}
      }
    )
  }

  changeTeamList = function(league:String) {
    this.teamListService.getAllTeamsByLeague(league).subscribe(
      (dane) => {
        this.teams = dane
      }
    )
  }
}
