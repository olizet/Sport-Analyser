package com.sportsDataAnlyze.footballService.dto;

import com.sportsDataAnlyze.footballService.entity.Team;

public class RapportDto {
    private Team homeTeam;
    private Team awayTeam;

    public RapportDto(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}
