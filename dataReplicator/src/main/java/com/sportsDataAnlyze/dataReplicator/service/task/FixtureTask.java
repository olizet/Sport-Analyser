package com.sportsDataAnlyze.dataReplicator.service.task;

import com.opencsv.CSVReader;
import com.sportsDataAnlyze.dataReplicator.dao.FixtureDao;
import com.sportsDataAnlyze.dataReplicator.entity.Fixture;
import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FixtureTask implements ITask {
    private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    FixtureDao fixtureDao;

    @Override
    public void prepareTableForReplication() throws SQLException {
        fixtureDao.deleteAll();
    }


    public void repDataToDatabase(LeagueUrlEnum leagueUrlEnum) throws IOException, SQLException, ParseException {

        Map<String,Integer> headersPosition = new HashMap<>();

        Path pathFromFile = Paths.get("data/"+leagueUrlEnum.name().toLowerCase()+".csv");
        BufferedReader bf = Files.newBufferedReader(pathFromFile);
        CSVReader reader = new CSVReader(bf);

        String[] nextRecord;
        boolean isFirstRow = true;
        while ((nextRecord = reader.readNext()) != null) {
            Fixture fixture = new Fixture();
            if(isFirstRow){
                for(int i=0;i<nextRecord.length;i++){
                    if(checkHeader(nextRecord[i])){
                        headersPosition.put(nextRecord[i],i);
                    }
                }
                isFirstRow =false;
            } else {
                fixture = mapFixture(fixture,headersPosition,nextRecord);
                fixtureDao.save(fixture);
            }
        }
    }

    private Fixture mapFixture(Fixture fixture,Map<String,Integer> headersPosition, String[] nextRecord) throws SQLException, ParseException {

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
                    fixture.setFixtureDate(new java.sql.Date(df.parse(nextRecord[entry.getValue()]).getTime())) ;
                    break;
                case "FTHG":
                    fixture.setHomeGoals(Integer.parseInt(nextRecord[entry.getValue()]));
                    break;
                case "FTAG":
                    fixture.setAwayGoals( Integer.parseInt(nextRecord[entry.getValue()]));
                    break;
                case "HY":
                    fixture.setHomeYellows( Integer.parseInt(nextRecord[entry.getValue()]));
                    break;
                case "AY":
                    fixture.setAwayTellows( Integer.parseInt(nextRecord[entry.getValue()]));
                    break;
                case "HC":
                    fixture.setHomeCorners(Integer.parseInt(nextRecord[entry.getValue()]));
                    break;
                case "AC":
                    fixture.setAwayCorners(Integer.parseInt(nextRecord[entry.getValue()]));
                    break;
                case "Referee": fixture.setRefereeName(nextRecord[entry.getValue()].replace(" ","."));
                    break;
                case "FTR" : fixture.setResult(nextRecord[entry.getValue()]);
                    break;
            }
        }
        if(!headersPosition.containsKey("Referee")){
            fixture.setRefereeName(null);
        }
        return fixture;
    }

    private boolean checkHeader(String header) {
        List<String> list = new ArrayList<>(Arrays.asList("Div","Date","HomeTeam","AwayTeam","FTR","FTHG","FTAG","Referee","HC","AC","HY","AY"));
        if(list.contains(header)){
            return true;
        } else {
            return false;
        }
    }

}
