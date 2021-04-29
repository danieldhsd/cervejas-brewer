package com.danieldhsd.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danieldhsd.brewer.model.Venda;
import com.danieldhsd.brewer.repository.helper.venda.VendasQueries;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

}
