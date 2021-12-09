package uk.ac.reigate.acceptanceregistration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import uk.ac.reigate.acceptanceregistration.repository.EthnicityRepository;
import uk.ac.reigate.domain.acceptanceregistration.Ethnicity;

@SpringJUnitConfig
class EthnicityServiceTest {

  @Mock
  private EthnicityRepository repository;
  
  @InjectMocks
  private EthnicityService service;
  
  @Test
  void testGetEthnicities() {
    List<Ethnicity> list = new ArrayList<Ethnicity>();
    Ethnicity eth1 = new Ethnicity(1, "WB", "White British");
    Ethnicity eth2 = new Ethnicity(2, "IN", "Indian");
    Ethnicity eth3 = new Ethnicity(3, "AF", "African");
    
    list.add(eth1);
    list.add(eth2);
    list.add(eth3);
    
    when(repository.findAll()).thenReturn(list);
    
    List<Ethnicity> ethList = service.getEthnicities();
    
    assertEquals(3, ethList.size());
    verify(repository, times(1)).findAll();
  }
  
}
