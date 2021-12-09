package uk.ac.reigate.acceptanceregistration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblemCategory;

@Repository
public interface LLDDHealthProblemCategoryRepository extends org.springframework.data.repository.Repository<LLDDHealthProblemCategory, Integer> {
  
	public List<LLDDHealthProblemCategory> findAll();

	public LLDDHealthProblemCategory findById(Integer id);
	
}
