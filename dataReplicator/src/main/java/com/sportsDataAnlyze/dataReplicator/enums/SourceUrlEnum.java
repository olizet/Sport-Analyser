package com.sportsDataAnlyze.dataReplicator.enums;

public enum SourceUrlEnum {
    I1("http://www.football-data.co.uk/mmz4281/1920/I1.csv"),
    F1("http://www.football-data.co.uk/mmz4281/1920/F1.csv"),
    E0("http://www.football-data.co.uk/mmz4281/1920/E0.csv"),
    E1("http://www.football-data.co.uk/mmz4281/1920/E1.csv"),
    SP1("http://www.football-data.co.uk/mmz4281/1920/SP1.csv"),
    D1("http://www.football-data.co.uk/mmz4281/1920/D1.csv"),
    B1("https://www.football-data.co.uk/mmz4281/1920/B1.csv"),
    P1("https://www.football-data.co.uk/mmz4281/1920/P1.csv"),
    N1("https://www.football-data.co.uk/mmz4281/1920/N1.csv");

    private String link;

    SourceUrlEnum(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
