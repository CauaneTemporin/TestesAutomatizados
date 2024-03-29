package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desepenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Cauane", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario, Desepenho.A_DESEJAR);
		Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Cauane", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario, Desepenho.BOM);
		Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
}