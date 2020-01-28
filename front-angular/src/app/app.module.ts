import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Home } from './home/home.component';

import { TeamListService } from './services/team-list.service';
import { LeagueListService } from './services/league-list.service';
import { FixtureRapportService } from './services/fixture-rapport.service';

import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { FixtureRapportComponent } from './fixture-rapport/fixture-rapport.component';

@NgModule({
  declarations: [
    AppComponent,
    Home,
    FixtureRapportComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [TeamListService, LeagueListService, FixtureRapportService],
  bootstrap: [AppComponent]
})
export class AppModule { }
