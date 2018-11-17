package com.isagiongo.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isagiongo.cursomc.domain.Categoria;
import com.isagiongo.cursomc.domain.Cidade;
import com.isagiongo.cursomc.domain.Cliente;
import com.isagiongo.cursomc.domain.Endereco;
import com.isagiongo.cursomc.domain.Estado;
import com.isagiongo.cursomc.domain.ItemPedido;
import com.isagiongo.cursomc.domain.Pagamento;
import com.isagiongo.cursomc.domain.PagamentoComBoleto;
import com.isagiongo.cursomc.domain.PagamentoComCartao;
import com.isagiongo.cursomc.domain.Pedido;
import com.isagiongo.cursomc.domain.Produto;
import com.isagiongo.cursomc.domain.enums.EstadoPagamentoEnum;
import com.isagiongo.cursomc.domain.enums.TipoClienteEnum;
import com.isagiongo.cursomc.repositories.CategoriaRepository;
import com.isagiongo.cursomc.repositories.CidadeRepository;
import com.isagiongo.cursomc.repositories.ClienteRepository;
import com.isagiongo.cursomc.repositories.EnderecoRepository;
import com.isagiongo.cursomc.repositories.EstadoRepository;
import com.isagiongo.cursomc.repositories.ItemPedidoRepository;
import com.isagiongo.cursomc.repositories.PagamentoRepository;
import com.isagiongo.cursomc.repositories.PedidoRepository;
import com.isagiongo.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

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

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Papelaria");
		Categoria cat4 = new Categoria(null, "Móveis");
		Categoria cat5 = new Categoria(null, "Livros");
		Categoria cat6 = new Categoria(null, "Música");
		Categoria cat7 = new Categoria(null, "Beleza");
		Categoria cat8 = new Categoria(null, "Eletroportáteis");
		Categoria cat9 = new Categoria(null, "Games");
		Categoria cat10 = new Categoria(null, "Telefonia");
		Categoria cat11 = new Categoria(null, "teste");
		
		Produto p1 = new Produto(null, "Computador", 2450.00);
		Produto p2 = new Produto(null, "Cadeira", 324.98);
		Produto p3 = new Produto(null, "Mouse", 29.90);
		Produto p4 = new Produto(null, "Papel A4", 9.40);
		Produto p5 = new Produto(null, "Mesa Redonda", 123.66);
		Produto p6 = new Produto(null, "Playstation 4", 999.99);
		Produto p7 = new Produto(null, "Caderno 200 folhas", 21.90);
		Produto p8 = new Produto(null, "Fone bluetooth", 29.90);
		Produto p9 = new Produto(null, "Caixa de Som", 9.40);
		Produto p10 = new Produto(null, "Espelho", 123.66);
		Produto p11 = new Produto(null, "Liquidificador", 999.99);
		Produto p12 = new Produto(null, "Agenda", 21.90);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4, p1));
		cat4.getProdutos().addAll(Arrays.asList(p4, p6));
		cat5.getProdutos().addAll(Arrays.asList(p5, p7, p8));
		cat6.getProdutos().addAll(Arrays.asList(p1, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11, p8, p9, p12, p10));
		cat8.getProdutos().addAll(Arrays.asList(p5, p3));
		cat9.getProdutos().addAll(Arrays.asList(p11, p3));
		cat10.getProdutos().addAll(Arrays.asList(p12, p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat3, cat6));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat8, cat9));
		p4.getCategorias().addAll(Arrays.asList(cat3, cat4));
		p5.getCategorias().addAll(Arrays.asList(cat5, cat8));
		p6.getCategorias().addAll(Arrays.asList(cat4));
		p7.getCategorias().addAll(Arrays.asList(cat5));
		p8.getCategorias().addAll(Arrays.asList(cat5, cat7));
		p9.getCategorias().addAll(Arrays.asList(cat7));
		p10.getCategorias().addAll(Arrays.asList(cat6, cat7));
		p11.getCategorias().addAll(Arrays.asList(cat7, cat9, cat10));
		p12.getCategorias().addAll(Arrays.asList(cat7, cat10));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Rio Grande do Sul");
		Estado est3 = new Estado(null, "Bahia");
		Estado est4 = new Estado(null, "Minas Gerais");
		Estado est5 = new Estado(null, "Mato Grosso do Sul");

		Cidade c1 = new Cidade(null, "Recife", est1);
		Cidade c2 = new Cidade(null, "Porto Alegre", est2);
		Cidade c3 = new Cidade(null, "Salvador", est3);
		Cidade c4 = new Cidade(null, "Belo Horizonte", est4);
		Cidade c5 = new Cidade(null, "Dourador", est5);
		Cidade c6 = new Cidade(null, "Torres", est2);

		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c6));
		est3.getCidades().add(c3);
		est4.getCidades().add(c4);
		est5.getCidades().add(c5);

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

		Cliente cli1 = new Cliente(null, "Leonardo Giongo", "leonardogiongo@gmail.com", "89570260106",
				TipoClienteEnum.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("3333-0000", "9988-88889"));
		Endereco e1 = new Endereco(null, "Amelia Teles", "120", "Apt 32", "Petrópolis", "90460155", c2, cli1);
		Endereco e2 = new Endereco(null, "Alameda Jau", "1890", "Casa 2", "Jardins", "7052555", c4, cli1);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		Cliente cli2 = new Cliente(null, "Veronica Torres", "serrotacinorev@yahoo.com.br", "77785225142",
				TipoClienteEnum.PESSOA_FISICA);
		cli2.getTelefones().add("98764-3322");
		Endereco e3 = new Endereco(null, "Amelia Teles", "120", "Apt 32", "Petrópolis", "90460155", c2, cli2);
		cli2.getEnderecos().add(e3);

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamentoEnum.PENDENTE, ped2,
				sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 15.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 29.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}