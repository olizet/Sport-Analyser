package com.sportsDataAnlyze.dataReplicator.service.task.csvRep;

import com.opencsv.CSVReader;
import com.sportsDataAnlyze.dataReplicator.enums.SourceUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.ReplicationTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RepCsvTask extends ReplicationTask {
    protected List<String> headers;
    protected SourceUrlEnum sourceUrlEnum;
    private Map<String, Integer> headersPosition;

    @Override
    public void createReplicationFlow(SourceUrlEnum sourceUrlEnum) throws SQLException, IOException {
        this.sourceUrlEnum = sourceUrlEnum;

        CSVReader reader = getReader();

        Statement statement = connection.createStatement();

        headersPosition = new HashMap<>();

        String[] nextRecord;
        boolean isHeadersRow = true;
        while ((nextRecord = reader.readNext()) != null) {
            if (isHeadersRow) {
                setHeadersPosition(nextRecord);
                isHeadersRow = false;
            } else {
                statement.addBatch(mapObjectFromCsv(headersPosition, nextRecord));
            }
        }
        reader.close();
        statement.executeBatch();
        connection.commit();
    }

    public CSVReader getReader() throws IOException {
        Path pathFromFile = Paths.get("data/" + sourceUrlEnum.name().toLowerCase() + ".csv");
        BufferedReader bf = Files.newBufferedReader(pathFromFile);
        return new CSVReader(bf);
    }

    public void setHeadersPosition(String[] nextRecord) {
        for (int i = 0; i < nextRecord.length; i++) {
            if (headers.contains(nextRecord[i])) {
                headersPosition.put(nextRecord[i], i);
            }
        }
    }

    protected abstract String mapObjectFromCsv(Map<String, Integer> headersPosition, String[] nextRecord);
}
