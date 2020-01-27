package br.edu.ifal.compras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class ListaComprasControllerTest extends AbstractTest {
   
    @Override
    @Before
   public void setUp() {
       super.setUp();
   }

@Test
public void deveRetornarAPaginaListaDeComprasInicialmenteVazia() throws Exception {
    String uri = "/listacompra";
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);   
}
@Test
public void testeDeCriacaoDeProduto() throws Exception{

    String uri = "/listacompras/cadastro";
    Item item = new Item();
    item.setId(1);
    item.setDescricao("cadeira");
    String inputJson = super.mapToJson(item);
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
    .contentType(MediaType.APPLICATION_JSON_VALUE)
    .content(inputJson)).andReturn();
 
 int status = mvcResult.getResponse().getStatus();
 assertEquals(302, status);   

}
}