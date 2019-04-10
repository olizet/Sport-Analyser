package com.sportsDataAnlyze.dataReplicator.dao;

import com.sportsDataAnlyze.dataReplicator.entity.Team;
import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TeamDao extends PagingAndSortingRepository<Team,String> {
    Team findTeamByTeamName(String teamName);

    ArrayList<Team> findAllByLeague(LeagueUrlEnum league);

}
