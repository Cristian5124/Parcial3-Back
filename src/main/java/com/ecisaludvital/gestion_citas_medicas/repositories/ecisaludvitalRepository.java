package com.ecisaludvital.gestion_citas_medicas.repositories;

import com.ecisaludvital.gestion_citas_medicas.models.ecisaludvital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ecisaludvitalRepository extends MongoRepository<ecisaludvital, String> {
}
