package uk.ac.reigate.acceptanceregistration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import uk.ac.reigate.acceptanceregistration.repository.StudentRepository;
import uk.ac.reigate.domain.acceptanceregistration.Student;

@SpringJUnitConfig
class StudentServiceTest {

  @Mock
  private StudentRepository repository;
  
  @InjectMocks
  private StudentService service;
  
  private Student createStudent(Integer id, String linkId) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd", Locale.UK);
    Date interviewDate = formatter.parse("2021-11-01");
    return new Student(id, linkId, "John", "Smith", "Oakwood", interviewDate);
  }
  
  @Test
  void testGetByLinkId() throws ParseException {
    Integer id = 1;
    String linkId = "1234";
    
    Student student = createStudent(id, linkId);
    
    when(repository.getByLinkId(linkId)).thenReturn(student);
    
    Student testStudent = service.getStudentByLinkId(linkId);
    
    assertEquals(testStudent, student);
    verify(repository, times(1)).getByLinkId(linkId);
  }
  
}
