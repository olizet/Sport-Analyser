package com.sportsDataAnlyze.footballService.service;

import com.sportsDataAnlyze.footballService.dao.FixtureDao;
import com.sportsDataAnlyze.footballService.dto.RapportDto;
import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixtureService {

    @Autowired
    TeamService teamService;

    @Autowired
    FixtureDao fixtureDao;

    public Optional<RapportDto> generateFixtureRapport(String home, String away) {
        return Optional.of(new RapportDto(
                teamService.generateTeamRapport(home,away, TeamSideEnum.HOME),
                teamService.generateTeamRapport(away,home,TeamSideEnum.AWAY)));
    }


    public List<Fixture> getTeamFixturesFromDB(Team team){
        return fixtureDao.findFixtureByHomeOrAway(team,team);
    }
}
