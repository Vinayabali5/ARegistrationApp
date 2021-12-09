package uk.ac.reigate.acceptanceregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.reigate.acceptanceregistration.repository.EthnicityRepository;
import uk.ac.reigate.domain.acceptanceregistration.Ethnicity;

/**
 * This service class is used to process the Ethnicity data.
 * 
 * @author Michael Horgan
 *
 */
@Service
public class EthnicityService {
  
  @Autowired
  EthnicityRepository ethnicityRepository;
  
  /**
   * This method is used to retrieve all instances of the Ethnicity object from the database.
   * 
   * @return A List of Ethinicity objects.
   * 
   */
  public List<Ethnicity> getEthnicities() {
    return ethnicityRepository.findAll();   
  }
  
  /**
   * This method is used to retrieve an individual Ethnicity object from the database.
   * 
   * @param id the id of the Ethnicity object to retrieve
   * @return the Ethnicity object identified by the id.
   */
  public Ethnicity getById(Integer id) {
	  return ethnicityRepository.findById(id);
  }

  
}
