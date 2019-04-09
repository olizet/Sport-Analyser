package com.sportsDataAnlyze.dataReplicator.dao;

import com.sportsDataAnlyze.dataReplicator.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends PagingAndSortingRepository<Team,String> {
    Team findTeamByTeamName(String teamName);
}
