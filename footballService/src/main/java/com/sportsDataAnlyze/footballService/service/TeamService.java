package com.sportsDataAnlyze.footballService.service;

import com.sportsDataAnlyze.footballService.dao.TeamDao;
import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.teamStatsEnrichment.TeamBuilder;
import com.sportsDataAnlyze.footballService.teamStatsEnrichment.TeamBuilderFactory;
import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private static int MATCHES_BACK = 10;

    @Autowired
    TeamDao teamDao;

    @Autowired
    FixtureService fixtureService;


    public Team generateTeamRapport(String teamName, String oppositeTeamName, TeamSideEnum teamSide){

        Team team = getTeamFromDB(teamName);
        Team oppositeTeam = getTeamFromDB(oppositeTeamName);

        return generateDto(team,oppositeTeam,teamSide);
    }

    private Team getTeamFromDB(String teamName){
        return teamDao.findById(teamName)
                .orElseThrow(() -> new IllegalStateException(String.format("No such team: %s",teamName)));
    }

    private Team generateDto(Team team, Team oppositeTeam, TeamSideEnum teamSideEnum) {

        List<Fixture> fixtures = fixtureService.getTeamFixturesFromDB(team);

        fixtures = fixtures.subList(0,MATCHES_BACK);

        TeamBuilderFactory factory = new TeamBuilderFactory();

        TeamBuilder tb = factory.buildTeamBuilder(team,oppositeTeam,teamSideEnum, fixtures);

        return tb.buildTeam();
    }

    public Iterable<Team> getAllTeams(){
        return teamDao.findAll();
    }

    public Iterable<Team> getAllTeamsByLeague(LeagueUrlEnum leagueUrlEnum){
        return teamDao.findAllByLeague(leagueUrlEnum);
    }
}
