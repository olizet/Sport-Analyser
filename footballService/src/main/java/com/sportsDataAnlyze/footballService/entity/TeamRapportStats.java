package com.sportsDataAnlyze.footballService.entity;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class TeamRapportStats {
    private double goalsQuarter;
    private double goalsOppSideQuarter;
    private double goalsSide;
    private double goalsOppSide;
    private double goalsSideQuarter;
    private double goalsSideOppSiderQuarter;
    private double cardsQuarter;
    private double cardsOppSideQuarter;
    private double cardsSide;
    private double cardsOppSide;
    private double cardsSideQuarter;
    private double cardsSideOppSideQuarter;
    private double cornersQuarter;
    private double cornersOppSideQuarter;
    private double cornersSide;
    private double cornersOppSide;
    private double cornersSideQuarter;
    private double cornersSideOppSideQuarter;
    private List<Fixture> last5Fixtures;

    public double getGoalsQuarter() {
        return goalsQuarter;
    }

    public void setGoalsQuarter(double goalsQuarter) {
        this.goalsQuarter = goalsQuarter;
    }

    public double getGoalsOppSideQuarter() {
        return goalsOppSideQuarter;
    }

    public void setGoalsOppSideQuarter(double goalsOppSideQuarter) {
        this.goalsOppSideQuarter = goalsOppSideQuarter;
    }

    public double getGoalsSide() {
        return goalsSide;
    }

    public void setGoalsSide(double goalsSide) {
        this.goalsSide = goalsSide;
    }

    public double getGoalsOppSide() {
        return goalsOppSide;
    }

    public void setGoalsOppSide(double goalsOppSide) {
        this.goalsOppSide = goalsOppSide;
    }

    public double getGoalsSideQuarter() {
        return goalsSideQuarter;
    }

    public void setGoalsSideQuarter(double goalsSideQuarter) {
        this.goalsSideQuarter = goalsSideQuarter;
    }

    public double getGoalsSideOppSiderQuarter() {
        return goalsSideOppSiderQuarter;
    }

    public void setGoalsSideOppSiderQuarter(double goalsSideOppSiderQuarter) {
        this.goalsSideOppSiderQuarter = goalsSideOppSiderQuarter;
    }

    public double getCardsQuarter() {
        return cardsQuarter;
    }

    public void setCardsQuarter(double cardsQuarter) {
        this.cardsQuarter = cardsQuarter;
    }

    public double getCardsOppSideQuarter() {
        return cardsOppSideQuarter;
    }

    public void setCardsOppSideQuarter(double cardsOppSideQuarter) {
        this.cardsOppSideQuarter = cardsOppSideQuarter;
    }

    public double getCardsSide() {
        return cardsSide;
    }

    public void setCardsSide(double cardsSide) {
        this.cardsSide = cardsSide;
    }

    public double getCardsOppSide() {
        return cardsOppSide;
    }

    public void setCardsOppSide(double cardsOppSide) {
        this.cardsOppSide = cardsOppSide;
    }

    public double getCardsSideQuarter() {
        return cardsSideQuarter;
    }

    public void setCardsSideQuarter(double cardsSideQuarter) {
        this.cardsSideQuarter = cardsSideQuarter;
    }

    public double getCardsSideOppSideQuarter() {
        return cardsSideOppSideQuarter;
    }

    public void setCardsSideOppSideQuarter(double cardsSideOppSideQuarter) {
        this.cardsSideOppSideQuarter = cardsSideOppSideQuarter;
    }

    public double getCornersQuarter() {
        return cornersQuarter;
    }

    public void setCornersQuarter(double cornersQuarter) {
        this.cornersQuarter = cornersQuarter;
    }

    public double getCornersOppSideQuarter() {
        return cornersOppSideQuarter;
    }

    public void setCornersOppSideQuarter(double cornersOppSideQuarter) {
        this.cornersOppSideQuarter = cornersOppSideQuarter;
    }

    public double getCornersSide() {
        return cornersSide;
    }

    public void setCornersSide(double cornersSide) {
        this.cornersSide = cornersSide;
    }

    public double getCornersOppSide() {
        return cornersOppSide;
    }

    public void setCornersOppSide(double cornersOppSide) {
        this.cornersOppSide = cornersOppSide;
    }

    public double getCornersSideQuarter() {
        return cornersSideQuarter;
    }

    public void setCornersSideQuarter(double cornersSideQuarter) {
        this.cornersSideQuarter = cornersSideQuarter;
    }

    public double getCornersSideOppSideQuarter() {
        return cornersSideOppSideQuarter;
    }

    public void setCornersSideOppSideQuarter(double cornersSideOppSideQuarter) {
        this.cornersSideOppSideQuarter = cornersSideOppSideQuarter;
    }

    public List<Fixture> getLast5Fixtures() {
        return last5Fixtures;
    }

    public void setLast5Fixtures(List<Fixture> last5Fixtures) {
        this.last5Fixtures = last5Fixtures;
    }
}
