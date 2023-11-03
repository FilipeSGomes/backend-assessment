package com.wbrain.ecommerce.resources;

import com.wbrain.ecommerce.domain.Client;
import com.wbrain.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientsController {

    @Autowired
    ClientService service;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return service.saveClient(client);
    }

    @GetMapping
    public List<Client> consultAllClients() {
        return service.findAllClient();
    }
}
