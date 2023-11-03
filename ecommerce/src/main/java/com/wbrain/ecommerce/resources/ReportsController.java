package com.wbrain.ecommerce.resources;

import com.wbrain.ecommerce.response.ReportMonthResponse;
import com.wbrain.ecommerce.response.ReportNotesResponse;
import com.wbrain.ecommerce.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportsController {

    @Autowired
    ReportService service;

    @GetMapping()
    public List<ReportNotesResponse> consultReportsAll (){
        return service.reportAllClients();
    }

    @GetMapping("/client/{codeClient}")
    public ReportNotesResponse reportByClient(@PathVariable Integer codeClient){
         return service.reportNotesByClient(codeClient);
    }

    @GetMapping("/months")
    public ReportMonthResponse reportByMonths(@PathVariable LocalDate monthStart, @PathVariable LocalDate monthEnd){
        return service.reportNotesByMonth(monthStart);
    }

}
