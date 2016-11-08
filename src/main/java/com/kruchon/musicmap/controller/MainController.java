package com.kruchon.musicmap.controller;

import com.kruchon.musicmap.domain.UserData;
import org.apache.log4j.Logger;
import com.kruchon.musicmap.domain.User;
import com.kruchon.musicmap.service.MusicMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name="musicMapService")
    private MusicMapService musicMapService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String sendStartPage(Model model) {
        logger.debug("Received request to show start page");
        model.addAttribute("userDataAttribute", new UserData());
        return "start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String getData(@ModelAttribute("userDataAttribute") UserData userData) {
        logger.debug("Received request to add new user" + userData);
        return "start";
    }

}