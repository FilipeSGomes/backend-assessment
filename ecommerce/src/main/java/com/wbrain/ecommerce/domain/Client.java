package com.wbrain.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(value = "seu_codigo")
    private Integer id;

    @JsonProperty(value = "nome_da_pessoa")
    private String nome;

    @JsonProperty(value = "cpf_documento")
    private String cpf;

    @JsonProperty(value = "telefone_contato_pessoa")
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Notes> notes;
}
