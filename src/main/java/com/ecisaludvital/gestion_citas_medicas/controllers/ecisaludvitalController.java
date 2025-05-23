package com.ecisaludvital.gestion_citas_medicas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecisaludvital.gestion_citas_medicas.models.ecisaludvital;
import com.ecisaludvital.gestion_citas_medicas.services.ecisaludvitalService;

@RestController
@RequestMapping("/ecisaludvital")
public class ecisaludvitalController {

  private final ecisaludvitalService ecisaludvitalService;

  public ecisaludvitalController(ecisaludvitalService ecisaludvitalService) {
    this.ecisaludvitalService = ecisaludvitalService;
  }

  @GetMapping
  public List<ecisaludvital> obtenerecisaludvitals() {
    return ecisaludvitalService.listarecisaludvitals();
  }
}
