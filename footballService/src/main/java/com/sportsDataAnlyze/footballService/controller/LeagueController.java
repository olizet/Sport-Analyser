package com.sportsDataAnlyze.footballService.controller;

import com.sportsDataAnlyze.footballService.enums.LeagueUrlEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/league")
public class LeagueController {

    @RequestMapping("")
    @ResponseBody
    public LeagueUrlEnum[] getAllTeams() {
        return LeagueUrlEnum.values();
    }
}
