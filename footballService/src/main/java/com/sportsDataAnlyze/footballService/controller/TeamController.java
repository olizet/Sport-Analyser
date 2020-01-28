package com.sportsDataAnlyze.footballService.controller;

import com.sportsDataAnlyze.footballService.entity.Team;
import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;
import com.sportsDataAnlyze.footballService.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping("")
    @ResponseBody
    public Iterable<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @RequestMapping("/by-league/{league}")
    @ResponseBody
    public Iterable<Team> getAllTeamsByLeague(@PathVariable LeagueUrlEnum league) {
        return teamService.getAllTeamsByLeague(league);
    }

}
