package com.sportsDataAnlyze.dataReplicator.service.task;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.enums.TableEnum;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class TeamTask implements ITask {
    private ArrayList<String> leagueTeams = new ArrayList<>();
    private Map<String, Integer> overallTable = new HashMap<>();
    private Map<String, Integer> homeTable = new HashMap<>();
    private Map<String, Integer> awayTable = new HashMap<>();
    private Map<String, Double> corners = new HashMap<>();
    private Map<String, Double> cards = new HashMap<>();

    @Override
    public void prepareTableForReplication() throws SQLException {
        String query = "DELETE FROM football.team";
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sports_data","postgres","bookmaker");
        Statement statement = c.createStatement();
        statement.executeUpdate(query);
        c.close();

    }


    public void repDataToDatabase(LeagueUrlEnum leagueUrlEnum) throws SQLException, IOException, ParseException {
        getTeams(leagueUrlEnum);
        generateTables(leagueUrlEnum);
        for(String team:leagueTeams){

        }
    }

    public void getTeams(LeagueUrlEnum leagueUrlEnum) throws SQLException {
        String query="select distinct coalesce(home,away) as team from football.fixtures f where f.league='"+leagueUrlEnum.name() + "';";
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sports_data","postgres","bookmaker");
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            leagueTeams.add(rs.getString("team"));
        }
        c.close();
    }
    public void generateTables(LeagueUrlEnum leagueUrlEnum) throws SQLException {
        this.homeTable = TeamTaskHelper.generateTable(TableEnum.HOME);
        this.awayTable = TeamTaskHelper.generateTable(TableEnum.AWAY);
        this.overallTable = TeamTaskHelper.generateTable(TableEnum.OVERALL);
    }

}
