package uk.ac.reigate.acceptanceregistration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import uk.ac.reigate.domain.acceptanceregistration.Ethnicity;

@Repository
public interface EthnicityRepository extends org.springframework.data.repository.Repository<Ethnicity, Integer> {

	public List<Ethnicity> findAll();

	public Ethnicity findById(Integer id);
}
