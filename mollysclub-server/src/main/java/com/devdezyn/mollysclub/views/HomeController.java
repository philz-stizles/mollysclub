package com.devdezyn.mollysclub.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.Api;

@Api(tags="Dashboards")
@Controller
public class HomeController {
  @PostMapping()

  public String index(Model model) {
    return "index.html";
  }
}
