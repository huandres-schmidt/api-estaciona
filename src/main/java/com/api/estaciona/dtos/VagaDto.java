package com.api.estaciona.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class VagaDto {
    private String numero;
    private String bloco;

    @NotNull(message = "Usuário não pode ser vazio")
    private UUID usuarioId;
}
