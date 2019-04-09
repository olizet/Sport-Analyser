package com.sportsDataAnlyze.dataReplicator.service.task.rep;

import com.opencsv.CSVReader;
import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.ITask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public abstract class AbstractTask<T,ID,DAO extends PagingAndSortingRepository<T,ID>> implements ITask {
    private String[] headers;

    @Autowired
    protected DAO dao;

    public AbstractTask(String[] headers) {
        this.headers = headers;
    }


    public void prepareTableForRep() {
        dao.deleteAll();
    }

    public void readRepData() throws IOException {
        for (LeagueUrlEnum league : LeagueUrlEnum.values()) {
            Map<String, Integer> headersPosition = new HashMap<>();
            Path pathFromFile = Paths.get("data/" + league.name().toLowerCase() + ".csv");
            BufferedReader bf = Files.newBufferedReader(pathFromFile);
            CSVReader reader = new CSVReader(bf);
            String[] nextRecord;
            boolean isFirstRow = true;
            while ((nextRecord = reader.readNext()) != null) {
                if (isFirstRow) {
                    for (int i = 0; i < nextRecord.length; i++) {
                        if (checkHeader(nextRecord[i])) {
                            headersPosition.put(nextRecord[i], i);
                        }
                    }
                    isFirstRow = false;
                } else {
                    mapObject( headersPosition, nextRecord);
                }
            }
            reader.close();
        }
    }

    private boolean checkHeader(String header) {
        List<String> list = new ArrayList<>(Arrays.asList(headers));

        if (list.contains(header)) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract void mapObject(Map<String, Integer> headersPosition, String[] nextRecord);
}
