package com.sportsDataAnlyze.dataReplicator.entity;

import javax.persistence.*;

@Entity
@Table(schema = "football", name="referee")
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ref_name")
    private String refName;

    @Column(name="avg_cards")
    private Double avgCards = 0.0;

    @Transient
    private Integer cards = 0;

    @Transient
    private Integer matches = 0;

    public Integer getCards() {
        return cards;
    }

    public void setCards(Integer cards) {
        this.cards = cards;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
