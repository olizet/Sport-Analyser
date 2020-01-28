import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FixtureRapportService } from '../services/fixture-rapport.service';
import { FixtureRapport } from '../models/fixture-rapport';

@Component({
  selector: 'app-fixture-rapport',
  templateUrl: './fixture-rapport.component.html',
  styleUrls: ['./fixture-rapport.component.css']
})
export class FixtureRapportComponent implements OnInit {
  fixtureRapport: FixtureRapport;
  constructor(private route:ActivatedRoute, private fixtureRapportService:FixtureRapportService) { }

  ngOnInit() {
    this.route.queryParamMap.subscribe(params => {
      this.fixtureRapportService.generateRapport(params.get("home"),params.get("away")).subscribe(
        (obj) => { this.fixtureRapport = obj;}
        );
    });
  }

}
