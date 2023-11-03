package com.wbrain.ecommerce.services;

import com.wbrain.ecommerce.response.ReportMonthResponse;
import com.wbrain.ecommerce.response.ReportNotesResponse;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    ReportNotesResponse reportNotesByClient(Integer codeClient);
    List<ReportNotesResponse> reportAllClients();
    ReportMonthResponse reportNotesByMonth(LocalDate month);

}
