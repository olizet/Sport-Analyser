package com.sportsDataAnlyze.dataReplicator.service;


import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class ReplicationTaskService {

    public void createDataCSV(LeagueUrlEnum leagueUrlEnum){
        File directory = new File("data");
        String toFile = "data/" + leagueUrlEnum.name() + ".csv";
        File file = new File(toFile);
        directory.mkdir();
        try {
            FileUtils.deleteQuietly(file);
//            FileUtils.deleteDirectory(directory);
            file.createNewFile();
            FileUtils.copyURLToFile(new URL(leagueUrlEnum.getLink()), new File(toFile), 10000, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
