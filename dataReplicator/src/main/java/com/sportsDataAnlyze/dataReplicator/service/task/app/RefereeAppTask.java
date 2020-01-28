package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.ReplicationTask;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Statement;

@Service
public class RefereeAppTask extends ReplicationTask {
    private static final String QUERY=
            "insert into football.referee(ref_name,avg_cards,matches) \n" +
            " select \n" +
            "f.ref_name, \n" +
            "round(avg(cast(f.home_yellows as integer)+ cast(f.away_yellows as integer)),1) as avg_cards,\n" +
            "count(f.league) as matches\n" +
            "from rep_data.football f \n" +
            "where f.ref_name is not null \n" +
            "group by ref_name";

    @Override
    public void createReplicationFlow(SourceUrlEnum sourceUrlEnum) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(QUERY);
        connection.commit();
    }

    @Override
    public void wipeTable() throws SQLException {
        connection.createStatement().executeUpdate("DELETE FROM football.referee");
        connection.commit();
    }
}
