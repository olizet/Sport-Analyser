package com.sportsDataAnlyze.dataReplicator.entity;

import java.util.Objects;

public class Fixture {
    private String home;
    private String away;
    private String league;
    private String fixtureDate;
    private String homeGoals;
    private String awayGoals;
    private String homeYellows;
    private String awawyYellows;
    private String homeCorners;
    private String awayCorners;
    private String result;
    private String referee;


    public void setHome(String home) {
        this.home = home.replace("'","");
    }

    public void setAway(String away) {
        this.away = away.replace("'","");
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setHomeYellows(String homeYellows) {
        this.homeYellows = homeYellows;
    }

    public void setAwawyYellows(String awawyYellows) {
        this.awawyYellows = awawyYellows;
    }

    public void setHomeCorners(String homeCorners) {
        this.homeCorners = homeCorners;
    }

    public void setAwayCorners(String awayCorners) {
        this.awayCorners = awayCorners;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getInsertQuery(){

        if(Objects.isNull(referee)){
            return String.format("INSERT INTO rep_data.football (home,away,league,fixture_date,home_goals,away_goals,home_yellows,away_yellows," +
                    "home_corners,away_corners,result) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    this.home,this.away,this.league,this.fixtureDate,this.homeGoals,this.awayGoals,this.homeYellows,this.awawyYellows,this.homeCorners,
                    this.awayCorners,this.result);
        } else {
            return String.format("INSERT INTO rep_data.football (home,away,league,fixture_date,home_goals,away_goals," +
                    "home_yellows,away_yellows,home_corners,away_corners,result,ref_name) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    this.home,this.away,this.league,this.fixtureDate,this.homeGoals,this.awayGoals,this.homeYellows,this.awawyYellows,this.homeCorners,
                    this.awayCorners,this.result, this.referee);
        }
    }
}
