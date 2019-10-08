package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import junit.framework.Assert;

public class ClienteTest {
	private Client client = ClientBuilder.newClient();

	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		WebTarget target = client.target("http://www.mocky.io");
		String conteudo = target.path("v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<rua>Rua Vergueiro"));
		System.out.println(conteudo);
		
	}
	
	@Test
	public void testaBuscaProjeto() {
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));
		System.out.println(conteudo);
	}
}
