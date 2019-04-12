package com.sportsDataAnlyze.footballService.dao;


import com.sportsDataAnlyze.footballService.entity.Fixture;
import com.sportsDataAnlyze.footballService.entity.Referee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeDao extends PagingAndSortingRepository<Referee,String> {
}
