package com.sportsDataAnlyze.dataReplicator.entity;

import javax.persistence.*;
import java.util.Map;

public class Team {
    private String teamName;
    private String league;
    private Integer position;
    private Integer positionH;
    private Integer positionA;


    public Team(String teamName, String league) {
        this.teamName = teamName;
        this.league = league;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPositionH() {
        return positionH;
    }

    public void setPositionH(Integer positionH) {
        this.positionH = positionH;
    }

    public Integer getPositionA() {
        return positionA;
    }

    public void setPositionA(Integer positionA) {
        this.positionA = positionA;
    }

    public String getInsertQuery(){
        return String.format("INSERT INTO football.team (team_name,league,position_overall,position_home,position_away)" +
                        "VALUES('%s','%s','%s','%s','%s')",
                this.teamName,this.league,this.position,this.positionH,this.positionA);
    }

    public Team setPositions(Map<String,Integer> homeTable, Map<String,Integer> awayTable, Map<String,Integer> overallTable) {
        this.setPositionH(homeTable.get(this.getTeamName()));
        this.setPositionA(awayTable.get(this.getTeamName()));
        this.setPosition(overallTable.get(this.getTeamName()));
        return this;
    }
}
