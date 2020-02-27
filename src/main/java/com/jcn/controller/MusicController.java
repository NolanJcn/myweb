package com.jcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicController {

    @RequestMapping("/tomusic")
    public String toMusic(){
        return "music";
    }
}
