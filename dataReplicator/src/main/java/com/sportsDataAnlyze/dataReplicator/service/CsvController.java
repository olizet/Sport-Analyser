package com.sportsDataAnlyze.dataReplicator.service;

import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class CsvController {
    public void createDownloadDataCSV() {
        for (SourceUrlEnum league : SourceUrlEnum.values()) {
            File directory = new File("data");
            String toFile = "data/" + league.name().toLowerCase() + ".csv";
            File file = new File(toFile);
            directory.mkdir();
            try {
                FileUtils.deleteQuietly(file);
                file.createNewFile();
                FileUtils.copyURLToFile(new URL(league.getLink().toLowerCase()), new File(toFile), 10000, 10000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

