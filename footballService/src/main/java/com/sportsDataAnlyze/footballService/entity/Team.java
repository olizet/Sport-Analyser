package com.sportsDataAnlyze.footballService.entity;


import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.footballService.enums.TeamSideEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "football", name="team")
public class Team {
    @Id
    @Column(name = "team_name")
    private String teamName;

    @Column(name="league")
    @Enumerated(EnumType.STRING)
    private LeagueUrlEnum league;

    @Column(name = "position_overall")
    private Integer position;

    @Column(name="position_home")
    private Integer positionH;

    @Column(name="position_away")
    private Integer positionA;

    @Embedded
    @Transient
    private TeamRapportStats teamRapportStats = new TeamRapportStats();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LeagueUrlEnum getLeague() {
        return league;
    }

    public void setLeague(LeagueUrlEnum league) {
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

    public TeamRapportStats getTeamRapportStats() {
        return teamRapportStats;
    }

    public void setTeamRapportStats(TeamRapportStats teamRapportStats) {
        this.teamRapportStats = teamRapportStats;
    }

    @Transient
    public int getTeamSideQuarterStats(TeamSideEnum teamSideEnum){

        int position = teamSideEnum.equals(TeamSideEnum.HOME)?this.positionH:this.positionA;

        if(position<=5){
            return 1;
        } else if(position<=10){
            return 2;
        } else if(position<=15){
            return 3;
        } else {
            return 4;
        }
    }

    @Transient
    public int getTeamQuarterStats(){

        if(this.position<5){
            return 1;
        } else if(this.position<10){
            return 2;
        } else if(this.position<15){
            return 3;
        } else {
            return 4;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        } else{
            Team team2 = (Team) obj;
            if(Objects.isNull(team2.teamName) ||!this.teamName.equals(team2.teamName)){
                return false;
            }else if(Objects.isNull(team2.league) || !this.league.equals(team2.league)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.teamName,this.league);
    }

    public Team() {}

    public Team(String teamName, LeagueUrlEnum league, Integer position, Integer positionH, Integer positionA) {
        this.teamName = teamName;
        this.league = league;
        this.position = position;
        this.positionH = positionH;
        this.positionA = positionA;
    }
}
