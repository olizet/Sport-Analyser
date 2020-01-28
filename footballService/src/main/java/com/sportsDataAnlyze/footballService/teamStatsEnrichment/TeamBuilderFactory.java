package com.sportsDataAnlyze.footballService.teamStatsEnrichment;

import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;

import java.util.List;

public class TeamBuilderFactory {

    public TeamBuilder buildTeamBuilder(Team team, Team opposteTeam, TeamSideEnum teamSideEnum, List<Fixture> fixtures){
        switch(teamSideEnum){
            case HOME:
                return new TeamBuilderHome(team,opposteTeam,fixtures);
            case AWAY:
                return  new TeamBuilderAway(team,opposteTeam,fixtures);
            default:
                throw new IllegalArgumentException("Unsupported team side");
        }
    }
}
