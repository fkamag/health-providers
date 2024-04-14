package br.com.kamatech.healthproviders.services;

import br.com.kamatech.healthproviders.entities.Medic;
import br.com.kamatech.healthproviders.exceptions.MedicNotFoundException;
import br.com.kamatech.healthproviders.repositories.MedicFakeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicService {

  @Autowired
  private MedicFakeRepository repository;

  public List<Medic> getMedics() {
    return repository.getAllMedics();
  }

  public Medic getMedicById(Long id) {
    Medic medic = repository.getMedic(id);

    if (medic == null) {
      throw new MedicNotFoundException();
    }
    return medic;
  }

  public Medic saveMedic(Medic medic) {
    return repository.saveMedic(medic);
  }
}
