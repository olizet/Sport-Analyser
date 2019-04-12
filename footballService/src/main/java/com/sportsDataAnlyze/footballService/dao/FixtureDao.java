package com.sportsDataAnlyze.footballService.dao;


import com.sportsDataAnlyze.footballService.entity.Fixture;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureDao extends PagingAndSortingRepository<Fixture,Long>{

}
