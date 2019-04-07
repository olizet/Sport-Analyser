package com.sportsDataAnlyze.dataReplicator.service.task;

import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface ITask{

    void prepareTableForReplication() throws SQLException;

}
