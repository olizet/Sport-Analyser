package com.sportsDataAnlyze.dataReplicator.service.task.utils;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;

public class RepUtils {
    public static LeagueUrlEnum convertStringToLeague(String league){
        LeagueUrlEnum resultLeague = null;
        for(LeagueUrlEnum leagueUrlEnum:LeagueUrlEnum.values()){
            if(league.equals(leagueUrlEnum.name())){
                resultLeague = leagueUrlEnum;
            }
        }
        return resultLeague;
    }
}
