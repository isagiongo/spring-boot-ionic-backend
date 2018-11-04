package com.isagiongo.cursomc.domain.enums;

public enum TipoClienteEnum {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private Integer codigo;

	private String descricao;

	private TipoClienteEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoClienteEnum toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		for (TipoClienteEnum tipo : TipoClienteEnum.values()) {
			if (codigo.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
}