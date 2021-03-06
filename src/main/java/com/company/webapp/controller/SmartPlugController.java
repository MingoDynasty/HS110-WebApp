package com.company.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.webapp.exception.SmartPlugNotFoundException;
import com.company.webapp.model.SmartPlug;
import com.company.webapp.service.SmartPlugService;

@RestController
@RequestMapping("/api/v1")
public class SmartPlugController {
  private static final Logger logger = LoggerFactory.getLogger(SmartPlugController.class);

  @Autowired private SmartPlugService smartPlugService;

  @GetMapping(value = "/smartplugs")
  public List<SmartPlug> getSmartPlugs() {
    logger.info("Getting all smart plugs...");
    List<SmartPlug> list = smartPlugService.findAll();
    logger.info("Found {} smart plugs.", list.size());
    return list;
  }

  @GetMapping(value = "/smartplugs/{id}")
  public SmartPlug getSmartPlug(@PathVariable("id") long id) {
    logger.info("Getting smart plug with ID: {}", id);
    return smartPlugService.findOne(id).orElseThrow(() -> new SmartPlugNotFoundException(id));
  }

  @PostMapping(value = "/smartplugs")
  public SmartPlug createSmartPlug(@RequestBody SmartPlug sp) {
    logger.info("Inserting new smart plug: {}", sp);
    return smartPlugService.insertSmartPlug(sp);
  }

  @PutMapping(value = "/smartplugs/{id}")
  public SmartPlug updateSmartPlug(@PathVariable("id") long id, @RequestBody SmartPlug sp) {
    logger.info("Updating smart plug with ID: {}", id);
    return smartPlugService.updateSmartPlug(id, sp);
  }

  @DeleteMapping(value = "/smartplugs/{id}")
  public void deleteSmartPlug(@PathVariable("id") long id) {
    logger.info("Deleting smart plug with ID: {}", id);
    smartPlugService.deleteSmartPlug(id);
  }
}
