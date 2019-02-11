package com.sportsDataAnlyze.dataReplicator.controller;

import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sportsDataAnlyze.dataReplicator.service.ReplicationTaskService;

@Controller
public class ReplicationController {
    @Autowired
    ReplicationTaskService replicationTaskService;

    @RequestMapping("/force_replication")
    @ResponseBody
    public String forceReplication(){
        for(LeagueUrlEnum league : LeagueUrlEnum.values()){
            replicationTaskService.createDataCSV(league);
        }
        return "data downloaded succesfully";
    }
}
