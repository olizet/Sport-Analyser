package com.sportsDataAnlyze.dataReplicator.service.task.rep;

import com.sportsDataAnlyze.dataReplicator.dao.RefereeDao;
import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class RefereeRepTask extends AbstractRepTask<Referee,String,RefereeDao> {

    private ArrayList<Referee> refereesInput = new ArrayList<>();
    private Set<Referee > refs = new HashSet<>();

    public RefereeRepTask() {
        super(new String[]{"Referee","HY","AY"});
    }

    @Override
    protected void mapObject(Map<String, Integer> headersPosition, String[] nextRecord) {
        Referee ref = new Referee();
        for (Map.Entry<String, Integer> entry : headersPosition.entrySet()) {
            switch(entry.getKey()){
                case "Referee":
                    ref.setRefName(nextRecord[entry.getValue()].replace(" ","."));
                    refs.add(ref);
                    break;
            }
        }
    }


    @Override
    public void generateResult() {
        try {
            readRepData();
            dao.saveAll(refs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
