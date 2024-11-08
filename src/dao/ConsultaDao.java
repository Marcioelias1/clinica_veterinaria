package dao;
import domain.*;
import java.sql.*;

public class ConsultaDao {
    public void inserir(Consulta consulta) throws Exception {
        Connection conexao = ConexaoMysql.getConexao();
        String sql = "INSERT INTO tb_consulta (des_resumo, dat_consulta, cod_tratamento, cod_veterinario) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, consulta.getResumo());
        ps.setObject(2, consulta.getData());
        ps.setInt(3, consulta.getTratamento().getCodigo());
        ps.setInt(4, consulta.getVeterinario().getCodigo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            consulta.setCodigo((rs.getInt(1)));
        }
        ps.close();
        conexao.close();
    }
}
