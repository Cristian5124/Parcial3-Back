package com.ecisaludvital.gestion_citas_medicas;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecisaludvital.gestion_citas_medicas.models.Cita;
import com.ecisaludvital.gestion_citas_medicas.models.ecisaludvital;
import com.ecisaludvital.gestion_citas_medicas.repositories.CitaRepository;
import com.ecisaludvital.gestion_citas_medicas.repositories.ecisaludvitalRepository;
import com.ecisaludvital.gestion_citas_medicas.services.CitaService;

@ExtendWith(MockitoExtension.class)
class CitaServiceTest {

  @Mock
  private CitaRepository CitaRepository;

  @Mock
  private ecisaludvitalRepository ecisaludvitalRepository;

  @InjectMocks
  private CitaService CitaService;

  private Cita Cita;
  private ecisaludvital ecisaludvital;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    Cita =
      new Cita(
        "lab1",
        "usuario1",
        new Date(),
        "08:00",
        "10:00",
        "Estudio",
        "Confirmada"
      );
    Cita.setId("1");

    ecisaludvital = new ecisaludvital("Lab 1", 30, "Edificio A", true);
    ecisaludvital.setId("lab1");
  }

  @Test
  void testConsultarCitaExistente() {
    when(CitaRepository.findAll())
      .thenReturn(Collections.singletonList(Cita));

    List<Cita> Citas = CitaService.listarCitas();

    assertFalse(Citas.isEmpty());
    assertEquals("1", Citas.get(0).getId());
  }

  @Test
  void testConsultarCitaNoExistente() {
    when(CitaRepository.findAll()).thenReturn(Collections.emptyList());

    List<Cita> Citas = CitaService.listarCitas();

    assertTrue(Citas.isEmpty());
  }

  @Test
  void testCrearCita() {
    when(ecisaludvitalRepository.findById("lab1"))
      .thenReturn(Optional.of(ecisaludvital));
    when(
      CitaRepository.findByIdecisaludvitalAndFecha(
        anyString(),
        any(Date.class)
      )
    )
      .thenReturn(Collections.emptyList());
    when(CitaRepository.save(any(Cita.class))).thenReturn(Cita);

    Cita nuevaCita = CitaService.crearCita(Cita);

    assertNotNull(nuevaCita);
    assertEquals("1", nuevaCita.getId());
    assertEquals("Confirmada", nuevaCita.getEstado());
  }

  @Test
  void testCancelarCita() {
    when(CitaRepository.findById("1")).thenReturn(Optional.of(Cita));

    CitaService.cancelarCita("1");

    assertEquals("Cancelada", Cita.getEstado());
    verify(CitaRepository, times(1)).save(Cita);
  }

  @Test
  void testEliminarCita() {
    when(CitaRepository.existsById("1")).thenReturn(true);
    doNothing().when(CitaRepository).deleteById("1");

    CitaService.eliminarCita("1");

    verify(CitaRepository, times(1)).deleteById("1");
  }

  @Test
  void testEliminarYConsultarCita() {
    when(CitaRepository.existsById("1")).thenReturn(true);
    doNothing().when(CitaRepository).deleteById("1");
    when(CitaRepository.findAll()).thenReturn(Collections.emptyList());

    CitaService.eliminarCita("1");
    List<Cita> Citas = CitaService.listarCitas();

    assertTrue(Citas.isEmpty());
  }
}
