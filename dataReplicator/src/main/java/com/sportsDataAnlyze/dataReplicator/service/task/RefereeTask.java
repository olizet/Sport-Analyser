package com.sportsDataAnlyze.dataReplicator.service.task;

import com.sportsDataAnlyze.dataReplicator.dao.RefereeDao;
import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Component
public class RefereeTask implements ITask {

    private HashMap<String,Double>  referees;

    @Autowired
    RefereeDao refereeDao;

    @Override
    @Transactional
    public void prepareTableForReplication()  {
        refereeDao.deleteAll();
    }

    @Transactional
    public void repDataToDatabase() {
        List<Referee> referees = refereeDao.getReferees();
        Referee ref = new Referee();
        ref.setRefName("M_Dean");
        ref.setAvgCards(3.5);
        refereeDao.save(ref);
        //        for(Referee r : referees){
//            Referee ref = new Referee();
//            ref.setRefName(r.getRefName().replace("_","."));
//            ref.setAvgCards(r.getAvgCards());
//            refereeDao.save(ref);
//        }
//        refereeDao.saveAll(referees);
    }
}
