package com.api.estaciona.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_usuario")

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToMany(mappedBy = "vagaModel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VagaModel> vagas = new ArrayList<>();
}
