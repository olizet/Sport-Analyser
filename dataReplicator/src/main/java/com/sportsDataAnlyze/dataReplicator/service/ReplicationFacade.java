package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.service.task.rep.FixtureTask;
import com.sportsDataAnlyze.dataReplicator.service.task.rep.RefereeTask;
import com.sportsDataAnlyze.dataReplicator.service.task.rep.TeamTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReplicationFacade {

    @Autowired
    RefereeTask refereeTask;

    @Autowired
    CsvManager csvManager;

    @Autowired
    FixtureTask fixtureTask;

    @Autowired
    TeamTask teamTask;

    public void replicationService() throws IOException{
        csvManager.createDownloadDataCSV();

        fixtureTask.prepareTableForRep();
        teamTask.prepareTableForRep();
        refereeTask.prepareTableForRep();

        teamTask.generateResult();
        refereeTask.generateResult();
        fixtureTask.generateResult();
        }
    }
