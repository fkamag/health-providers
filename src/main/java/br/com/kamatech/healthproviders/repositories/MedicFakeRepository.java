package br.com.kamatech.healthproviders.repositories;

import br.com.kamatech.healthproviders.entities.Medic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MedicFakeRepository {

  private static final Map<Long, Medic> MEDICS = new HashMap<>();

  static {
    MEDICS.put(1L, new Medic(1L, "Dra. Maria",
        "Neurologista", "123.456.789-10"));
    MEDICS.put(2L, new Medic(2L, "Dr. José",
        "Cardiologista", "123.456.789-11"));
  }

  public List<Medic> getAllMedics() {
    return new ArrayList<>(MEDICS.values());
  }

  public Medic getMedic(Long id) {
    return MEDICS.get(id);
  }

  public Medic saveMedic(Medic medic) {
    Long id = medic.getId();

    if(id == null) {
      id = (long) (MEDICS.size() + 1);
    }

    Medic savedMedic = new Medic(id, medic.getName(), medic.getSpeciality(), medic.getCpf());

    MEDICS.put(id, savedMedic);

    return savedMedic;
  }

}
