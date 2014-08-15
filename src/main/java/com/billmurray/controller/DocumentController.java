package com.billmurray.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentation")
public class DocumentController {
	
	
	@RequestMapping("/layout")
    public String getMoviePartialPage() {
        return "documentation/layout";
    }

}
