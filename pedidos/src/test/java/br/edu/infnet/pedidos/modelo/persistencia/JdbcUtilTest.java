package br.edu.infnet.pedidos.modelo.persistencia;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.fail;

public class JdbcUtilTest {


    @Test
    public void test(){
        try {
            JdbcUtil.obterConexao();
            Assert.assertTrue(true);
        } catch (Exception e) {
            fail();
        }

    }




}
