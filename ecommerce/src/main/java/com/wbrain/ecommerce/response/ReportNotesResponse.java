package com.wbrain.ecommerce.response;

import com.wbrain.ecommerce.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportNotesResponse {

    private BigDecimal amount;
    private Client client;

}
