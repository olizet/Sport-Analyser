package com.sportsDataAnlyze.dataReplicator.entity;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;

import javax.persistence.*;

@Entity
@Table(schema = "football", name="team")
public class Team {
    @Id
    @Column(name = "team_name")
    private String teamName;

    @Column(name="league")
    private String league;

    @Column(name = "position_overall")
    private Double position;

    @Column(name="position_home")
    private Double positionH;

    @Column(name="position_away")
    private Double positionA;

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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
