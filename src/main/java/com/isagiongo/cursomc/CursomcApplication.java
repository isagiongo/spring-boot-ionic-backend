package com.isagiongo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isagiongo.cursomc.domain.Categoria;
import com.isagiongo.cursomc.domain.Cidade;
import com.isagiongo.cursomc.domain.Cliente;
import com.isagiongo.cursomc.domain.Endereco;
import com.isagiongo.cursomc.domain.Estado;
import com.isagiongo.cursomc.domain.Produto;
import com.isagiongo.cursomc.domain.enums.TipoClienteEnum;
import com.isagiongo.cursomc.repositories.CategoriaRepository;
import com.isagiongo.cursomc.repositories.CidadeRepository;
import com.isagiongo.cursomc.repositories.ClienteRepository;
import com.isagiongo.cursomc.repositories.EnderecoRepository;
import com.isagiongo.cursomc.repositories.EstadoRepository;
import com.isagiongo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Papelaria");
		
		Produto p1 = new Produto(null,"Computador", 2450.00);
		Produto p2 = new Produto(null,"Cadeira", 324.98);
		Produto p3 = new Produto(null,"Mouse", 29.90);
		Produto p4 = new Produto(null,"Papel A4", 9.40);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

		Estado est1 = new Estado(null,"Pernambuco");
		Estado est2 = new Estado(null,"Rio Grande do Sul");
		Estado est3 = new Estado(null,"Bahia");
		Estado est4 = new Estado(null,"Minas Gerais");
		Estado est5 = new Estado(null,"Mato Grosso do Sul");
		
		Cidade c1 = new Cidade(null, "Recife", est1);
		Cidade c2 = new Cidade(null, "Porto Alegre", est2);
		Cidade c3 = new Cidade(null, "Salvador", est3);
		Cidade c4 = new Cidade(null, "Belo Horizonte", est4);
		Cidade c5 = new Cidade(null, "Dourador", est5);
		Cidade c6 = new Cidade(null, "Torres", est2);
		
		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2,c6));
		est3.getCidades().add(c3);
		est4.getCidades().add(c4);
		est5.getCidades().add(c5);
		
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3,est4,est5));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));
		
		Cliente cli1 = new Cliente(null, "Isadora Giongo", "isa@gmail.com", "89570260106", TipoClienteEnum.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("3333-0000","9988-88889"));
		Endereco e1 = new Endereco(null, "Amelia Teles", "120", "Apt 32", "Petrópolis", "90460155", c2, cli1);
		Endereco e2 = new Endereco(null, "Alameda Jau", "1890", "Casa 2", "Jardins", "7052555", c4, cli1);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	
	}
}
