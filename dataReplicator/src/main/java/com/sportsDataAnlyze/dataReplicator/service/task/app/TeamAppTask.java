package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.dao.TeamDao;
import com.sportsDataAnlyze.dataReplicator.entity.Team;
import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.dataReplicator.enums.TableEnum;
import com.sportsDataAnlyze.dataReplicator.service.task.ITask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class TeamAppTask extends AbstractAppTask  {
    private ArrayList<Team> teams = new ArrayList<>();
    private Map<String,Integer> homeTable = new HashMap<>();
    private Map<String,Integer> awayTable = new HashMap<>();
    private Map<String,Integer> overallTable = new HashMap<>();

    @Autowired
    private TeamDao teamDao;

    @Override
    public void generateResult() {
        teams = (ArrayList<Team>) teamDao.findAll();
        for (LeagueUrlEnum league : LeagueUrlEnum.values()) {
            try {
                getTables(league);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        update();
    }

    @Override
    public void update(){
         for(Team team:teams){
             team.setPosition(overallTable.get(team.getTeamName()));
             team.setPositionH(homeTable.get(team.getTeamName()));
             team.setPositionA(awayTable.get(team.getTeamName()));
         }
         teamDao.saveAll(teams);
    }

    private void getTables(LeagueUrlEnum leagueUrlEnum) throws SQLException {
        for(TableEnum tableEnum:TableEnum.values()){
            ResultSet rs = executeQuery(TeamAppTaskHelper.getTableQuery(leagueUrlEnum,tableEnum));
            while(rs.next()){
                pushTeam(rs.getString("team_name"),rs.getInt("position"),tableEnum);
            }
        }
        conn.close();
    }

    private void pushTeam(String teamName,Integer position, TableEnum tableEnum) {
        switch(tableEnum){
            case AWAY:
                awayTable.put(teamName,position);
                break;
            case HOME:
                homeTable.put(teamName,position);
                break;
            case OVERALL:
                overallTable.put(teamName,position);
                break;
        }
    }
}
