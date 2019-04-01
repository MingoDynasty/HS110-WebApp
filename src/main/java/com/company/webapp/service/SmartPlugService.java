package com.company.webapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.webapp.exception.SmartPlugNotFoundException;
import com.company.webapp.model.SmartPlug;
import com.company.webapp.repository.SmartPlugRepository;

@Service
public class SmartPlugService {
  private static final Logger logger = LoggerFactory.getLogger(SmartPlugService.class);

  @Autowired private SmartPlugRepository smartPlugRepository;

  public List<SmartPlug> findAll() {
    return this.smartPlugRepository.findAll();
  }

  public Optional<SmartPlug> findOne(long id) {
    return this.smartPlugRepository.findById(id);
  }

  public SmartPlug insertSmartPlug(SmartPlug sp) {
    return this.smartPlugRepository.save(sp);
  }

  public SmartPlug updateSmartPlug(long id, SmartPlug sp) {
    return this.findOne(id)
        .map(
            smartPlug -> {
              logger.info("Smart plug with ID '{}' found. Updating...", id);
              smartPlug.setName(sp.getName());
              smartPlug.setIpAddress(sp.getIpAddress());
              return this.smartPlugRepository.save(smartPlug);
            })
        .orElseThrow(() -> new SmartPlugNotFoundException(id));
  }

  public void deleteSmartPlug(long id) {
    if (!this.findOne(id).isPresent()) {
      logger.info("No smart plug found with ID '{}'. Nothing to delete...", id);
      return;
    }

    this.smartPlugRepository.deleteById(id);
  }
}
