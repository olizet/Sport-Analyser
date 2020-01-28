package com.sportsDataAnlyze.footballService.dto;

import com.sportsDataAnlyze.footballService.entity.Team;

public class RapportDto {
    private Team homeTeam;
    private Team awayTeam;
    private CombinedRapportDto combinedRapport;

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

    public CombinedRapportDto getCombinedRapport() {
        return combinedRapport;
    }

    public void setCombinedRapport(CombinedRapportDto combinedRapport) {
        this.combinedRapport = combinedRapport;
    }
}
