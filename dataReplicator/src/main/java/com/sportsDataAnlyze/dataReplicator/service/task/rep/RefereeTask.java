package com.sportsDataAnlyze.dataReplicator.service.task.rep;

import com.sportsDataAnlyze.dataReplicator.dao.RefereeDao;
import com.sportsDataAnlyze.dataReplicator.entity.Referee;
import com.sportsDataAnlyze.dataReplicator.service.task.rep.AbstractTask;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class RefereeTask extends AbstractTask<Referee,String,RefereeDao> {

    private ArrayList<Referee> refereesInput = new ArrayList<>();
    private Set<String > refs = new HashSet<>();

    public RefereeTask() {
        super(new String[]{"Referee","HY","AY"});
    }

    @Override
    protected void mapObject(Map<String, Integer> headersPosition, String[] nextRecord) {
        Referee ref = new Referee();
        for (Map.Entry<String, Integer> entry : headersPosition.entrySet()) {
            switch(entry.getKey()){
                case "Referee":
                    ref.setRefName(nextRecord[entry.getValue()]);
                    refs.add(ref.getRefName());
                    ref.setMatches(ref.getMatches()+1);
                    break;
                case "AY":
                    ref.setCards(ref.getCards()+Integer.valueOf(nextRecord[entry.getValue()]));
                    break;
                case "HY":
                    ref.setCards(ref.getCards()+Integer.valueOf(nextRecord[entry.getValue()]));
                    break;
            }
        }
        refereesInput.add(ref);
    }

    private void convertInput(){
        for(String name:refs){
            Referee ref = new Referee();
            for(Referee r:refereesInput){
                if(name.equals(r.getRefName())){
                    ref.setCards(ref.getCards() + r.getCards());
                    ref.setMatches(ref.getMatches()+1);
                }
            }
            ref.setRefName(name.replace(" ","."));
            ref.setAvgCards(Double.valueOf(ref.getCards())/Double.valueOf(ref.getMatches()));
            dao.save(ref);
        }
    }

    @Override
    public void generateResult() {
        try {
            readRepData();
            convertInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
