package com.sportsDataAnlyze.footballService.entity.teamEnrichment;

import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamBuilderHome implements TeamBuilder {
    private Team team;
    private Team oppositeTeamQuarterStats;
    private List<Fixture> teamFixtures;
    private List<Fixture> teamSideFixtures;
    private List<Fixture> teamSideFixturesQuarter;
    private List<Fixture> teamFixturesQuarter;

    public TeamBuilderHome(Team team, Team oppositeTeamQuarterStats, List<Fixture> teamFixtures) {
        this.team = team;
        this.oppositeTeamQuarterStats = oppositeTeamQuarterStats;
        this.teamFixtures = teamFixtures;
    }
    
    private TeamBuilderHome buildTeamFixturesQuarter(){
        this.teamFixturesQuarter = Optional.ofNullable(teamFixtures.stream()
                .filter(f->((f.getHome().equals(team) && f.getAway().getPosition()<=(oppositeTeamQuarterStats.getTeamQuarterStats()*5)
                        && f.getAway().getPosition()>((oppositeTeamQuarterStats.getTeamQuarterStats()-1)*5))
                        ||(f.getAway().equals(team) && f.getHome().getPosition()<=(oppositeTeamQuarterStats.getTeamQuarterStats()*5)
                        && f.getHome().getPosition()>((oppositeTeamQuarterStats.getTeamQuarterStats()-1)*5))))
                .collect(Collectors.toList())).orElseGet(Collections::emptyList);
        return this;
    }

    private TeamBuilderHome buildTeamSideFixtures(){
        this.teamSideFixtures = teamFixtures.stream()
                .filter(f-> f.getHome().equals(team))
                .collect(Collectors.toList());
        return this;
    }

    private TeamBuilderHome buildTeamSideFixturesQuarter(){
        this.teamSideFixturesQuarter = teamSideFixtures.stream()
                .filter(f-> f.getAway().getPositionA()<=(oppositeTeamQuarterStats.getTeamSideQuarterStats(TeamSideEnum.AWAY)*5)
                        && f.getAway().getPositionA()>((oppositeTeamQuarterStats.getTeamSideQuarterStats(TeamSideEnum.AWAY)-1)*5))
                .collect(Collectors.toList());
        return this;
    }

    private TeamBuilderHome buildGoalsQuarter(){
        team.getTeamRapportStats().setGoalsQuarter(teamFixturesQuarter.stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getHomeGoals()
                :f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsOppSideQuarter(){
        team.getTeamRapportStats().setGoalsOppSideQuarter(teamFixturesQuarter.stream().mapToDouble(f->f.getAway().getTeamName().equals(team.getTeamName())?
                f.getHomeGoals()
                :f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsSide(){
        team.getTeamRapportStats().setGoalsSide(teamSideFixtures.stream().mapToDouble(f->f.getHomeGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsOppSide(){
        team.getTeamRapportStats().setGoalsOppSide(teamSideFixtures.stream().mapToDouble(f->f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsSideQuarter(){
        team.getTeamRapportStats().setGoalsSideQuarter(teamSideFixturesQuarter.stream().mapToDouble(f->f.getHomeGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsSideOppSideQuarter(){
        team.getTeamRapportStats().setGoalsSideOppSiderQuarter(teamSideFixturesQuarter.stream().mapToDouble(f->f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCardsQuarter(){
        team.getTeamRapportStats().setCardsQuarter(teamFixturesQuarter.stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getHomeYellows()
                :f.getAwayYellows()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCardsOppSideQuarter(){
        team.getTeamRapportStats().setCardsOppSideQuarter((teamFixturesQuarter.stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getAwayYellows()
                :f.getHomeYellows()).average().orElse(-1)));
        return this;
    }

    private TeamBuilderHome buildCardsSide(){
        team.getTeamRapportStats().setCardsSide(teamSideFixtures.stream().mapToDouble(f->f.getHomeYellows()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCardsOppSide(){
        team.getTeamRapportStats().setCardsOppSide(teamSideFixtures.stream().mapToDouble(f->f.getAwayYellows()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCardsSideQuarter(){
        team.getTeamRapportStats().setCardsSideQuarter(teamSideFixturesQuarter.stream().mapToDouble(f->f.getHomeYellows()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCardsSideOppSideQuarter(){
        team.getTeamRapportStats().setCardsSideOppSideQuarter(teamSideFixturesQuarter.stream().mapToDouble(f->f.getAwayYellows()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersQuarter(){
        team.getTeamRapportStats().setCornersQuarter(teamFixturesQuarter.stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getHomeCorners()
                :f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersOppSideQuarter(){
        team.getTeamRapportStats().setCornersOppSideQuarter((teamFixturesQuarter.stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getAwayCorners()
                :f.getHomeCorners()).average().orElse(-1)));
        return this;
    }

    private TeamBuilderHome buildCornersSide(){
        team.getTeamRapportStats().setCornersSide(teamSideFixtures.stream().mapToDouble(f->f.getHomeCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersOppSide(){
        team.getTeamRapportStats().setCornersOppSide(teamSideFixtures.stream().mapToDouble(f->f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersSideQuarter(){
        team.getTeamRapportStats().setCornersSideQuarter(teamSideFixturesQuarter.stream().mapToDouble(f->f.getHomeCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersSideOppSideQuarter(){
        team.getTeamRapportStats().setCornersSideOppSideQuarter(teamSideFixturesQuarter.stream().mapToDouble(f->f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    @Override
    public Team buildTeam() {
        this.buildTeamFixturesQuarter();
        this.buildTeamSideFixtures();
        this.buildTeamSideFixturesQuarter();
        this.buildGoalsQuarter();
        this.buildGoalsOppSideQuarter();
        this.buildGoalsSide();
        this.buildGoalsOppSide();
        this.buildGoalsSideQuarter();
        this.buildGoalsSideOppSideQuarter();
        this.buildCardsQuarter();
        this.buildCardsOppSideQuarter();
        this.buildCardsSide();
        this.buildCardsOppSide();
        this.buildCardsSideQuarter();
        this.buildCardsSideOppSideQuarter();
        this.buildCornersQuarter();
        this.buildCornersOppSideQuarter();
        this.buildCornersSide();
        this.buildCornersOppSide();
        this.buildCornersSideQuarter();
        this.buildCornersSideOppSideQuarter();
        return this.team;
    }

    public List<Fixture> getTeamFixtures() {
        return teamFixtures;
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

}
