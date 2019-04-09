package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.service.task.FixtureTask;
import com.sportsDataAnlyze.dataReplicator.service.task.RefereeTask;
import com.sportsDataAnlyze.dataReplicator.service.task.TeamTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@Service
public class ReplicationFacade {

    @Autowired
    RefereeTask refereeTask;

//    @Autowired
//    CsvManager csvManager;

    @Autowired
    FixtureTask fixtureTask;

    @Autowired
    TeamTask teamTask;

    public void replicationService() throws IOException{
        teamTask.prepareTableForRep();
        teamTask.generateResult();
//        refereeTask.prepareTableForRep();
//        refereeTask.generateRefResult();
//
//        fixtureTask.prepareTableForRep();
//        fixtureTask.readRepData();
//            csvManager.createDownloadDataCSV(league);
//            fixtureTask.repDataToDatabase(league);



        }
    }
