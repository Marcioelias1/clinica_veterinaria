package dao;

import java.sql.*;
import domain.*;
public class AtendenteDao {
    public void inserir(Atendente atendente) throws Exception {
        Connection conexao = ConexaoMysql.getConexao();
        String sql = "INSERT INTO tb_atendente (nom_atendente, des_telefone, vlr_salario) VALUES (?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, atendente.getNome());
        ps.setString(2, atendente.getTelefone());
        ps.setDouble(3, atendente.getSalario());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            atendente.setCodigo((rs.getInt(1)));
        }
        ps.close();
        conexao.close();
    }

}

