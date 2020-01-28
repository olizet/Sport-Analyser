package com.sportsDataAnlyze.footballService.controller;

import com.sportsDataAnlyze.footballService.dto.RapportDto;
import com.sportsDataAnlyze.footballService.service.FixtureService;
import com.sportsDataAnlyze.footballService.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/fixture-rapport")
public class FixtureRapportController {

    @Autowired
    TeamService teamService;

    @Autowired
    FixtureService fixtureService;

    @RequestMapping("")
    @ResponseBody
    public RapportDto getFixtureRapport(@RequestParam("home") String home, @RequestParam("away") String away) {
        return fixtureService.generateFixtureRapport(home,away);
    }

}
