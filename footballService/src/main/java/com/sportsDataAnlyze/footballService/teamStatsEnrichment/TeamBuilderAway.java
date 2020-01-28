package com.sportsDataAnlyze.footballService.teamStatsEnrichment;

import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;

import java.util.List;

public class TeamBuilderAway implements TeamBuilder {
    private Team team;
    private TeamBuilderFixtureManager teamBuilderFixtureManager;

    public TeamBuilderAway(Team team, Team oppositeTeam, List<Fixture> teamFixtures) {
        this.team = team;
        teamBuilderFixtureManager = new TeamBuilderFixtureManager(team,oppositeTeam,TeamSideEnum.HOME, teamFixtures);
    }

    private TeamBuilderAway buildGoalsQuarter(){
        team.getTeamRapportStats().setGoalsQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream()
                .mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                        f.getHomeGoals()
                        :f.getAwayGoals()).average().orElse(-1));
        return this;
    }
    
    private TeamBuilderAway buildGoalsOppSideQuarter(){
        team.getTeamRapportStats().setGoalsOppSideQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream()
                .mapToDouble(f->f.getAway().getTeamName().equals(team.getTeamName())?
                f.getHomeGoals()
                :f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildGoalsSide(){
        team.getTeamRapportStats().setGoalsSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getAwayGoals()).average().orElse(-1));
        return this;
    }
    
    private TeamBuilderAway buildGoalsOppSide(){
        team.getTeamRapportStats().setGoalsOppSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getHomeGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildGoalsSideQuarter(){
        team.getTeamRapportStats().setGoalsSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getAwayGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildGoalsSideOppSideQuarter(){
        team.getTeamRapportStats().setGoalsSideOppSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getHomeGoals()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildCornersQuarter(){
        team.getTeamRapportStats().setCornersQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream().mapToDouble(f->f.getHome().getTeamName().equals(team.getTeamName())?
                f.getHomeCorners()
                :f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildCornersOppSideQuarter(){
        team.getTeamRapportStats().setCornersOppSideQuarter(teamBuilderFixtureManager.getTeamFixturesQuarter().stream().mapToDouble(f->f.getAway().getTeamName().equals(team.getTeamName())?
                f.getHomeCorners()
                :f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildCornersSide(){
        team.getTeamRapportStats().setCornersSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildCornersOppSide(){
        team.getTeamRapportStats().setCornersOppSide(teamBuilderFixtureManager.getTeamSideFixtures().stream().mapToDouble(f->f.getHomeCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildCornersSideQuarter(){
        team.getTeamRapportStats().setCornersSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getAwayCorners()).average().orElse(-1));
        return this;
    }

    private TeamBuilderAway buildCornersSideOppSideQuarter(){
        team.getTeamRapportStats().setCornersSideOppSideQuarter(teamBuilderFixtureManager.getTeamSideFixturesQuarter().stream().mapToDouble(f->f.getHomeCorners()).average().orElse(-1));
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
