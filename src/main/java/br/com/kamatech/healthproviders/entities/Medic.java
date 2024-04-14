package br.com.kamatech.healthproviders.entities;

public class Medic {
  private Long id;
  private String name;
  private String speciality;
  private String cpf;

  public Medic(Long id, String name, String speciality, String cpf) {
    this.id = id;
    this.name = name;
    this.speciality = speciality;
    this.cpf = cpf;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
