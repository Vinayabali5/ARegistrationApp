package uk.ac.reigate.acceptanceregistration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.reigate.acceptanceregistration.repository.LLDDHealthProblemRepository;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblem;

/**
 * This service is used to process the LLDDHealthProblem data.
 * 
 * @author vinaya.balakrishna
 *
 */
@Service
public class LLDDHealthProblemService {
  
  @Autowired
  private LLDDHealthProblemRepository llddHealthProblemRepository;  
  
  /**
   * This method is used to retrieve all instances of the LLDDHealthProblem object from the database.
   * 
   * @return A List of LLDDHealthProblem objects.
   * 
   */
  public List<LLDDHealthProblem> getLLDDHealthProblems() {
    return llddHealthProblemRepository.findAll();
  }
  
  /**
   * This method is used to retrieve an individual LLDDHealthProblem object from the database.
   * 
   * @param id the id of the LLDDHealthProblem object to retrieve
   * @return the LLDDHealthProblem object identified by the id.
   */
  public LLDDHealthProblem getById(Integer id) {
	  return llddHealthProblemRepository.findById(id);
  }
  
}
