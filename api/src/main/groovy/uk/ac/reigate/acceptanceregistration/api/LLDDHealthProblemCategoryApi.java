
package uk.ac.reigate.acceptanceregistration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.reigate.acceptanceregistration.service.LLDDHealthProblemCategoryService;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblemCategory;

@RestController
public class LLDDHealthProblemCategoryApi {
  
  @Autowired 
  private LLDDHealthProblemCategoryService llddHealthProblemCategoryService;
  
  @GetMapping(value = "/lldd-health-problem-categories", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<LLDDHealthProblemCategory>> getLLDDHealthProblemCategory() {
    List<LLDDHealthProblemCategory> list = llddHealthProblemCategoryService.getLLDDHealthProblemCategories();
    return new ResponseEntity<List<LLDDHealthProblemCategory>>(list, HttpStatus.OK);
  }
  
}
