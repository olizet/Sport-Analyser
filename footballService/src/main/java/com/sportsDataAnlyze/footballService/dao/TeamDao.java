package com.sportsDataAnlyze.footballService.dao;


import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDao extends PagingAndSortingRepository<Team,String> {
    public List<Team> findAllByLeague(LeagueUrlEnum leagueUrlEnum);
}
