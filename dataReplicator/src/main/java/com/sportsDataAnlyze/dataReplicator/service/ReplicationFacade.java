package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.service.task.app.RefereeAppTask;
import com.sportsDataAnlyze.dataReplicator.service.task.app.TeamAppTask;
import com.sportsDataAnlyze.dataReplicator.service.task.rep.FixtureRepTask;
import com.sportsDataAnlyze.dataReplicator.service.task.rep.RefereeRepTask;
import com.sportsDataAnlyze.dataReplicator.service.task.rep.TeamRepTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplicationFacade {

    @Autowired
    RefereeRepTask refereeTask;

    @Autowired
    CsvManager csvManager;

    @Autowired
    FixtureRepTask fixtureTask;

    @Autowired
    TeamRepTask teamTask;

    @Autowired
    TeamAppTask teamAppTask;

    @Autowired
    RefereeAppTask refereeAppTask;

    public void replicationService() {
        csvManager.createDownloadDataCSV();

        fixtureTask.prepareTableForRep();
        teamTask.prepareTableForRep();
        refereeTask.prepareTableForRep();

        teamTask.generateResult();
        refereeTask.generateResult();
        fixtureTask.generateResult();
        teamAppTask.generateResult();
        refereeAppTask.generateResult();
        }
    }
