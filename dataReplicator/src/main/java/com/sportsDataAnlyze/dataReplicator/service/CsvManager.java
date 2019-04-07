package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class CsvManager {
    public void createDownloadDataCSV(LeagueUrlEnum leagueUrlEnum){
        File directory = new File("data");
        String toFile = "data/" + leagueUrlEnum.name().toLowerCase() + ".csv";
        File file = new File(toFile);
        directory.mkdir();
        try {
            FileUtils.deleteQuietly(file);
            file.createNewFile();
            FileUtils.copyURLToFile(new URL(leagueUrlEnum.getLink().toLowerCase()), new File(toFile), 10000, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
