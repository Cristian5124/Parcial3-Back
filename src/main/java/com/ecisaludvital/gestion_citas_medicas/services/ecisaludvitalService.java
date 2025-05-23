package com.ecisaludvital.gestion_citas_medicas.services;

import com.ecisaludvital.gestion_citas_medicas.models.ecisaludvital;
import com.ecisaludvital.gestion_citas_medicas.repositories.ecisaludvitalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ecisaludvitalService {

  @SuppressWarnings("FieldMayBeFinal")
  private ecisaludvitalRepository ecisaludvitalRepository;

  public ecisaludvitalService(
    @Autowired ecisaludvitalRepository ecisaludvitalRepository
  ) {
    this.ecisaludvitalRepository = ecisaludvitalRepository;
  }

  public List<ecisaludvital> listarecisaludvitals() {
    return ecisaludvitalRepository.findAll();
  }
}
