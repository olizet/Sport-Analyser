package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.enums.TableEnum;

public class TeamAppTaskHelper {
    public static String getTableQuery(LeagueUrlEnum league, TableEnum tableEnum){
        String awayTableQuery=String.format("SELECT outt.away as team_name,  \n" +
                "           cast(row_number() OVER (ORDER BY outt.pkt DESC) as integer) AS position,  \n" +
                "           outt.pkt \n" +
                "           FROM ( SELECT f.away,\n" +
                "                    sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'A' THEN 3\n" +
                "                            WHEN f.result = 'D' THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END) AS pkt\n" +
                "                   FROM football.fixture f\n" +
                "                   where f.league='%s' \n" +
                "                  GROUP BY f.away\n" +
                "                  ORDER BY (sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'A' THEN 3\n" +
                "                            WHEN f.result = 'D' THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END)) DESC) outt",league.name());

        String homeTableQuery = String.format("SELECT outt.home as team_name,\n" +
                "           cast(row_number() OVER (ORDER BY outt.pkt DESC) as integer)AS position, \n" +
                "           outt.pkt \n" +
                "           FROM ( SELECT f.home,\n" +
                "                    sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'H' THEN 3\n" +
                "                            WHEN f.result = 'D' THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END) AS pkt\n" +
                "                   FROM football.fixture f\n" +
                "                   where f.league='%s' \n" +
                "                  GROUP BY f.home\n" +
                "                  ORDER BY (sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'H' THEN 3\n" +
                "                            WHEN f.result = 'D' THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END)) DESC) outt",league.name());

        String overalTableQuery =" SELECT home.team_name as team_name,\n" +
                "    cast(row_number() OVER (ORDER BY (home.pkt + away.pkt) DESC) as integer) AS position \n" +
                "   FROM (" + homeTableQuery +") home\n" +
                "     JOIN ("+ awayTableQuery +") away ON home.team_name = away.team_name \n" +
                "  ORDER BY (home.pkt + away.pkt) DESC";
        String returnQuery = "";
        switch(tableEnum){
            case AWAY:
                returnQuery = awayTableQuery;
                break;
            case HOME:
                returnQuery = homeTableQuery;
                break;
            case OVERALL:
                returnQuery = overalTableQuery;
                break;
        }
        return returnQuery;
    }

}
