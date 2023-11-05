package com.wbrain.ecommerce.resources;

import com.wbrain.ecommerce.response.ReportMonthResponse;
import com.wbrain.ecommerce.response.ReportNotesResponse;
import com.wbrain.ecommerce.services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Operation(summary = "Busca todas as notas agrupado por clientes", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping
    public ResponseEntity<List<ReportNotesResponse>> consultReportsAll (){
        return ResponseEntity.ok().body(service.reportAllClients());
    }

    @Operation(summary = "Busca todas as notas por cliente especifico", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/client/{codeClient}")
    public ResponseEntity<ReportNotesResponse> reportByClient(@PathVariable Integer codeClient){
         return ResponseEntity.ok().body(service.reportNotesByClient(codeClient));
    }

    @Operation(summary = "Busca valor total por range de datas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/months/{monthStart}/{monthEnd}")
    public ResponseEntity<ReportMonthResponse> reportByMonths(@PathVariable LocalDate monthStart, @PathVariable LocalDate monthEnd){
        return ResponseEntity.ok().body(service.reportNotesByMonth(monthStart, monthEnd));
    }

}
