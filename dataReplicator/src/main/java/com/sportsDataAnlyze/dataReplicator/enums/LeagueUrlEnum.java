package com.sportsDataAnlyze.dataReplicator.enums;

public enum LeagueUrlEnum {

    PRIMERA_DIVISION_2018_2019("http://www.football-data.co.uk/mmz4281/1819/SP1.csv"),
    PREMIER_LEAGUE_2018_2019("http://www.football-data.co.uk/mmz4281/1819/E0.csv"),
    BUNDESLIGA_2018_2019("http://www.football-data.co.uk/mmz4281/1819/D1.csv"),
    SERIE_A_2018_2019("http://www.football-data.co.uk/mmz4281/1819/I1.csv"),
    LEAGUE_UN_2018_2019("http://www.football-data.co.uk/mmz4281/1819/F1.csv"),
    CHAMPIONSHIP_2018_2019("http://www.football-data.co.uk/mmz4281/1819/E1.csv");


    private String link;


    LeagueUrlEnum(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
