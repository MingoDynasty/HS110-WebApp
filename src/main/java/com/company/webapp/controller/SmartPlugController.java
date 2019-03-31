package com.company.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.webapp.model.SmartPlug;

@RestController
public class SmartPlugController {
  private static final Logger logger = LoggerFactory.getLogger(SmartPlugController.class);

  @Autowired SmartPlugService smartPlugService;

  @GetMapping(value = "/smartplugs")
  public List<SmartPlug> getSmartPlugs() {
    logger.info("Getting all smart plugs.");
    return smartPlugService.findAll();
  }

  @GetMapping(value = "/smartplugs/{id}")
  public Optional<SmartPlug> getSmartPlug(@PathVariable("id") long id) {
    logger.info("Getting smart plug with ID: {}", id);
    return smartPlugService.findOne(id);
  }

  @PostMapping(value = "/smartplugs")
  public SmartPlug createSmartPlug(@RequestBody SmartPlug sp) {
    logger.info("Inserting new smart plug: {}", sp);
    return smartPlugService.insertSmartPlug(sp);
  }

  // update
  @PutMapping(value = "/putsmartplugs/{id}")
  public void updateSmartPlug(@PathVariable("id") long id, @RequestBody SmartPlug sp) {
    logger.info("Updating smart plug with ID: {}", id);
    smartPlugService.updateSmartPlug(sp);
  }

  @DeleteMapping(value = "/deletesmartplugs/{id}")
  public void deleteSmartPlug(@PathVariable("id") long id, @RequestBody SmartPlug sp) {
    logger.info("Deleting smart plug with ID: {}", id);
    smartPlugService.deleteSmartPlug(sp);
  }
}
