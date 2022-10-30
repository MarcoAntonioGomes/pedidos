package br.edu.infnet.pedidos.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public  abstract class  JdbcDAO <T> implements IDAO <T> {
    protected Connection con;
    Statement stm;
    ResultSet rs;
    PreparedStatement ps;

    public JdbcDAO() {
        super();
        con = JdbcUtil.obterConexao();
    }
}
