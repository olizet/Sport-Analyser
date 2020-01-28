package com.sportsDataAnlyze.footballService.teamStatsEnrichment;

import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamBuilderFixtureManager {
    private Team team;
    private int oppositeTeamQuarterStats;
    private int oppositeTeamQuarterStatsSide;
    private TeamSideEnum oppositeTeamSide;

    private List<Fixture> teamFixtures;
    private List<Fixture> teamSideFixtures;
    private List<Fixture> teamSideFixturesQuarter;
    private List<Fixture> teamFixturesQuarter;

    public TeamBuilderFixtureManager(Team team, Team oppositeTeam, TeamSideEnum oppositeTeamSide, List<Fixture> teamFixtures) {
        this.team = team;
        this.oppositeTeamQuarterStats = oppositeTeam.getTeamQuarterStats();
        this.oppositeTeamQuarterStatsSide = oppositeTeam.getTeamSideQuarterStats(oppositeTeamSide);
        this.oppositeTeamSide = oppositeTeamSide;
        this.teamFixtures = teamFixtures;

        generateTeamFixturesQuarter();
        generateTeamSideFixtures();
        generateTeamSideFixturesQuarter();
    }
    private void generateTeamFixturesQuarter(){
        this.teamFixturesQuarter = Optional.ofNullable(teamFixtures.stream()
                .filter(f->((f.getHome().equals(team) && f.getAway().getPosition()<=(oppositeTeamQuarterStats *5)
                        && f.getAway().getPosition()>((oppositeTeamQuarterStats -1)*5))
                        ||(f.getAway().equals(team) && f.getHome().getPosition()<=(oppositeTeamQuarterStats *5)
                        && f.getHome().getPosition()>((oppositeTeamQuarterStats-1)*5))))
                .collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);
    }

    private void generateTeamSideFixtures(){
        this.teamSideFixtures = Optional.ofNullable(teamFixtures.stream()
                .filter(f-> getTeam(f).equals(team))
                .collect(Collectors.toList())).orElseGet(Collections::emptyList);
    }

    private void generateTeamSideFixturesQuarter(){
        this.teamSideFixturesQuarter = Optional.ofNullable(teamSideFixtures.stream()
                .filter(f-> getSidePositionOppSide(f)<=(oppositeTeamQuarterStatsSide*5)
                        && getSidePositionOppSide(f)>((oppositeTeamQuarterStatsSide-1)*5))
                .collect(Collectors.toList())).orElseGet(Collections::emptyList);
    }
    public Team getTeam(Fixture f){
        return oppositeTeamSide.equals(TeamSideEnum.HOME)? f.getAway():f.getHome();
    }

    public int getSidePositionOppSide(Fixture f){
        return oppositeTeamSide.equals(TeamSideEnum.HOME)? f.getHome().getPositionH(): f.getAway().getPositionA();
    }

    public List<Fixture> getTeamSideFixtures() {
        return teamSideFixtures;
    }

    public List<Fixture> getTeamSideFixturesQuarter() {
        return teamSideFixturesQuarter;
    }

    public List<Fixture> getTeamFixturesQuarter() {
        return teamFixturesQuarter;
    }

    public List<Fixture> getTeamFixtures() {
        return teamFixtures;
    }
}
