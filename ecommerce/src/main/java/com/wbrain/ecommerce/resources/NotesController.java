package com.wbrain.ecommerce.resources;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.request.NotesRequest;
import com.wbrain.ecommerce.services.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NoteService service;

    @Operation(summary = "Realiza o upload de notes", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criação de nota realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de notes"),
    })
    @PostMapping
    public ResponseEntity<Notes> createNotes(@RequestBody NotesRequest notesRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNoteRequest(notesRequest));
    }

    @Operation(summary = "Busca todas as notas cadastradas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping
    public ResponseEntity<List<Notes>> consultAllNotes() {
        return ResponseEntity.ok(service.findAllNotes());
    }

    @Operation(summary = "Busca nota por codigo", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/{code}")
    public Optional<Notes> consultNotesByCode(@PathVariable Integer code) {
        return service.findNotesBycode(code);
    }

    @Operation(summary = "Altera nota já cadastrada", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Alteração realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @PutMapping
    public ResponseEntity<Optional<Notes>> alterNote(Notes note) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.alterNote(note));
    }

    @DeleteMapping("/{code}")
    public void deleteNoteByCode(@PathVariable Integer code) {
        service.deleteNotesBycode(code);
    }
}
