package com.sportsDataAnlyze.dataReplicator.service.task;

import com.sportsDataAnlyze.dataReplicator.dao.FixtureDao;
import com.sportsDataAnlyze.dataReplicator.dao.RefereeDao;
import com.sportsDataAnlyze.dataReplicator.entity.Fixture;
import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class FixtureTask extends AbstractTask<Fixture,Long,FixtureDao>{
    private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");

    public FixtureTask() {
        super(new String[]{"Div","Date","HomeTeam","AwayTeam","FTR","FTHG","FTAG","Referee","HC","AC","HY","AY"});
    }

    @Autowired
    RefereeDao refereeDao;

    @Override
    protected void generateRowContent(Map<String, Integer> headersPosition, String[] nextRecord, LeagueUrlEnum leagueUrlEnum) {
        Fixture fixture = new Fixture();
        fixture = mapObject(fixture,headersPosition,nextRecord);
        dao.save(fixture);
    }

    private Fixture mapObject(Fixture fixture, Map<String, Integer> headersPosition, String[] nextRecord) {
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
                    try {
                        fixture.setFixtureDate(new java.sql.Date(df.parse(nextRecord[entry.getValue()]).getTime())) ;
                        break;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
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
                case "Referee":
                    fixture.setRefereeId(refereeDao.findRefByName(nextRecord[entry.getValue()].replace(" ",".")));
                    break;
                case "FTR" : fixture.setResult(nextRecord[entry.getValue()]);
                    break;
            }
        }
        if(!headersPosition.containsKey("Referee")){
            fixture.setRefereeId(null);
        }
        return fixture;
    }
}
