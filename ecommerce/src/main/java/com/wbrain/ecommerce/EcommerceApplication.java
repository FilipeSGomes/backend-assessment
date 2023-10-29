package com.wbrain.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/cliente")
public class EcommerceApplication {

	private List<ClientSalva> clientes = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@PostMapping
	public String adicionacliente(@RequestBody ClientSalva clienteSalva) {
		clientes.add(clienteSalva);
		return "Consegui salvar";
	}

	@GetMapping
	public List<ClientSalva> pegaTodosClientes() {
		return clientes;
	}
}
