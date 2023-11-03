package com.wbrain.ecommerce.services;

import com.wbrain.ecommerce.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client saveClient(Client client);

    List<Client> findAllClient();

    Optional<Client> findClientBycode(Integer code);

    void deleteClientBycode(Integer code);
}
