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

import uk.ac.reigate.acceptanceregistration.repository.LLDDHealthProblemRepository;
import uk.ac.reigate.domain.acceptanceregistration.Ethnicity;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblem;

@SpringJUnitConfig
class LLDDHealthProblemServiceTest {

  @Mock
  private LLDDHealthProblemRepository repository;
  
  @InjectMocks
  private LLDDHealthProblemService service;
  
  @Test
  void testGetLLDDHealthProblems() {
    List<LLDDHealthProblem> list = new ArrayList<LLDDHealthProblem>();
    LLDDHealthProblem lldd1 = new LLDDHealthProblem(1, "Y", "Yes");
    LLDDHealthProblem lldd2 = new LLDDHealthProblem(2, "N", "No");
    LLDDHealthProblem lldd3 = new LLDDHealthProblem(3, "P", "Prefer not to say");
    
    list.add(lldd1);
    list.add(lldd2);
    list.add(lldd3);
    
    when(repository.findAll()).thenReturn(list);
    
    List<LLDDHealthProblem> llddList = service.getLLDDHealthProblems();
    
    assertEquals(3, llddList.size());
    verify(repository, times(1)).findAll();
  }
  
}
