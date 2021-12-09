package uk.ac.reigate.acceptanceregistration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblem;

@Repository
public interface LLDDHealthProblemRepository extends org.springframework.data.repository.Repository<LLDDHealthProblem, Integer> {
  
	public List<LLDDHealthProblem> findAll();

	public LLDDHealthProblem findById(Integer id);
	
}
