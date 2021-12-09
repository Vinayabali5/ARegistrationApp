package uk.ac.reigate.acceptanceregistration.repository;

import org.springframework.stereotype.Repository;

import uk.ac.reigate.domain.acceptanceregistration.Student;

@Repository
public interface StudentRepository extends org.springframework.data.repository.Repository<Student, Integer> {
  
  public Student findById(Integer id);
  
  public Student getByLinkId(String linkId);
  
  public Student save(Student student);
  
}
