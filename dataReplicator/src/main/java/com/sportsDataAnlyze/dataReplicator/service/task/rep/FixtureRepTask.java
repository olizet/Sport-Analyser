package com.sportsDataAnlyze.dataReplicator.service.task.rep;

import com.sportsDataAnlyze.dataReplicator.dao.FixtureDao;
import com.sportsDataAnlyze.dataReplicator.dao.RefereeDao;
import com.sportsDataAnlyze.dataReplicator.dao.TeamDao;
import com.sportsDataAnlyze.dataReplicator.entity.Fixture;
import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.utils.RepUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class FixtureRepTask extends AbstractRepTask<Fixture,Long,FixtureDao> {
    private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");

    public FixtureRepTask() {
        super(new String[]{"Div","Date","HomeTeam","AwayTeam","FTR","FTHG","FTAG","Referee","HC","AC","HY","AY"});
    }

    @Autowired
    RefereeDao refereeDao;

    @Autowired
    TeamDao teamDao;

    @Override
    protected void mapObject(Map<String, Integer> headersPosition, String[] nextRecord) {
        Fixture fixture = new Fixture();
        for (Map.Entry<String, Integer> entry : headersPosition.entrySet()) {
            switch(entry.getKey()){
                case "HomeTeam":
                    fixture.setHome(teamDao.findTeamByTeamName(nextRecord[entry.getValue()]));
                    break;
                case "AwayTeam":
                    fixture.setAway(teamDao.findTeamByTeamName(nextRecord[entry.getValue()]));
                    break;
                case "Div":
                    fixture.setLeague(RepUtils.convertStringToLeague(nextRecord[entry.getValue()]));
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
                    fixture.setRefName(refereeDao.findByRefName(nextRecord[entry.getValue()].replace(" ",".")));
                    break;
                case "FTR" : fixture.setResult(nextRecord[entry.getValue()]);
                    break;
            }
        }
        if(!headersPosition.containsKey("Referee")){
            fixture.setRefName(null);
        }
        dao.save(fixture);
    }

    @Override
    public void generateResult() {
        try {
            readRepData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
