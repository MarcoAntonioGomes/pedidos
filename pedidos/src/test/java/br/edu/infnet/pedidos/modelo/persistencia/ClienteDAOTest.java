package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ClienteDAO Tester. 
* 
* @author <Marco.Gomes>
* @since <pre>out 30, 2022</pre> 
* @version 1.0 
*/ 
public class ClienteDAOTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: salvar(Cliente cliente)
     */
    @Test
    public void testSalvar() throws Exception {

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("Marco Gomes");
        boolean validacao = clienteDAO.salvar(cliente);
        Assert.assertTrue(validacao);

    }

    @Test
    public void testListarTodos() throws Exception {

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("Marco Gomes");
        clienteDAO.salvar(cliente);
        Assert.assertTrue(clienteDAO.listarTodos().size() > 0);
    }

    @Test
    public void update() throws Exception {

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("Marco Gomes");
        cliente.setCodigo(1L);
        clienteDAO.salvar(cliente);
        cliente.setNome("Marco Gomes 2");
        boolean validacao = clienteDAO.atualizar(cliente);
        Assert.assertTrue(validacao);
    }

    @Test
    public void delete() throws Exception {

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("Marco Gomes");
        cliente.setCodigo(1L);
        clienteDAO.salvar(cliente);
        boolean validacao = clienteDAO.excluir(cliente);
        Assert.assertTrue(validacao);
    }

}