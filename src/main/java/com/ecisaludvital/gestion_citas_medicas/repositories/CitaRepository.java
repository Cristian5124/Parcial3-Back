package com.ecisaludvital.gestion_citas_medicas.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecisaludvital.gestion_citas_medicas.models.Cita;

@Repository
public interface CitaRepository extends MongoRepository<Cita, String> {
    List<Cita> findByIdecisaludvitalAndFecha(String idecisaludvital, Date fecha);
}
