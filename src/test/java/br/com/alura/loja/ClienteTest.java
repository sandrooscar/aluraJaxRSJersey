package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
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
		String conteudo = target.path("carrinhos/1").request().get(String.class);
		Carrinho carrinho = (Carrinho)new XStream().fromXML(conteudo);
		Assert.assertTrue("Rua Vergueiro 3185, 8 andar".equalsIgnoreCase(carrinho.getRua()));
	}
	
	@Test
	public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
		WebTarget target = client.target(urlServidor);
		String conteudo = target.path("projetos/1").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		Assert.assertTrue("Minha loja".equalsIgnoreCase(projeto.getNome()) && projeto.getAnoDeInicio() == 2014);
	}
	
	@Test
	public void testaBuscaProjeto() {
		WebTarget target = client.target(urlServidor);
		String conteudo = target.path("projetos/1").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));
		System.out.println(conteudo);
	}
	
	@Test
	public void testaPost() {
		Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
        carrinho.setRua("Rua Vergueiro");
        carrinho.setCidade("Sao Paulo");
        String xml = carrinho.toXML();
        
		WebTarget target = client.target(urlServidor);
		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        Assert.assertEquals("<status>sucesso</status>", response.readEntity(String.class));
		
	}
}
