package com.danieldhsd.brewer.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.danieldhsd.brewer.model.ItemVenda;

public class TabelaItensVenda {

	private List<ItemVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal() {
		return itens.stream()
				.map(ItemVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
}
