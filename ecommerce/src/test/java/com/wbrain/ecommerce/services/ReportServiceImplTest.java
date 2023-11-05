package com.wbrain.ecommerce.services;

import com.wbrain.ecommerce.mapper.ReportsMapper;
import com.wbrain.ecommerce.response.ReportNotesResponse;
import com.wbrain.ecommerce.services.impl.ReportServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {

    @InjectMocks
    ReportServiceImpl service;
    @Mock
    NoteService noteService;
    @Mock
    ClientService clientService;
    @Mock
    ReportsMapper mapper;

    @Test
    public void consultShouldReportAllClientSucess() {
        when(noteService.findAllNotesByClientId(any())).thenReturn(new NoteServiceImplTest().notesList());
        when(clientService.findAllClient()).thenReturn(new ClientServiceImplTest().clientList());
        when(mapper.map(any())).thenReturn(getCreate());

        assertNotNull(service.reportAllClients());

        verify(clientService, times(1)).findAllClient();
        verify(mapper, times(1)).map(any());
        verify(noteService, times(1)).findAllNotesByClientId(any());
    }

    @Test
    public void consultShouldReportByClientSucess() {
        when(noteService.findAllNotesByClientId(any())).thenReturn(new NoteServiceImplTest().notesList());
        when(mapper.map(any())).thenReturn(getCreate());

        assertNotNull(service.reportNotesByClient(1));

        verify(noteService, times(1)).findAllNotesByClientId(any());
        verify(mapper, times(1)).map(any());
    }

    @Test
    public void consultShouldReportNotesByMonthSucess() {
        when(noteService.findAllNotesByDataBetween(any(), any())).thenReturn(new NoteServiceImplTest().notesList());
        when(mapper.map(any())).thenReturn(getCreate());

        assertNotNull(service.reportNotesByMonth(LocalDate.now(), LocalDate.now().plusMonths(1L)));

        verify(mapper, times(1)).map(any());
        verify(noteService, times(1)).findAllNotesByDataBetween(any(), any());

    }

    @Test
    public void consultShouldReportNotesByMonthNotSucess() {
        when(noteService.findAllNotesByDataBetween(any(), any())).thenReturn(null);

        assertThrows(RuntimeException.class, () -> service.reportNotesByMonth(LocalDate.now(), LocalDate.now().plusMonths(1L)));

        verify(noteService, times(1)).findAllNotesByDataBetween(any(), any());

    }

    public ReportNotesResponse getCreate() {
        return ReportNotesResponse.builder()
                .client(new ClientServiceImplTest().clientList().get(0))
                .amount(BigDecimal.valueOf(150L))
                .build();
    }
}
