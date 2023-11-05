package com.wbrain.ecommerce.services;

import com.wbrain.ecommerce.domain.Client;
import com.wbrain.ecommerce.repository.ClientRepository;
import com.wbrain.ecommerce.services.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {

    @InjectMocks
    ClientServiceImpl service;

    @Mock
    ClientRepository repository;

    @Test
    public void consultShouldAllClientSucess() {
        when(repository.findAll()).thenReturn(clientList());

        assertNotNull(service.findAllClient());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void saveClientSucess() {
        when(repository.save(any())).thenReturn(clientList().get(0));

        assertNotNull(service.saveClient(Client.builder().build()));

        verify(repository, times(1)).save(any());
    }

    @Test
    public void consultShouldAllClientEmptySucess() {
        when(repository.findAll()).thenReturn(null);

        assertNull(service.findAllClient());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void consultShouldClientByIdSucess() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(clientList().get(0)));

        assertNotNull(service.findClientBycode(1));

        verify(repository, times(1)).findById(any());
    }

    @Test
    public void deleteShouldClientByIdSucess() {
        when(repository.findById(any())).thenReturn(Optional.ofNullable(clientList().get(0)));

        service.deleteClientBycode(1);

        verify(repository, times(1)).findById(any());
        verify(repository, times(1)).deleteById(any());
    }

    @Test
    public void deleteShouldClientByIdNotSucess() {
        when(repository.findById(any())).thenReturn(null);

        assertThrows(RuntimeException.class, () -> service.deleteClientBycode(1));

        verify(repository, times(1)).findById(any());
    }

    public List<Client> clientList() {
        return Collections.singletonList(Client.builder()
                .id(1)
                .cpf("45747778854")
                .nome("Filipe G Gomes")
                .telefone("11979562271")
                .build());
    }
}
