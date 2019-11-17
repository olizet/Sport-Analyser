package com.sportsDataAnlyze.footballService.entity.teamEnrichment;

import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Referee;
import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class FixtureStub extends TeamBuilderAway{

    public FixtureStub(Team team, Team oppositeTeamQuarterStats, List<Fixture> teamFixtures) {
        super(team, oppositeTeamQuarterStats, teamFixtures);

    }

    public static List<Fixture> getFixtures() {
        List<Fixture> fixtures = new ArrayList<>();
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,1,1,1),LeagueUrlEnum.E0,new Date(),3,1,0,0,0,0,new Referee(),"H"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,20,20,20),LeagueUrlEnum.E0,new Date(),2,4,4,1,5,2,new Referee(),"A"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,10,20,1),LeagueUrlEnum.E0,new Date(),0,1,2,2,4,7,new Referee(),"A"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,4,6,11),LeagueUrlEnum.E0,new Date(),0,0,5,1,3,3,new Referee(),"D"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,16,12,19),LeagueUrlEnum.E0,new Date(),3,3,1,2,1,2,new Referee(),"D"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,7,8,9),LeagueUrlEnum.E0,new Date(),1,2,0,0,11,1,new Referee(),"A"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,8,6,14),LeagueUrlEnum.E0,new Date(),2,2,2,1,8,2,new Referee(),"D"));
        fixtures.add(new Fixture(getTestTeam(),new Team("dummyName",LeagueUrlEnum.E0,2,1,6),LeagueUrlEnum.E0,new Date(),1,0,1,1,3,4,new Referee(),"H"));

        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,10,5,3), getTestTeam(),LeagueUrlEnum.E0,new Date(),3,0,2,3,5,7,new Referee(),"H"));
        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,2,5,20), getTestTeam(),LeagueUrlEnum.E0,new Date(),1,1,1,3,3,1,new Referee(),"D"));
        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,7,14,18), getTestTeam(),LeagueUrlEnum.E0,new Date(),4,3,2,7,5,9,new Referee(),"H"));
        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,10,10,10), getTestTeam(),LeagueUrlEnum.E0,new Date(),2,1,4,4,6,6,new Referee(),"H"));
        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,3,8,1),getTestTeam(),LeagueUrlEnum.E0,new Date(),1,1,0,4,6,6,new Referee(),"A"));
        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,18,19,20),getTestTeam(),LeagueUrlEnum.E0,new Date(),0,0,0,0,6,3,new Referee(),"D"));
        fixtures.add(new Fixture(new Team("dummyName",LeagueUrlEnum.E0,11,12,19),getTestTeam(),LeagueUrlEnum.E0,new Date(),0,3,2,3,1,10,new Referee(),"A"));
        return  fixtures;
    }

    public static Team getTestTeam() {
        Team team = new Team();
        team.setTeamName("AwayTeam");
        team.setLeague(LeagueUrlEnum.E0);
        return team;
    }

    public static Team getOppositeTestAwayTeam() {
        Team team = new Team();
        team.setTeamName("OppositeTeam");
        team.setLeague(LeagueUrlEnum.E0);
        team.setPosition(3);
        team.setPositionH(10);
        team.setPositionA(18);
        return team;
    }

    public static Team getOppositeTestHomeTeam() {
        Team team = new Team();
        team.setTeamName("OppositeTeam");
        team.setLeague(LeagueUrlEnum.E0);
        team.setPosition(8);
        team.setPositionH(6);
        team.setPositionA(4);
        return team;
    }
}
