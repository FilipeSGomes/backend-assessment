package com.wbrain.ecommerce.services;

import com.wbrain.ecommerce.domain.Notes;
import com.wbrain.ecommerce.mapper.NotesMapper;
import com.wbrain.ecommerce.repository.NotesRepository;
import com.wbrain.ecommerce.request.NotesRequest;
import com.wbrain.ecommerce.services.impl.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NoteServiceImplTest {

    @InjectMocks
    NoteServiceImpl service;
    @Mock
    NotesRepository repository;
    @Mock
    ClientService clientService;
    @Mock
    NotesMapper mapper;

    @Test
    public void consultShouldAllNotesSucess() {
        when(repository.findAll()).thenReturn(notesList());
        assertNotNull(service.findAllNotes());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void consultShouldAllNotesEmptySucess() {
        when(repository.findAll()).thenReturn(null);
        assertNull(service.findAllNotes());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void consultShouldNoteByCodeSucess() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(notesList().get(0)));
        assertNotNull(service.findNotesBycode(1));
        verify(repository, times(1)).findById(any());
    }

    @Test
    public void saveShouldNoteNotSucess() {
        when(clientService.findClientBycode(any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.saveNoteRequest(createNoteRequest()));
        verify(clientService, times(1)).findClientBycode(any());
    }


    @Test
    public void saveShouldNoteSucess() {
        when(clientService.findClientBycode(any())).thenReturn(Optional.ofNullable(new ClientServiceImplTest().clientList().get(0)));
        when(mapper.map(createNoteRequest())).thenReturn(notesList().get(0));
        when(repository.save(any())).thenReturn(notesList().get(0));

        assertNotNull(service.saveNoteRequest(createNoteRequest()));

        verify(repository, times(1)).save(any());
        verify(clientService, times(1)).findClientBycode(any());
        verify(mapper, times(1)).map(createNoteRequest());
    }

    @Test
    public void alterShouldNoteNotSucess() {
        when(repository.findById(any())).thenReturn(null);

        assertThrows(RuntimeException.class, () -> service.alterNote(notesList().get(0)));

        verify(repository, times(1)).findById(any());
    }

    @Test
    public void alterShouldNoteNotSucessClient() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(notesList().get(0)));
        when(clientService.findClientBycode(any())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.alterNote(notesList().get(0)));

        verify(clientService, times(1)).findClientBycode(any());
        verify(repository, times(1)).findById(any());
    }


    @Test
    public void alterShouldNoteSucess() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(notesList().get(0)));
        when(clientService.findClientBycode(any())).thenReturn(Optional.ofNullable(new ClientServiceImplTest().clientList().get(0)));
        when(repository.save(any())).thenReturn(notesList().get(0));

        assertNotNull(service.alterNote(notesList().get(0)));

        verify(repository, times(1)).findById(any());
        verify(repository, times(1)).save(any());
    }


    @Test
    public void deleteShouldNoteNotSucess() {
        when(repository.findById(any())).thenReturn(null);

        assertThrows(RuntimeException.class, () -> service.deleteNotesBycode(1));

        verify(repository, times(1)).findById(any());
    }

    @Test
    public void deleteShouldNoteSucess() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(notesList().get(0)));

        service.deleteNotesBycode(1);

        verify(repository, times(1)).findById(any());
        verify(repository, times(1)).deleteById(any());

    }

    public NotesRequest createNoteRequest() {
        return NotesRequest.builder()
                .valor(BigDecimal.TEN)
                .idClient(1)
                .data(LocalDate.now())
                .build();
    }

    public List<Notes> notesList() {
        return Collections.singletonList(Notes.builder()
                .amount(BigDecimal.TEN)
                .client(new ClientServiceImplTest().clientList().get(0))
                .data(LocalDate.now())
                .id(1)
                .build());
    }

}
