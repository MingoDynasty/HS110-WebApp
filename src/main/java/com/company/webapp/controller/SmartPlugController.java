package com.company.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.webapp.model.SmartPlug;

@RestController
public class SmartPlugController {
  private static final Logger _LOGGER = LoggerFactory.getLogger(SmartPlugController.class);

  @Autowired SmartPlugService smartPlugService;

  @GetMapping(value = "/smartplug")
  public List<SmartPlug> getSmartPlugs() {
    return smartPlugService.findAll();
  }

  // create
  @PostMapping(value = "/postsmartplug")
  public void createSmartPlug(@RequestBody SmartPlug sp) {
    smartPlugService.insertSmartPlug(sp);
  }

  // update
  @PutMapping(value = "/putsmartplug")
  public void updateSmartPlug(@RequestBody SmartPlug sp) {
    smartPlugService.updateSmartPlug(sp);
  }

  @DeleteMapping(value = "/deletesmartplug")
  public void deleteSmartPlug(@RequestBody SmartPlug sp) {
    smartPlugService.deleteSmartPlug(sp);
  }
}
