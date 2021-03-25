package com.danieldhsd.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danieldhsd.brewer.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
