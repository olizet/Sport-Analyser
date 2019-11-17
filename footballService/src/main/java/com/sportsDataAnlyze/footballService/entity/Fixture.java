package com.sportsDataAnlyze.footballService.entity;



import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
    private Integer awayYellows;

    @Column(name="home_corners")
    private Integer homeCorners;

    @Column(name="away_corners")
    private Integer awayCorners;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Referee.class)
    @JoinColumns({
            @JoinColumn(name="ref_name",updatable=false,insertable=false)
    })
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

    public Integer getAwayYellows() {
        return awayYellows;
    }

    public void setAwayYellows(Integer awayYellows) {
        this.awayYellows = awayYellows;
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

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        } else{
            Fixture fixture2 = (Fixture) obj;
            if(!this.getHome().equals(fixture2.getHome())){
                return false;
            }else if(!this.getAway().equals(fixture2.getAway())){
                return false;
            } else if(!this.getLeague().equals(fixture2.getLeague())){
                return false;
            } else if(!this.getFixtureDate().equals(fixture2.fixtureDate)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getHome(),this.getAway(),this.getLeague(),this.getFixtureDate());
    }

    public Fixture() {}

    public Fixture(Team home, Team away, LeagueUrlEnum league, Date fixtureDate, Integer homeGoals, Integer awayGoals, Integer homeYellows, Integer awayYellows, Integer homeCorners, Integer awayCorners, Referee refName, String result) {
        this.home = home;
        this.away = away;
        this.league = league;
        this.fixtureDate = fixtureDate;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.homeYellows = homeYellows;
        this.awayYellows = awayYellows;
        this.homeCorners = homeCorners;
        this.awayCorners = awayCorners;
        this.refName = refName;
        this.result = result;
    }
}
