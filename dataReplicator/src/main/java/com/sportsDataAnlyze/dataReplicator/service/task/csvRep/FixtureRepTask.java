package com.sportsDataAnlyze.dataReplicator.service.task.csvRep;

import com.sportsDataAnlyze.dataReplicator.entity.Fixture;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@Service
public class FixtureRepTask extends RepCsvTask {

    public FixtureRepTask() {
        this.headers = (Arrays.asList(new String[]{"Div","Date","HomeTeam","AwayTeam","FTR","FTHG","FTAG","Referee","HC","AC","HY","AY"}));
    }

    @Override
    protected String mapObjectFromCsv(Map<String, Integer> headersPosition, String[] nextRecord) {
        Fixture fixture = new Fixture();
        for (Map.Entry<String, Integer> entry : headersPosition.entrySet()) {
            switch(entry.getKey()){
                case "HomeTeam":
                    fixture.setHome(nextRecord[entry.getValue()]);
                    break;
                case "AwayTeam":
                    fixture.setAway(nextRecord[entry.getValue()]);
                    break;
                case "Div":
                    fixture.setLeague(nextRecord[entry.getValue()]);
                    break;
                case "Date":
                    fixture.setFixtureDate(nextRecord[entry.getValue()]);
                    break;
                case "FTHG":
                    fixture.setHomeGoals(nextRecord[entry.getValue()]);
                    break;
                case "FTAG":
                    fixture.setAwayGoals(nextRecord[entry.getValue()]);
                    break;
                case "HY":
                    fixture.setHomeYellows(nextRecord[entry.getValue()]);
                    break;
                case "AY":
                    fixture.setAwawyYellows(nextRecord[entry.getValue()]);
                    break;
                case "HC":
                    fixture.setHomeCorners(nextRecord[entry.getValue()]);
                    break;
                case "AC":
                    fixture.setAwayCorners(nextRecord[entry.getValue()]);
                    break;
                case "Referee":
                    fixture.setReferee(nextRecord[entry.getValue()].replace(" ","."));
                    break;
                case "FTR":
                    fixture.setResult(nextRecord[entry.getValue()]);
                    break;
            }
        }
        return fixture.getInsertQuery();
    }

    @Override
    public void wipeTable() throws SQLException {
        connection.createStatement().executeUpdate("DELETE FROM rep_data.football");
        connection.commit();
    }
}
