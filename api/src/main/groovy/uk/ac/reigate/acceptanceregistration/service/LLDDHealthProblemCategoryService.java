package uk.ac.reigate.acceptanceregistration.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.reigate.acceptanceregistration.repository.LLDDHealthProblemCategoryRepository;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblemCategory;

@Service
public class LLDDHealthProblemCategoryService {
  
  @Autowired
  private LLDDHealthProblemCategoryRepository llddHealthProblemCategoryRepository;  
  
  public List<LLDDHealthProblemCategory> getLLDDHealthProblemCategories() {
    return llddHealthProblemCategoryRepository.findAll();
  }
  
}
