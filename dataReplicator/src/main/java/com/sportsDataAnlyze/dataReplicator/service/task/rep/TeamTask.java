package com.sportsDataAnlyze.dataReplicator.service.task.rep;

import com.sportsDataAnlyze.dataReplicator.dao.TeamDao;
import com.sportsDataAnlyze.dataReplicator.entity.Team;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class TeamTask extends AbstractTask<Team,String,TeamDao> {
    private Set<Team> teams = new HashSet<>();

    public TeamTask() {
        super(new String[]{"HomeTeam","AwayTeam","Div"});
    }

    @Override
    protected void mapObject(Map<String, Integer> headersPosition, String[] nextRecord) {
        Team homeTeam = new Team();
        Team awayTeam = new Team();
        for (Map.Entry<String, Integer> entry : headersPosition.entrySet()) {
            switch(entry.getKey()){
                case "HomeTeam":
                    homeTeam.setTeamName(nextRecord[entry.getValue()]);
                    break;
                case "AwayTeam":
                    awayTeam.setTeamName(nextRecord[entry.getValue()]);
                    break;
                case "Div":
                    homeTeam.setLeague(nextRecord[entry.getValue()]);
                    awayTeam.setLeague(nextRecord[entry.getValue()]);
                    break;
            }
        }
        teams.add(homeTeam);
        teams.add(awayTeam);
    }

    @Override
    public void generateResult(){
        try {
            readRepData();
            dao.saveAll(teams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
