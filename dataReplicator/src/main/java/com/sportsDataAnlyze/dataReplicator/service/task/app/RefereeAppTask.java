package com.sportsDataAnlyze.dataReplicator.service.task.app;

import com.sportsDataAnlyze.dataReplicator.dao.RefereeDao;
import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class RefereeAppTask extends AbstractAppTask {
    private final String query="select f.ref_name,round(avg(f.home_yellows+away_yellows),1) as avg_cards " +
                                "from football.fixture f " +
                                "where f.ref_name is not null " +
                                "group by ref_name";

    private ArrayList<Referee> refs = new ArrayList<>();
    private HashMap<String,Double> refsMap = new HashMap<>();

    @Autowired
    RefereeDao refDao;

    @Override
    protected void update() {
        try {
            ResultSet rs = executeQuery(query);
            while(rs.next()){
                refsMap.put(rs.getString("ref_name"),rs.getDouble("avg_cards"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void generateResult() {
        refs = (ArrayList<Referee>) refDao.findAll();
        update();
        for(Referee ref:refs){
            ref.setAvgCards(refsMap.get(ref.getRefName()));
        }
        refDao.saveAll(refs);
    }
}
