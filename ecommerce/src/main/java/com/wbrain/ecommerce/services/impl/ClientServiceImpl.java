package com.wbrain.ecommerce.services.impl;

import com.wbrain.ecommerce.domain.Client;
import com.wbrain.ecommerce.repository.ClientRepository;
import com.wbrain.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public List<Client> findAllClient() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> findClientBycode(Integer code) {
        return repository.findById(code);
    }

    @Override
    public void deleteClientBycode(Integer code) {
        repository.deleteById(code);
    }
}
