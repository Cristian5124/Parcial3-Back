package com.ecisaludvital.gestion_citas_medicas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecisaludvital.gestion_citas_medicas.models.Cita;
import com.ecisaludvital.gestion_citas_medicas.models.ecisaludvital;
import com.ecisaludvital.gestion_citas_medicas.repositories.CitaRepository;
import com.ecisaludvital.gestion_citas_medicas.repositories.ecisaludvitalRepository;

@Service
public class CitaService {

  @SuppressWarnings("FieldMayBeFinal")
  private CitaRepository CitaRepository;

  public CitaService(CitaRepository CitaRepository) {
    this.CitaRepository = CitaRepository;
  }

  private ecisaludvitalRepository ecisaludvitalRepository;

  @Autowired
  public void setecisaludvitalRepository(
    ecisaludvitalRepository ecisaludvitalRepository
  ) {
    this.ecisaludvitalRepository = ecisaludvitalRepository;
  }

  public Cita crearCita(Cita Cita) {
    ecisaludvital ecisaludvital = ecisaludvitalRepository
      .findById(Cita.getIdecisaludvital())
      .orElseThrow(() ->
        new IllegalArgumentException("ecisaludvital no encontrado")
      );

    if (!ecisaludvital.isEstado()) {
      throw new IllegalArgumentException(
        "ecisaludvital no está disponible para Citas"
      );
    }

    if (existeConflictoHorario(Cita)) {
      throw new IllegalArgumentException(
        "Conflicto de horario: ya existe una Cita en esa franja horaria"
      );
    }

    Cita.setEstado("Confirmada");
    return CitaRepository.save(Cita);
  }

  private boolean existeConflictoHorario(Cita nuevaCita) {
    List<Cita> CitasExistentes = CitaRepository.findByIdecisaludvitalAndFecha(
      nuevaCita.getIdecisaludvital(),
      nuevaCita.getFecha()
    );

    for (Cita existente : CitasExistentes) {
      if (
        !"Cancelada".equalsIgnoreCase(existente.getEstado()) &&
        hayCruceHorario(nuevaCita, existente)
      ) {
        return true; // Hay conflicto
      }
    }
    return false;
  }

  private boolean hayCruceHorario(Cita r1, Cita r2) {
    return (
      (r1.getHoraInicio().compareTo(r2.getHoraFin()) < 0) &&
      (r1.getHoraFin().compareTo(r2.getHoraInicio()) > 0)
    );
  }

  public void cancelarCita(String id) {
    Cita Cita = CitaRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Cita no encontrada"));
    Cita.setEstado("Cancelada");
    CitaRepository.save(Cita);
  }

  public void eliminarCita(String id) {
    if (!CitaRepository.existsById(id)) {
      throw new IllegalArgumentException("Cita no encontrada");
    }
    CitaRepository.deleteById(id);
  }

  public List<Cita> listarCitas() {
    return CitaRepository.findAll();
  }
}
