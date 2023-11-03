package com.wbrain.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notes implements Serializable {

    @Id
    @JsonProperty(value = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;


}
