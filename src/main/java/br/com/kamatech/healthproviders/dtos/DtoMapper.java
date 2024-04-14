package br.com.kamatech.healthproviders.dtos;

import br.com.kamatech.healthproviders.entities.Medic;

public class DtoMapper {

  public static MedicDto entityToDto(Medic medic) {
    return new MedicDto(
        medic.getId(),
        medic.getName(),
        medic.getSpeciality()
    );
  }

}
