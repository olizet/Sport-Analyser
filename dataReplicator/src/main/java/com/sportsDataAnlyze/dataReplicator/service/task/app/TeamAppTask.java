package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.entity.Team;
import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.ReplicationTask;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamAppTask extends ReplicationTask {
    private List<Team> teams;
    private Map<String, Integer> homeTable;
    private Map<String, Integer> awayTable;
    private Map<String, Integer> overallTable;

    @Override
    public void wipeTable() throws SQLException {
        connection.createStatement().executeUpdate("DELETE FROM football.team");
        connection.commit();
    }

    @Override
    public void createReplicationFlow(SourceUrlEnum sourceUrlEnum) throws SQLException {
        initMaps();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(String.format(TeamTaskQueries.GET_ALL_TEAMS_FORMAT, sourceUrlEnum.name()));
        while (rs.next()) {
            teams.add(new Team(rs.getString("team_name"), rs.getString("league")));
        }
        generateTable(String.format(TeamTaskQueries.HOME_TABLE_QUERY_FORMAT,sourceUrlEnum),homeTable);
        generateTable(String.format(TeamTaskQueries.AWAY_TABLE_QUERY_FORMAT,sourceUrlEnum),awayTable);
        generateTable(String.format(TeamTaskQueries.OVERALL_TABLE_QUERY_FORMAT,sourceUrlEnum,sourceUrlEnum),overallTable);

        Statement insertStatement = connection.createStatement();

        teams.stream()
                .map(t -> t.setPositions(homeTable,awayTable,overallTable))
                .forEach(t ->
                    { try { insertStatement.addBatch(t.getInsertQuery());
                    } catch (SQLException e) {
                        e.printStackTrace();}
                });

        insertStatement.executeBatch();
        connection.commit();
    }

    private void initMaps() {
        teams = new ArrayList<>();
        homeTable = new HashMap<>();
        awayTable = new HashMap<>();
        overallTable = new HashMap<>();
    }

    private void generateTable(String query, Map<String,Integer> map) throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery(query);
        while(rs.next()){
            map.put(rs.getString("team_name"),rs.getInt("position"));
        }
    }

}
