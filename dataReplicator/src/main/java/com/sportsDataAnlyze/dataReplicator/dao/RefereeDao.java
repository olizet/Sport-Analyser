package com.sportsDataAnlyze.dataReplicator.dao;

import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeDao extends PagingAndSortingRepository<Referee,String> {

      Referee findByRefName(String refname);
}
