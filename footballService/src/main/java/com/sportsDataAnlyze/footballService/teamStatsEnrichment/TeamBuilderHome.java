package com.sportsDataAnlyze.footballService.teamStatsEnrichment;

import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;

import java.util.List;

public class TeamBuilderHome implements TeamBuilder {
    private Team team;
    private TeamBuilderFixtureManager teamBuilderFixtureManager;

    public TeamBuilderHome(Team team, Team oppositeTeam, List<Fixture> teamFixtures) {
        this.team = team;
        teamBuilderFixtureManager = new TeamBuilderFixtureManager(team,oppositeTeam,TeamSideEnum.AWAY, teamFixtures);
    }

    private TeamBuilderHome buildGoalsQuarter(){
        team.getTeamRapportStats().setGoalsQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getHomeGoals()
                :f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsOppSideQuarter(){
        team.getTeamRapportStats().setGoalsOppSideQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream().mapToDouble(f->f.getAway().getTeamName().equals(team.getTeamName())?
                f.getHomeGoals()
                :f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsSide(){
        team.getTeamRapportStats().setGoalsSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getHomeGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsOppSide(){
        team.getTeamRapportStats().setGoalsOppSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildGoalsSideQuarter(){
        team.getTeamRapportStats().setGoalsSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getHomeGoals()).average().orElse(-1));
        return this;
    }
    private TeamBuilderHome buildGoalsSideOppSideQuarter(){
        team.getTeamRapportStats().setGoalsSideOppSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersQuarter(){
        team.getTeamRapportStats().setCornersQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getHomeCorners()
                :f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersOppSideQuarter(){
        team.getTeamRapportStats().setCornersOppSideQuarter((teamBuilderFixtureManager.getTeamFixturesQuarter().stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getAwayCorners()
                :f.getHomeCorners()).average().orElse(-1)));
        return this;
    }

    private TeamBuilderHome buildCornersSide(){
        team.getTeamRapportStats().setCornersSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getHomeCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersOppSide(){
        team.getTeamRapportStats().setCornersOppSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersSideQuarter(){
        team.getTeamRapportStats().setCornersSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getHomeCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderHome buildCornersSideOppSideQuarter(){
        team.getTeamRapportStats().setCornersSideOppSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    @Override
    public Team buildTeam() {
        this.buildGoalsQuarter();
        this.buildGoalsOppSideQuarter();
        this.buildGoalsSide();
        this.buildGoalsOppSide();
        this.buildGoalsSideQuarter();
        this.buildGoalsSideOppSideQuarter();
        this.buildCornersQuarter();
        this.buildCornersOppSideQuarter();
        this.buildCornersSide();
        this.buildCornersOppSide();
        this.buildCornersSideQuarter();
        this.buildCornersSideOppSideQuarter();
        return this.team;
    }
}
