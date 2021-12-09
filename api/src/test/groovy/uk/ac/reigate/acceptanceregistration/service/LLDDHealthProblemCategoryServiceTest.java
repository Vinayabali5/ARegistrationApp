package uk.ac.reigate.acceptanceregistration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import uk.ac.reigate.acceptanceregistration.repository.LLDDHealthProblemCategoryRepository;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblem;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblemCategory;

@SpringJUnitConfig
class LLDDHealthProblemCategoryServiceTest {

  @Mock
  private LLDDHealthProblemCategoryRepository repository;
  
  @InjectMocks
  private LLDDHealthProblemCategoryService service = new LLDDHealthProblemCategoryService();
  
  @Test
  void testGetLLDDHealthCategoryProblems() {
    List<LLDDHealthProblemCategory> list = new ArrayList<LLDDHealthProblemCategory>();
    LLDDHealthProblemCategory lldd1 = new LLDDHealthProblemCategory(1, "AT", "Autism");
    LLDDHealthProblemCategory lldd2 = new LLDDHealthProblemCategory(2, "B", "Blind");
    LLDDHealthProblemCategory lldd3 = new LLDDHealthProblemCategory(3, "-", "Prefer not to say");
    
    list.add(lldd1);
    list.add(lldd2);
    list.add(lldd3);
    
    when(repository.findAll()).thenReturn(list);
    
    List<LLDDHealthProblemCategory> llddList = service.getLLDDHealthProblemCategories();
    
    assertEquals(3, llddList.size());
    verify(repository, times(1)).findAll();
  }
  
}
