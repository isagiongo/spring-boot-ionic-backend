package com.isagiongo.cursomc.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.isagiongo.cursomc.domain.enums.TipoClienteEnum;
import com.isagiongo.cursomc.dto.ClienteNewDTO;
import com.isagiongo.cursomc.resources.exception.FieldMessage;
import com.isagiongo.cursomc.services.validations.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	public void initialize(ClienteInsert ann) {
	}

	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDTO.getTipoCliente().equals(TipoClienteEnum.PESSOA_FISICA.getCodigo())
				&& !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDTO.getTipoCliente().equals(TipoClienteEnum.PESSOA_JURIDICA.getCodigo())
				&& !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		for (FieldMessage error : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(error.getMessage()).addPropertyNode(error.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
