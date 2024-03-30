package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	

	@Test
	void bonusDevceriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
	        BonusService service = new BonusService();
	        try {
	                service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
	                Assertions.fail ("Não deu a exception!");
	        } catch (Exception e) {
	        	Assertions.assertEquals("Funcionario com salario maior do que R$10000 nao pode receber bonus!", e.getMessage());
	        }

	    }

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Cauane", LocalDate.now(), new BigDecimal("2500")));
		Assertions.assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Cauane", LocalDate.now(), new BigDecimal("1000")));
		Assertions.assertEquals(new BigDecimal("100.00"), bonus);
	}
}