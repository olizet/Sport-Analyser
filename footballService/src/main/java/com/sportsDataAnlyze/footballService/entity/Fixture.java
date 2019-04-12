package com.sportsDataAnlyze.footballService.entity;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "football", name="fixture")
public class Fixture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Team.class)
    @JoinColumn(name="home")
    private Team home;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Team.class)
    @JoinColumn(name="away")
    private Team away;

    @Column(name="league")
    @Enumerated(EnumType.STRING)
    private LeagueUrlEnum league;

    @Column(name="fixture_date")
    private Date fixtureDate;

    @Column(name="home_goals")
    private Integer homeGoals;

    @Column(name="away_goals")
    private Integer awayGoals;

    @Column(name="home_yellows")
    private Integer homeYellows;

    @Column(name="away_yellows")
    private Integer awayTellows;

    @Column(name="home_corners")
    private Integer homeCorners;

    @Column(name="away_corners")
    private Integer awayCorners;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Referee.class)
    @JoinColumn(name="ref_name")
    private Referee refName;

    @Column(name="result")
    private String result;

    public Referee getRefName() {
        return refName;
    }

    public void setRefName(Referee refName) {
        this.refName = refName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public LeagueUrlEnum getLeague() {
        return league;
    }

    public void setLeague(LeagueUrlEnum league) {
        this.league = league;
    }

    public Date getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(Date fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public Integer getHomeYellows() {
        return homeYellows;
    }

    public void setHomeYellows(Integer homeYellows) {
        this.homeYellows = homeYellows;
    }

    public Integer getAwayTellows() {
        return awayTellows;
    }

    public void setAwayTellows(Integer awayTellows) {
        this.awayTellows = awayTellows;
    }

    public Integer getHomeCorners() {
        return homeCorners;
    }

    public void setHomeCorners(Integer homeCorners) {
        this.homeCorners = homeCorners;
    }

    public Integer getAwayCorners() {
        return awayCorners;
    }

    public void setAwayCorners(Integer awayCorners) {
        this.awayCorners = awayCorners;
    }
}
