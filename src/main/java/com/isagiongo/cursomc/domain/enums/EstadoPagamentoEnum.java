package com.isagiongo.cursomc.domain.enums;

public enum EstadoPagamentoEnum {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private Integer codigo;
	private String descricao;
	private EstadoPagamentoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamentoEnum toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for (EstadoPagamentoEnum tipo : EstadoPagamentoEnum.values()) {
			if(codigo.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
}