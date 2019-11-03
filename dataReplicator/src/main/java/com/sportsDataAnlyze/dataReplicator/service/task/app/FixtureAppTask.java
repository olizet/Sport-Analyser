package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.ReplicationTask;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class FixtureAppTask extends ReplicationTask {

    private static final String QUERY = "INSERT INTO football.fixture " +
            "(home,away,league,fixture_date,home_goals,away_goals,home_yellows,away_yellows,home_corners,away_corners,result,ref_name)\n" +
            "select home,away,league,cast(fixture_date as date),cast(home_goals as int),cast(away_goals as int),cast(home_yellows as int),\n" +
            "cast(away_yellows as int),cast(home_corners as int),cast(away_corners as int), result, ref_name\n" +
            "from rep_data.football";
    @Override
    public void createReplicationFlow(SourceUrlEnum sourceUrlEnum) throws SQLException, IOException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(QUERY);
        connection.commit();
    }

    @Override
    public void wipeTable() throws SQLException {
        connection.createStatement().executeUpdate("DELETE FROM football.fixture");
        connection.commit();
    }
}
