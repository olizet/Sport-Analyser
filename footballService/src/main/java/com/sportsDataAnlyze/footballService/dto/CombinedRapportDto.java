package com.sportsDataAnlyze.footballService.dto;

public class CombinedRapportDto {
    private double avgGoalsSideHome;
    private double avgGoalsSideAway;
    private double avgGoalsQuarteHome;
    private double avgGoalsQuarteAway;
    private double avgGoalsSideMatch;
    private double avgGoalsQuarterMatch;

    public CombinedRapportDto(RapportDto rapportDto) {
        this.avgGoalsSideHome = (rapportDto.getHomeTeam().getTeamRapportStats().getGoalsSide()+ rapportDto.getAwayTeam().getTeamRapportStats().getGoalsOppSide())/2;
        this.avgGoalsSideAway = (rapportDto.getAwayTeam().getTeamRapportStats().getGoalsSide()+ rapportDto.getHomeTeam().getTeamRapportStats().getGoalsOppSide())/2;
        this.avgGoalsQuarteHome = (rapportDto.getHomeTeam().getTeamRapportStats().getGoalsQuarter()+ rapportDto.getAwayTeam().getTeamRapportStats().getGoalsOppSideQuarter())/2;
        this.avgGoalsQuarteAway = (rapportDto.getAwayTeam().getTeamRapportStats().getGoalsQuarter()+ rapportDto.getHomeTeam().getTeamRapportStats().getGoalsOppSideQuarter())/2;
        this.avgGoalsSideMatch = avgGoalsSideHome + avgGoalsSideAway;
        this.avgGoalsQuarterMatch = avgGoalsQuarteHome + avgGoalsQuarteAway;
    }

    public double getAvgGoalsSideHome() {
        return avgGoalsSideHome;
    }

    public void setAvgGoalsSideHome(double avgGoalsSideHome) {
        this.avgGoalsSideHome = avgGoalsSideHome;
    }

    public double getAvgGoalsSideAway() {
        return avgGoalsSideAway;
    }

    public void setAvgGoalsSideAway(double avgGoalsSideAway) {
        this.avgGoalsSideAway = avgGoalsSideAway;
    }

    public double getAvgGoalsQuarteHome() {
        return avgGoalsQuarteHome;
    }

    public void setAvgGoalsQuarteHome(double avgGoalsQuarteHome) {
        this.avgGoalsQuarteHome = avgGoalsQuarteHome;
    }

    public double getAvgGoalsQuarteAway() {
        return avgGoalsQuarteAway;
    }

    public void setAvgGoalsQuarteAway(double avgGoalsQuarteAway) {
        this.avgGoalsQuarteAway = avgGoalsQuarteAway;
    }

    public double getAvgGoalsSideMatch() {
        return avgGoalsSideMatch;
    }

    public void setAvgGoalsSideMatch(double avgGoalsSideMatch) {
        this.avgGoalsSideMatch = avgGoalsSideMatch;
    }

    public double getAvgGoalsQuarterMatch() {
        return avgGoalsQuarterMatch;
    }

    public void setAvgGoalsQuarterMatch(double avgGoalsQuarterMatch) {
        this.avgGoalsQuarterMatch = avgGoalsQuarterMatch;
    }
}
