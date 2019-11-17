package com.sportsDataAnlyze.footballService.entity.teamEnrichment;

import com.sportsDataAnlyze.footballService.entity.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


class TeamBuilderHomeTest {

    private static Team testRapport;
    private static TeamBuilderHome teamBuilderHome;

    @BeforeAll
    private static void getTeamStub(){
        teamBuilderHome = new TeamBuilderHome(FixtureStub.getTestTeam(),
                                              FixtureStub.getOppositeTestHomeTeam(),
                                              FixtureStub.getFixtures());

        testRapport = teamBuilderHome.buildTeam();
    }

    @Test
    void AllTeamFixturesNumberShouldBeFifTeen(){
        assertThat(teamBuilderHome.getTeamFixtures(),hasSize(15));
    }

    @Test
    void TeamFixturesQuarterNumberShouldBeFive(){
        assertThat(teamBuilderHome.getTeamFixturesQuarter(),hasSize(6));
    }

    @Test
    void TeamFixturesSideNumberShouldBeSeven(){
       assertThat(teamBuilderHome.getTeamSideFixtures(),hasSize(8));
    }

    @Test
    void TeamFixturesSideQuarterNumberShouldBeOne(){
        assertThat(teamBuilderHome.getTeamSideFixturesQuarter(),hasSize(2));
    }

    @Test
    void GoalsQuarterShouldBeOnePointTwoAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsQuarter(),is(1.1666666666666667));
    }

    @Test
    void GoalsOppSideQuarterShouldBeTwoPointThree(){
        assertThat(testRapport.getTeamRapportStats().getGoalsOppSideQuarter(),is(2.3333333333333335));
    }

    @Test
    void GoalsSideShouldBeOnePointFiveAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsSide(),is(1.5));
    }

    @Test
    void GoalsSideOppSideShouldBeOnePointFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsOppSide(),is(1.625));
    }

    @Test
    void GoalsSideQuarterShouldBeOnePointFiveAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsSideQuarter(),is(1.5));
    }

    @Test
    void GoalsSideQuarterOppSideShouldBeOneAverage(){
        assertThat(testRapport.getTeamRapportStats().getGoalsSideOppSiderQuarter(),is(1.0));
    }
    @Test
    void CardsQuarterShouldBeTwoPointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsQuarter(),is(3.0));
    }

    @Test
    void CardsOppSideQuarterShouldBePointSix(){
        assertThat(testRapport.getTeamRapportStats().getCardsOppSideQuarter(),is(1.8333333333333333));
    }

    @Test
    void CardsSideShouldBeThreePointFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsSide(),is(1.875));
    }

    @Test
    void CardsSideOppSideShouldBeOnePointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsOppSide(),is(1.0));
    }

    @Test
    void CardsSideQuarterShouldBeTwoAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsSideQuarter(),is(1.0));
    }

    @Test
    void CardsSideQuarterOppSideShouldBeFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getCardsSideOppSideQuarter(),is(1.0));
    }

    @Test
    void CornersQuarterShouldBeTwoPointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersQuarter(),is(7.5));
    }

    @Test
    void CornersOppSideQuarterShouldBeThreePointTwo(){
        assertThat(testRapport.getTeamRapportStats().getCornersOppSideQuarter(),is(4.333333333333333));
    }

    @Test
    void CornersSideShouldBeThreePointFourAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersSide(),is(4.375));
    }

    @Test
    void CornersSideOppSideShouldBeFourPointSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersOppSide(),is(2.625));
    }

    @Test
    void CornersSideQuarterShouldBeSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersSideQuarter(),is(2.0));
    }

    @Test
    void CornersSideQuarterOppSideShouldBeSixAverage(){
        assertThat(testRapport.getTeamRapportStats().getCornersSideOppSideQuarter(),is(3.5));
    }


}