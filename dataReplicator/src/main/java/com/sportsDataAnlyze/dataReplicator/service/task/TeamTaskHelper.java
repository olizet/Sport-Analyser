package com.sportsDataAnlyze.dataReplicator.service.task;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.enums.TableEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamTaskHelper {
    private LeagueUrlEnum leagueUrlEnum;
    private static String AWAY_TABLE_QUERY;
    private static String HOME_TABLE_QUERY;
    private static String OVERALL_TABLE_QUERY;

    public TeamTaskHelper(LeagueUrlEnum leagueUrlEnum) {
        this.leagueUrlEnum = leagueUrlEnum;
        this.AWAY_TABLE_QUERY = "SELECT row_number() OVER (ORDER BY outt.pkt DESC) AS position,\n" +
                "            outt.away as team,\n" +
                "            outt.pkt\n" +
                "           FROM ( SELECT f.away,\n" +
                "                    sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'A'::text THEN 3\n" +
                "                            WHEN f.result = 'D'::text THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END) AS pkt\n" +
                "                   FROM football.fixtures f\n" +
                "                   where f.league='" + leagueUrlEnum.name() + "' \n" +
                "                  GROUP BY f.away\n" +
                "                  ORDER BY (sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'A'::text THEN 3\n" +
                "                            WHEN f.result = 'D'::text THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END)) DESC) outt";

        this.HOME_TABLE_QUERY = "SELECT row_number() OVER (ORDER BY outt.pkt DESC) AS position,\n" +
                "            outt.home as team,\n" +
                "            outt.pkt\n" +
                "           FROM ( SELECT f.home,\n" +
                "                    sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'H'::text THEN 3\n" +
                "                            WHEN f.result = 'D'::text THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END) AS pkt\n" +
                "                   FROM football.fixtures f\n" +
                "                   where f.league='" + leagueUrlEnum.name() + "' \n" +
                "                  GROUP BY f.home\n" +
                "                  ORDER BY (sum(\n" +
                "                        CASE\n" +
                "                            WHEN f.result = 'H'::text THEN 3\n" +
                "                            WHEN f.result = 'D'::text THEN 1\n" +
                "                            ELSE 0\n" +
                "                        END)) DESC) outt";
        this.OVERALL_TABLE_QUERY = " SELECT home.team as team,\n" +
                "    home.pkt + away.pkt AS pkt,\n" +
                "    row_number() OVER (ORDER BY (home.pkt + away.pkt) DESC) AS position\n" +
                "   FROM (" + HOME_TABLE_QUERY + ") home\n" +
                "     JOIN (" + AWAY_TABLE_QUERY + ") away ON home.team = away.team\n" +
                "  ORDER BY (home.pkt + away.pkt) DESC";
    }

    public static HashMap<String, Integer> generateTable(TableEnum table) throws SQLException {
        String query = "";
        switch (table) {
            case AWAY:
                query = AWAY_TABLE_QUERY;
                break;
            case HOME:
                query = HOME_TABLE_QUERY;
                break;
            case OVERALL:
                query = OVERALL_TABLE_QUERY;
        }
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sports_data", "postgres", "bookmaker");
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(query);
        HashMap<String, Integer> resultTable = new HashMap<>();
        while (rs.next()) {
            resultTable.put(rs.getString("team"), rs.getInt("position"));
        }
        return resultTable;
    }
}