package com.sportsDataAnlyze.dataReplicator.dao;

import com.sportsDataAnlyze.dataReplicator.entity.Fixture;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureDao extends PagingAndSortingRepository<Fixture,Long>{

}
