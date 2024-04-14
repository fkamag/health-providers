package br.com.kamatech.healthproviders.controllers;

import static br.com.kamatech.healthproviders.dtos.DtoMapper.entityToDto;

import br.com.kamatech.healthproviders.dtos.MedicDto;
import br.com.kamatech.healthproviders.entities.Medic;
import br.com.kamatech.healthproviders.services.MedicService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medics")
public class MedicController {

  @Autowired
  private MedicService service;

  @GetMapping
  public ResponseEntity<List<MedicDto>> getMedics() {
    List<MedicDto> medicDtos = new ArrayList<>();
    List<Medic> medics = service.getMedics();

    for (Medic medic : medics) {
      medicDtos.add(entityToDto(medic));
    }

    return ResponseEntity.status(HttpStatus.OK).body(medicDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicDto> getMedic(@PathVariable Long id) {
    Medic medic = service.getMedicById(id);

    if (medic == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(entityToDto(medic));
  }

  @PostMapping
  public ResponseEntity<Medic> createMedic(@RequestBody Medic medic) {
    Medic savedMedic = service.saveMedic(medic);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(savedMedic);
  }

}