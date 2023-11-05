package com.wbrain.ecommerce.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class NotesRequest {

    private LocalDate data;

    private BigDecimal valor;

    @JsonProperty("cliente")
    private Integer idClient;
}
