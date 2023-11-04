package com.wbrain.ecommerce.mapper;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.response.ReportNotesResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ReportsMapper {

   public ReportNotesResponse map(List<Notes> notesList) {
        if(notesList.isEmpty()){
            return null;
        }
        BigDecimal amount = notesList.stream()
                .map(Notes::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ReportNotesResponse.builder()
                .amount(amount)
                .client(notesList.get(0).getClient())
                .build();
    }

}