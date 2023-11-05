package com.wbrain.ecommerce.mapper;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.request.NotesRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NotesMapper  {

    public Notes map(NotesRequest request) {
        return Notes.builder()
                .amount(request.getValor())
                .data(request.getData() != null ? request.getData() : LocalDate.now())
                .build();
    }
}