package br.edu.infnet.pedidos.modelo.persistencia;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {

    private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class.getName());

    public static Connection obterConexao() {

        logger.info("Obtendo conexão com o banco de dados");

        String url = "jdbc:mysql://localhost:3306/app?allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";


        try {
            return  DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.error("Erro ao obter conexão com o banco de dados", e);
            throw new RuntimeException(e);
        }

    }
}
