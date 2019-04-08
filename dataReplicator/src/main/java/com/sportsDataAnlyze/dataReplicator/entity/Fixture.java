package com.sportsDataAnlyze.dataReplicator.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "football", name="fixture")
public class Fixture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="home")
    private String home;

    @Column(name="away")
    private String away;

    @Column(name="league")
    private String league;

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
    @JoinColumn(name="referee_id")
    private Referee refereeId;

    @Column(name="result")
    private String result;


    public Referee getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Referee refereeId) {
        this.refereeId = refereeId;
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

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
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
