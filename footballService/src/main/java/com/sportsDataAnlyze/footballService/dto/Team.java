package com.sportsDataAnlyze.footballService.dto;

public class Team {
    private String teamName;
    private Double position;
    private Double positionH;
    private Double positionA;
    private Cards cards;
    private Corners corners;
    private Goals goals;

    public Team(String teamName, Double position, Double positionH, Double positionA, Cards cards, Corners corners, Goals goals) {
        this.teamName = teamName;
        this.position = position;
        this.positionH = positionH;
        this.positionA = positionA;
        this.cards = cards;
        this.corners = corners;
        this.goals = goals;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public Corners getCorners() {
        return corners;
    }

    public void setCorners(Corners corners) {
        this.corners = corners;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getPosition() {
        return position;
    }

    public void setPosition(Double position) {
        this.position = position;
    }

    public Double getPositionH() {
        return positionH;
    }

    public void setPositionH(Double positionH) {
        this.positionH = positionH;
    }

    public Double getPositionA() {
        return positionA;
    }

    public void setPositionA(Double positionA) {
        this.positionA = positionA;
    }

}

