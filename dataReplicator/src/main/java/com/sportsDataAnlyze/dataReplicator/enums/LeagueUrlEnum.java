package com.sportsDataAnlyze.dataReplicator.enums;

public enum LeagueUrlEnum {
    I1("http://www.football-data.co.uk/mmz4281/1819/I1.csv"),
    F1("http://www.football-data.co.uk/mmz4281/1819/F1.csv"),
    E0("http://www.football-data.co.uk/mmz4281/1819/E0.csv"),
    E1("http://www.football-data.co.uk/mmz4281/1819/E1.csv"),
    SP1("http://www.football-data.co.uk/mmz4281/1819/SP1.csv"),
    D1("http://www.football-data.co.uk/mmz4281/1819/D1.csv");

    private String link;


    LeagueUrlEnum(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
