package com.ecisaludvital.gestion_citas_medicas;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.ecisaludvital.gestion_citas_medicas.controllers.citaDTO;

class citaDTOTest {

  @Test
  void testcitaDTOBuilder() {
    Date fecha = new Date();
    citaDTO reserva = new citaDTO.Builder()
      .id("1")
      .idcita("lab1")
      .usuario("usuario1")
      .fecha(fecha)
      .horaInicio("08:00")
      .horaFin("10:00")
      .proposito("Estudio")
      .estado("Confirmada")
      .build();

    assertNotNull(reserva);
    assertEquals("1", reserva.getId());
    assertEquals("lab1", reserva.getIdcita());
    assertEquals("usuario1", reserva.getUsuario());
    assertEquals(fecha, reserva.getFecha());
    assertEquals("08:00", reserva.getHoraInicio());
    assertEquals("10:00", reserva.getHoraFin());
    assertEquals("Estudio", reserva.getProposito());
    assertEquals("Confirmada", reserva.getEstado());
  }
}
