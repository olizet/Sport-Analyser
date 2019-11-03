package com.sportsDataAnlyze.dataReplicator.service.task.app;

public class TeamTaskQueries {
    public static String GET_ALL_TEAMS_FORMAT = "select f.home as team_name,f.league from rep_data.football f where f.league='%s' group by f.home, f.league";

    public static String AWAY_TABLE_QUERY_FORMAT = "SELECT outt.away as team_name,  \n" +
            "           cast(row_number() OVER (ORDER BY outt.pkt DESC) as integer) AS position,  \n" +
            "           outt.pkt \n" +
            "           FROM ( SELECT f.away,\n" +
            "                    sum(\n" +
            "                        CASE\n" +
            "                            WHEN f.result = 'A' THEN 3\n" +
            "                            WHEN f.result = 'D' THEN 1\n" +
            "                            ELSE 0\n" +
            "                        END) AS pkt\n" +
            "                   FROM rep_data.football f\n" +
            "                   where f.league='%s' \n" +
            "                  GROUP BY f.away\n" +
            "                  ORDER BY (sum(\n" +
            "                        CASE\n" +
            "                            WHEN f.result = 'A' THEN 3\n" +
            "                            WHEN f.result = 'D' THEN 1\n" +
            "                            ELSE 0\n" +
            "                        END)) DESC) outt";

    public static String HOME_TABLE_QUERY_FORMAT =
            "SELECT outt.home as team_name,\n" +
            "           cast(row_number() OVER (ORDER BY outt.pkt DESC) as integer)AS position, \n" +
            "           outt.pkt \n" +
            "           FROM ( SELECT f.home,\n" +
            "                    sum(\n" +
            "                        CASE\n" +
            "                            WHEN f.result = 'H' THEN 3\n" +
            "                            WHEN f.result = 'D' THEN 1\n" +
            "                            ELSE 0\n" +
            "                        END) AS pkt\n" +
            "                   FROM rep_data.football f\n" +
            "                   where f.league='%s' \n" +
            "                  GROUP BY f.home\n" +
            "                  ORDER BY (sum(\n" +
            "                        CASE\n" +
            "                            WHEN f.result = 'H' THEN 3\n" +
            "                            WHEN f.result = 'D' THEN 1\n" +
            "                            ELSE 0\n" +
            "                        END)) DESC) outt";

    public static String OVERALL_TABLE_QUERY_FORMAT = " SELECT home.team_name as team_name,\n" +
            "    cast(row_number() OVER (ORDER BY (home.pkt + away.pkt) DESC) as integer) AS position \n" +
            "   FROM (" + HOME_TABLE_QUERY_FORMAT + ") home\n" +
            "     JOIN (" + AWAY_TABLE_QUERY_FORMAT + ") away ON home.team_name = away.team_name \n" +
            "  ORDER BY (home.pkt + away.pkt) DESC";

}
