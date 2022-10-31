package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Pedido;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* PedidoDAO Tester. 
* 
* @author <Authors name> 
* @since <pre>out 31, 2022</pre> 
* @version 1.0 
*/ 
public class PedidoDAOTest {

    IDAO dao = new PedidoDAO();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: salvar(Pedido obj) 
* 
*/ 
@Test
public void testSalvar() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: listarTodos() 
* 
*/ 
@Test
public void testListarTodos() throws Exception {
    List<Pedido> pedidos = dao.listarTodos();
    Assert.assertNotNull(pedidos);
    Assert.assertTrue(pedidos.size() > 0);
}

/** 
* 
* Method: atualizar(Pedido obj) 
* 
*/ 
@Test
public void testAtualizar() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: excluir(Pedido obj) 
* 
*/ 
@Test
public void testExcluir() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: obter(Long codigo) 
* 
*/ 
@Test
public void testObter() throws Exception { 
//TODO: Test goes here... 
} 


} 
