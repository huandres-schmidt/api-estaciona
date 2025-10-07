package com.api.estaciona.dtos;

import com.api.estaciona.models.VagaModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {
    private String nome;
    @NotBlank(message = "Campo CPF é obrigatório")
    private String cpf;
    private String telefone;
    private List<VagaModel> vagas = new ArrayList<>();
}
