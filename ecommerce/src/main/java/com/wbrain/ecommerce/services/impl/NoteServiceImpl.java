package com.wbrain.ecommerce.services.impl;

import com.wbrain.ecommerce.domain.Client;
import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.mapper.NotesMapper;
import com.wbrain.ecommerce.repository.NotesRepository;
import com.wbrain.ecommerce.request.NotesRequest;
import com.wbrain.ecommerce.services.ClientService;
import com.wbrain.ecommerce.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private static final String NOT_FOUND_NOTE = "Note not found";
    private static final String NOT_FOUND_NOTE_CLIENT = "Error updown Note, Client not found";

    @Autowired
    NotesRepository repository;
    @Autowired
    ClientService clientService;
    @Autowired
    NotesMapper mapper;

    @Override
    public Notes saveNoteRequest(NotesRequest notesRequest) {
        Optional<Client> client = clientService.findClientBycode(notesRequest.getIdClient());
        if (client.isEmpty()) {
            throw new RuntimeException(NOT_FOUND_NOTE_CLIENT + notesRequest);
        }
        Notes note = mapper.map(notesRequest);
        note.setClient(client.get());
        return saveNote(note);
    }

    @Override
    public List<Notes> findAllNotes() {
        return repository.findAll();
    }

    @Override
    public Optional<Notes> findNotesBycode(Integer code) {
        return repository.findById(code);
    }

    @Override
    public Optional<Notes> alterNote(Notes notes) {
        if (findNotesBycode(notes.getId()).isEmpty()) {
            throw new RuntimeException(NOT_FOUND_NOTE + notes);
        }
        return Optional.of(saveNote(notes));
    }

    @Override
    public void deleteNotesBycode(Integer code) {
        if (findNotesBycode(code).isEmpty()) {
            throw new RuntimeException(NOT_FOUND_NOTE + code);
        }
        repository.deleteById(code);
    }

    @Override
    public List<Notes> findAllNotesByClientId(Integer codeClient) {
        return repository.findAllNotesByClientId(codeClient);
    }


    @Override
    public List<Notes> findAllNotesByDataBetween(LocalDate start, LocalDate end) {
        return repository.findByDataBetween(start,end);
    }



    @Transactional
    private Notes saveNote(Notes notes) {
        return repository.save(notes);
    }
}