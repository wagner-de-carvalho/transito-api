package com.carvalho.transito.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoInput {
    @NotBlank
    public String marca;

    @NotBlank
    @Size(max = 20)
    public String modelo;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]{3}[0-9][0-9A-Za-z][0-9]{2}")
    public String placa;

    @NotNull
    @Valid
    private ProprietarioIdInput proprietario;
}
