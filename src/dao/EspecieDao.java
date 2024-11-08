package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.Especie;

public class EspecieDao {

    public void inserir(Especie especie) throws Exception {
        String sql = "INSERT INTO TB_ESPECIE(NOM_ESPECIE) VALUES (?)";
        Connection conexao = ConexaoMysql.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql,
        Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, especie.getNome());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            especie.setCodigo(rs.getInt(1));
        }
        stmt.close();
        conexao.close();
    }
}
