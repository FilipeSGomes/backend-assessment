package com.wbrain.ecommerce.services;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.request.NotesRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NoteService {

    Notes saveNoteRequest(NotesRequest notesRequest);
    List<Notes> findAllNotes();
    Optional<Notes> findNotesBycode(Integer code);
    List<Notes> findAllNotesByClientId(Integer code);
    Optional<Notes> alterNote(Notes notes);
    void deleteNotesBycode(Integer code);
    List<Notes> findAllNotesByDataBetween(LocalDate start, LocalDate end);
}
