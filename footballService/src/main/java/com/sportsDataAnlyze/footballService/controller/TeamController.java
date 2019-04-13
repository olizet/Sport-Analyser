package com.sportsDataAnlyze.footballService.controller;

import com.sportsDataAnlyze.footballService.dao.TeamDao;
import com.sportsDataAnlyze.footballService.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamDao teamDao;

    @RequestMapping("/{teamName}")
    @ResponseBody
    public Optional<Team> getTeam(@PathVariable("teamName") String teamName) {
        return teamDao.findById(teamName);
    }
}
