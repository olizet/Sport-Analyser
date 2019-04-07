package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.FixtureTask;
import com.sportsDataAnlyze.dataReplicator.service.task.RefereeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@Service
public class ReplicationFacade {

    @Autowired
    RefereeTask refereeTask;

    @Autowired
    CsvManager csvManager;

    @Autowired
    FixtureTask fixtureTask;

    public void replicationService() throws IOException, SQLException, ParseException {
//        refereeTask.prepareTableForReplication();
//        fixtureTask.prepareTableForReplication();
        for (LeagueUrlEnum league : LeagueUrlEnum.values()) {
//            csvManager.createDownloadDataCSV(league);
//            fixtureTask.repDataToDatabase(league);
        }
        refereeTask.repDataToDatabase();
    }
}
