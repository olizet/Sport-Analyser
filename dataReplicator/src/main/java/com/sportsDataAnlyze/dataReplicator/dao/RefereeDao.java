package com.sportsDataAnlyze.dataReplicator.dao;

import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeDao extends PagingAndSortingRepository<Referee,Long> {

      @Query(value="SELECT r FROM Referee r WHERE r.refName = ?1")
      Referee findRefByName(String refName);
}
