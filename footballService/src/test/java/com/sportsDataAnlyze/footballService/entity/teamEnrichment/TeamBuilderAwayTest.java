package com.sportsDataAnlyze.footballService.entity.teamEnrichment;

import com.sportsDataAnlyze.footballService.entity.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


class TeamBuilderAwayTest {

    private static Team testRapport;
    private static TeamBuilderAway teamBuilderAway;

    @BeforeAll
    private static void getTeamStub(){
        teamBuilderAway = new TeamBuilderAway(FixtureStub.getTestTeam(),
                                              FixtureStub.getOppositeTestAwayTeam(),
                                              FixtureStub.getFixtures());

        testRapport = teamBuilderAway.buildTeam();
    }

    @Test
    void AllTeamFixturesNumberShouldBeFifTeen(){
        assertThat(teamBuilderAway.getTeamFixtures(),hasSize(15));
    }

    @Test
    void TeamFixturesQuarterNumberShouldBeFive(){
        assertThat(teamBuilderAway.getTeamFixturesQuarter(),hasSize(5));
    }

    @Test
    void TeamFixturesSideNumberShouldBeSeven(){
       assertThat(teamBuilderAway.getTeamSideFixtures(),hasSize(7));
    }

    @Test
    void TeamFixturesSideQuarterNumberShouldBeOne(){
        assertThat(teamBuilderAway.getTeamSideFixturesQuarter(),hasSize(2));
    }

    @Test
    void GoalsQuarterShouldBeOnePointTwoAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsQuarter(),is(1.2));
    }

    @Test
    void GoalsOppSideQuarterShouldBePointFour(){
        assertThat(testRapport.getTeamRapportStats().getGoalsOppSideQuarter(),is(0.6));
    }

    @Test
    void GoalsSideShouldBeOnePointThreeAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsSide(),is(1.2857142857142858));
    }

    @Test
    void GoalsSideOppSideShouldBeOnePointFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsOppSide(),is(1.5714285714285714));
    }

    @Test
    void GoalsSideQuarterShouldBeOneAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsSideQuarter(),is(1.0));
    }

    @Test
    void GoalsSideQuarterOppSideShouldBeOnePointFiveAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsSideOppSiderQuarter(),is(1.5));
    }
    @Test
    void CardsQuarterShouldBeTwoPointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsQuarter(),is(2.6));
    }

    @Test
    void CardsOppSideQuarterShouldBePointSix(){
        assertThat(testRapport.getTeamRapportStats().getCardsOppSideQuarter(),is(0.6));
    }

    @Test
    void CardsSideShouldBeThreePointFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsSide(),is(3.4285714285714284));
    }

    @Test
    void CardsSideOppSideShouldBeOnePointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsOppSide(),is(1.5714285714285714));
    }

    @Test
    void CardsSideQuarterShouldBeTwoAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsSideQuarter(),is(4.0));
    }

    @Test
    void CardsSideQuarterOppSideShouldBeFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsSideOppSideQuarter(),is(2.0));
    }

    @Test
    void CornersQuarterShouldBeTwoPointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersQuarter(),is(2.6));
    }

    @Test
    void CornersOppSideQuarterShouldBeThreePointTwo(){
        assertThat(testRapport.getTeamRapportStats().getCornersOppSideQuarter(),is(3.2));
    }

    @Test
    void CornersSideShouldBeThreePointFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersSide(),is(6.0));
    }

    @Test
    void CornersSideOppSideShouldBeFourPointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersOppSide(),is(4.571428571428571));
    }

    @Test
    void CornersSideQuarterShouldBeSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersSideQuarter(),is(6.0));
    }

    @Test
    void CornersSideQuarterOppSideShouldBeSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersSideOppSideQuarter(),is(6.0));
    }


}