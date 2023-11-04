package com.wbrain.ecommerce.services.impl;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.mapper.NotesMapper;
import com.wbrain.ecommerce.response.ReportMonthResponse;
import com.wbrain.ecommerce.response.ReportNotesResponse;
import com.wbrain.ecommerce.services.ClientService;
import com.wbrain.ecommerce.services.NoteService;
import com.wbrain.ecommerce.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    NoteService noteService;
    @Autowired
    ClientService clientService;
    @Autowired
    NotesMapper mapper;

    @Override
    public ReportNotesResponse reportNotesByClient(Integer codeClient) {
        List<Notes> notesList = noteService.findAllNotesByClientId(codeClient);
        return mapper.map(notesList);
    }

    @Override
    public List<ReportNotesResponse> reportAllClients() {
        List<ReportNotesResponse> reportNotesResponses = new ArrayList<>();
        clientService.findAllClient().forEach(client -> {
            reportNotesResponses.add(reportNotesByClient(client.getId()));
        });
        return reportNotesResponses;
    }

    @Override
    public ReportMonthResponse reportNotesByMonth(LocalDate start, LocalDate end) {
        List<Notes> notes = noteService.findAllNotesByDataBetween(start,end);
        if(notes.isEmpty()){
            return null;
        }
        return ReportMonthResponse.builder()
                .month(start.getMonth().toString())
                .amount(mapper.map(notes).getAmount())
                .build();
    }

}