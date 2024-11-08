package dao;
import domain.*;
import java.sql.*;

public class ExameDao {
    public void inserir (Exame exame) throws Exception {
        Connection conexao = ConexaoMysql.getConexao();
        String sql = "INSERT INTO tb_exame (des_tipo, des_resultado, dat_exame, cod_consulta) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, exame.getTipo());
        ps.setObject(2, exame.getResultado());
        ps.setObject(3, exame.getData());
        ps.setInt(4, exame.getConsulta().getCodigo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            exame.setCodigo(rs.getInt(1));
        }
        ps.close();
        conexao.close();
    }

}
