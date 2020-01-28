package com.sportsDataAnlyze.footballService.service;

import com.sportsDataAnlyze.footballService.dao.FixtureDao;
import com.sportsDataAnlyze.footballService.dto.CombinedRapportDto;
import com.sportsDataAnlyze.footballService.dto.RapportDto;
import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureService {

    @Autowired
    TeamService teamService;

    @Autowired
    FixtureDao fixtureDao;

    public RapportDto generateFixtureRapport(String home, String away) {
        Team homeRapport = teamService.generateTeamRapport(home,away, TeamSideEnum.HOME);
        Team awayRapport = teamService.generateTeamRapport(away,home,TeamSideEnum.AWAY);

        return generateExtendedRapport(new RapportDto(homeRapport,awayRapport));
    }

    private RapportDto generateExtendedRapport(RapportDto rapportDto) {
        rapportDto.setCombinedRapport(new CombinedRapportDto(rapportDto));
        return rapportDto;
    }


    public List<Fixture> getTeamFixturesFromDB(Team team){
        return fixtureDao.findFixtureByHomeOrAwayOrderByFixtureDateDesc(team,team);
    }
}
