package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.app.FixtureAppTask;
import com.sportsDataAnlyze.dataReplicator.service.task.app.RefereeAppTask;
import com.sportsDataAnlyze.dataReplicator.service.task.app.TeamAppTask;
import com.sportsDataAnlyze.dataReplicator.service.task.csvRep.RepCsvTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class ReplicationFacade {

    @Autowired
    CsvController csvController;

    @Autowired
    RepCsvTask fixtureRepTask;

    @Autowired
    RefereeAppTask refereeAppTask;

    @Autowired
    TeamAppTask teamAppTask;

    @Autowired
    FixtureAppTask fixtureAppTask;

    public void replicationService() throws SQLException, IOException {
        //csv data download and create file
        csvController.createDownloadDataCSV();

        // uploading raw replicated data to database
        fixtureRepTask.wipeTable();
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.E0);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.E1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.D1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.SP1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.I1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.F1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.B1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.N1);
        fixtureRepTask.createReplicationFlow(SourceUrlEnum.P1);

        // cleaning current replicated tables in database
        fixtureAppTask.wipeTable();
        teamAppTask.wipeTable();
        refereeAppTask.wipeTable();

        // generating data basing on replicated data and uploading to database
        teamAppTask.createReplicationFlow(SourceUrlEnum.E0);
        teamAppTask.createReplicationFlow(SourceUrlEnum.E1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.SP1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.D1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.F1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.I1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.B1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.N1);
        teamAppTask.createReplicationFlow(SourceUrlEnum.P1);
        refereeAppTask.createReplicationFlow(null);
        fixtureAppTask.createReplicationFlow(null);
        }
    }
