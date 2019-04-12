package com.sportsDataAnlyze.footballService.entity;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;

import javax.persistence.*;

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
}
