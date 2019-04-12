package com.sportsDataAnlyze.footballService.enums;

public enum LeagueUrlEnum {

    PREMIER_LEAGUE("http://www.football-data.co.uk/mmz4281/1819/E0.csv"),
    CHAMPIONSHIP("http://www.football-data.co.uk/mmz4281/1819/E1.csv"),
    PRIMERA_DIVISION("http://www.football-data.co.uk/mmz4281/1819/SP1.csv"),
    BUNDESLIGA("http://www.football-data.co.uk/mmz4281/1819/D1.csv"),
    SERIE_A("http://www.football-data.co.uk/mmz4281/1819/I1.csv"),
    LEAGUE_UN("http://www.football-data.co.uk/mmz4281/1819/F1.csv");



    private String link;


    LeagueUrlEnum(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
