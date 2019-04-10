package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.service.task.ITask;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractAppTask implements ITask {
    protected Connection conn;

    @Autowired
    DataSource dataSource;

    protected ResultSet executeQuery(String query) throws SQLException {
        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    protected abstract void update();
}
