package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desepenho {
	A_DESEJAR {
		@Override
		public BigDecimal porcentualAjuste() {
			return new BigDecimal("0.03");
		}
	},
	BOM {
		@Override
		public BigDecimal porcentualAjuste() {
			return new BigDecimal("0.15");
		}
	},
	OTIMO {
		@Override
		public BigDecimal porcentualAjuste() {
			return new BigDecimal("0.20");
		}
	};

	public abstract BigDecimal porcentualAjuste();
}