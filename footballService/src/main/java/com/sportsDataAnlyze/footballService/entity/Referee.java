package com.sportsDataAnlyze.footballService.entity;

import javax.persistence.*;

@Entity
@Table(schema = "football", name="referee")
public class Referee {

    @Id
    @Column(name="ref_name")
    private String refName;

    @Column(name="avg_cards")
    private Double avgCards = 0.0;

    @Column(name="matches")
    private Integer matches;

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public Double getAvgCards() {
        return avgCards;
    }

    public void setAvgCards(Double avgCards) {
        this.avgCards = avgCards;
    }
}
