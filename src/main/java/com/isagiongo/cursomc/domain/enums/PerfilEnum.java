package com.isagiongo.cursomc.domain.enums;

public enum PerfilEnum {

	ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE"), TESTE(3, "ROLE_TESTE");

	private Integer codigo;

	private String descricao;

	private PerfilEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static PerfilEnum toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		for (PerfilEnum tipo : PerfilEnum.values()) {
			if (codigo.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
}