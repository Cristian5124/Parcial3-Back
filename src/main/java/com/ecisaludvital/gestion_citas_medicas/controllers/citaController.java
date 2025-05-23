package com.ecisaludvital.gestion_citas_medicas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecisaludvital.gestion_citas_medicas.models.Cita;
import com.ecisaludvital.gestion_citas_medicas.services.CitaService;

@RestController
@RequestMapping("/citas")
public class citaController {

  private final CitaService citaService;

  public citaController(CitaService citaService) {
    this.citaService = citaService;
  }

@PostMapping
  public Cita crearcita(@RequestBody citaDTO citaDTO) {
    Cita cita = new Cita();
    cita.setIdecisaludvital(citaDTO.getIdcita());
    cita.setUsuario(citaDTO.getUsuario());
    cita.setFecha(citaDTO.getFecha());
    cita.setHoraInicio(citaDTO.getHoraInicio());
    cita.setHoraFin(citaDTO.getHoraFin());
    cita.setProposito(citaDTO.getProposito());
    cita.setEstado(citaDTO.getEstado());

    return citaService.crearCita(cita);
  }

  @DeleteMapping("/{id}")
  public void cancelarcita(@PathVariable String id) {
    citaService.cancelarCita(id);
  }

  @GetMapping
  public List<Cita> listarcitas() {
    return citaService.listarCitas();
  }
}
