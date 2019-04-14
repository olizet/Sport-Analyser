package com.sportsDataAnlyze.dataReplicator.controller;

import com.sportsDataAnlyze.dataReplicator.service.ReplicationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@Controller
@RequestMapping("/replicator")
public class ReplicationController {

    @Autowired
    ReplicationFacade replicationFacade;

    @RequestMapping("/force_replication")
    @ResponseBody
    public String forceReplication() throws IOException, SQLException, ParseException {

        replicationFacade.replicationService();
        return "data downloaded succesfully";
    }
}
