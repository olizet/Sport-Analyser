package com.sportsDataAnlyze.footballService.dao;


import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixtureDao extends PagingAndSortingRepository<Fixture,Long>{
    List<Fixture> findFixtureByHomeOrAway(Team home, Team away);
}
