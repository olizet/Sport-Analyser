package com.sportsDataAnlyze.dataReplicator.dao;

import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefereeDao extends JpaRepository<Referee,String> {

    @Query(value = "select f.referee_name as ref_name,round(avg(f.home_yellows+f.away_yellows),1) as avg_cards from football.fixtures f where f.referee_name is not null group by f.referee_name", nativeQuery = true)
    List<Referee> getReferees();


}
