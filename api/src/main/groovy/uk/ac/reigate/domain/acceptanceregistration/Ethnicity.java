package uk.ac.reigate.domain.acceptanceregistration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ethnicity", schema = "acceptanceandregistration")
public class Ethnicity {
  
  @Id
  @Column(name = "ethnicity_id")
  @JsonProperty(value = "id")
  public Integer id;
  
  @Column(name = "code")
  @JsonProperty(value = "code")
  public String code;
  
  @Column(name = "description")
  @JsonProperty(value = "description")
  public String description;
  
  public Ethnicity() {}
  
  public Ethnicity(Integer id, String code, String description) {
    this.id = id;
    this.code = code;
    this.description = description;
  }

}
