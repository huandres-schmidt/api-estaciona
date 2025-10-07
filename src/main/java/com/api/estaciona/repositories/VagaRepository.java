package com.api.estaciona.repositories;

import com.api.estaciona.models.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VagaRepository extends JpaRepository<VagaModel, UUID> {}
