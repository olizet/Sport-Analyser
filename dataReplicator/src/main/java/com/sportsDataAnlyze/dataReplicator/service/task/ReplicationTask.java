package com.sportsDataAnlyze.dataReplicator.service.task;

import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class ReplicationTask {

    protected Connection connection;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void createConnection(){
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public abstract void createReplicationFlow(SourceUrlEnum sourceUrlEnum) throws SQLException, IOException;

    public abstract void wipeTable() throws SQLException;
}
