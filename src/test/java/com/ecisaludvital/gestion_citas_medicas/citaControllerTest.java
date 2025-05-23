package com.ecisaludvital.gestion_citas_medicas;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecisaludvital.gestion_citas_medicas.controllers.ecisaludvitalController;
import com.ecisaludvital.gestion_citas_medicas.models.ecisaludvital;
import com.ecisaludvital.gestion_citas_medicas.services.ecisaludvitalService;

@ExtendWith(MockitoExtension.class)
class ecisaludvitalControllerTest {

  @Mock
  private ecisaludvitalService ecisaludvitalService;

  @InjectMocks
  private ecisaludvitalController ecisaludvitalController;

  private ecisaludvital ecisaludvital;

  @BeforeEach
  @SuppressWarnings("unused")
  void setUp() {
    ecisaludvital = new ecisaludvital("Lab 1", 30, "Edificio A", true);
    ecisaludvital.setId("lab1");
  }

  @Test
  void testObtenerecisaludvitalsConDatos() {
    when(ecisaludvitalService.listarecisaludvitals())
      .thenReturn(Collections.singletonList(ecisaludvital));

    List<ecisaludvital> ecisaludvitals = ecisaludvitalController.obtenerecisaludvitals();

    assertEquals(1, ecisaludvitals.size());
    assertEquals("lab1", ecisaludvitals.get(0).getId());
  }

  @Test
  void testObtenerecisaludvitalsSinDatos() {
    when(ecisaludvitalService.listarecisaludvitals())
      .thenReturn(Collections.emptyList());

    List<ecisaludvital> ecisaludvitals = ecisaludvitalController.obtenerecisaludvitals();

    assertEquals(0, ecisaludvitals.size());
  }
}
