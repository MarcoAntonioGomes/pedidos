package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.SQLException;
import java.util.List;

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

        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente("Marco");
        dao.salvar(cliente);
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
    public void testUpdate() throws Exception {

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listarTodos();
        Cliente cliente = clientes.get(0);
        cliente.setNome("Marco Gomes 2");
        boolean validacao = clienteDAO.atualizar(cliente);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testDelete() throws Exception {

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listarTodos();
        Cliente cliente = clientes.get(0);
        boolean validacao = clienteDAO.excluir(cliente);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testObter() throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listarTodos();
        Cliente cliente = clienteDAO.obter(clientes.get(0).getCodigo());
        Assert.assertNotNull(cliente);
    }

}