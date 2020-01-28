package com.sportsDataAnlyze.footballService.teamStatsEnrichment;

import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasSize;

public class TeamBuilderFixtureManagerTest {
    private static TeamBuilderFixtureManager teamBuilderFixtureManagerAway;
    private static TeamBuilderFixtureManager teamBuilderFixtureManagerHome;

    @BeforeAll
    private static void getFixtures(){
        teamBuilderFixtureManagerAway = new TeamBuilderFixtureManager(FixtureStub.getTestTeam(),
                FixtureStub.getOppositeTestAwayTeam(),
                TeamSideEnum.HOME,
                FixtureStub.getFixtures());
        teamBuilderFixtureManagerHome = new TeamBuilderFixtureManager(FixtureStub.getTestTeam(),
                FixtureStub.getOppositeTestHomeTeam(),
                TeamSideEnum.AWAY,
                FixtureStub.getFixtures());
    }

    @Test
    void AllTeamFixturesNumberShouldBeFifTeen(){
        assertThat(teamBuilderFixtureManagerAway.getTeamFixtures(),hasSize(15));
    }

    @Test
    void TeamFixturesQuarterNumberShouldBeFive(){
        assertThat(teamBuilderFixtureManagerAway.getTeamFixturesQuarter(),hasSize(5));
    }

    @Test
    void TeamFixturesSideNumberShouldBeSeven(){
        assertThat(teamBuilderFixtureManagerAway.getTeamSideFixtures(),hasSize(7));
    }

    @Test
    void TeamFixturesSideQuarterNumberShouldBeOne(){
        assertThat(teamBuilderFixtureManagerAway.getTeamSideFixturesQuarter(),hasSize(2));
    }

    @Test
    void TeamFixturesQuarterNumberShouldBeSix(){
        assertThat(teamBuilderFixtureManagerHome.getTeamFixturesQuarter(),hasSize(6));
    }

    @Test
    void TeamFixturesSideNumberShouldBeEight(){
        assertThat(teamBuilderFixtureManagerHome.getTeamSideFixtures(),hasSize(8));
    }

    @Test
    void TeamFixturesSideQuarterNumberShouldBeTwo(){
        assertThat(teamBuilderFixtureManagerHome.getTeamSideFixturesQuarter(),hasSize(2));
    }
}
