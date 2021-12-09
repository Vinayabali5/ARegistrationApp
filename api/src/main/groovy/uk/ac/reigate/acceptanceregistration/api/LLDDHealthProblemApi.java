package uk.ac.reigate.acceptanceregistration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.reigate.acceptanceregistration.service.LLDDHealthProblemService;
import uk.ac.reigate.domain.acceptanceregistration.Ethnicity;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblem;

/**
 * This class is used to set up a collection of LLDDHealthProblem HTTP Endpoints for the API.
 * 
 * @author vinaya.balakrishna
 *
 */
@RestController
public class LLDDHealthProblemApi {
  
  @Autowired 
  private LLDDHealthProblemService llddHealthProblemService;
  
  /**
   * This method is used to retrieve the list of LLDDHealthProblems.
   * 
   * @return A ResponseEntity with the list of LLDDHealthProblems.
   */
  @GetMapping(value = "api/lldd-health-problems", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<LLDDHealthProblem>> getLLDDHealthProblems() {
    List<LLDDHealthProblem> list = llddHealthProblemService.getLLDDHealthProblems();
    return new ResponseEntity<List<LLDDHealthProblem>>(list, HttpStatus.OK);
  }
  
	/**
	 * This method is used to retrieve the LLDDHealthProblem object by id
	 * 
	 * @param id The id for the LLDDHealthProblem object retrieve.
	 * @return A ResponseEntity with the corresponding LLDDHealthProblem object.
	 */
	@GetMapping(value = "api/lldd-health-problem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LLDDHealthProblem> getById(@PathVariable("id") Integer id) {
		LLDDHealthProblem llddHealthProblem = llddHealthProblemService.getById(id);
		return new ResponseEntity<LLDDHealthProblem>(llddHealthProblem, HttpStatus.OK);
	}
  
}
