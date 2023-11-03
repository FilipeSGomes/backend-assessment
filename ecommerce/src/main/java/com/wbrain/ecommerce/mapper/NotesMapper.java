package com.wbrain.ecommerce.mapper;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.request.NotesRequest;
import com.wbrain.ecommerce.response.ReportNotesResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class NotesMapper  {

    public Notes map(NotesRequest request) {
        return Notes.builder()
                .amount(request.getValor())
                .data(request.getData() != null ? request.getData() : LocalDate.now())
                .build();
    }

    public ReportNotesResponse map(List<Notes> notesList) {
        BigDecimal amount = notesList.stream()
                .map(Notes::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ReportNotesResponse.builder()
                .amount(amount)
                .client(notesList.get(0).getClient())
                .build();
    }

}