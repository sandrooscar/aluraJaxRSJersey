package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;
import junit.framework.Assert;

public class ClienteTest {
	private static final String urlServidor = "http://localhost:8080";
	private Client client = ClientBuilder.newClient();
	private HttpServer server;

	@Before
	public void startaServidor() {
		server = Servidor.inicializaServidor(urlServidor);
	}
	
	@After
	public void mataServidor() {
		server.stop();
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		WebTarget target = client.target(urlServidor);
		String conteudo = target.path("carrinhos").request().get(String.class);
		Carrinho carrinho = (Carrinho)new XStream().fromXML(conteudo);
		Assert.assertTrue("Rua Vergueiro 3185, 8 andar".equalsIgnoreCase(carrinho.getRua()));
	}
	
	@Test
	public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
		WebTarget target = client.target(urlServidor);
		String conteudo = target.path("projetos").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		Assert.assertTrue("Minha loja".equalsIgnoreCase(projeto.getNome()) && projeto.getAnoDeInicio() == 2014);
	}
	
	@Test
	public void testaBuscaProjeto() {
		WebTarget target = client.target(urlServidor);
		String conteudo = target.path("projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));
		System.out.println(conteudo);
	}
}
