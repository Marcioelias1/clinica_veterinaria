package dao;
import java.sql.*;
import domain.*;

public class TratamentoDao {
    public void inserir(Tratamento tratamento) throws Exception {
        Connection conexao = ConexaoMysql.getConexao();
        String sql = "INSERT INTO tb_tratamento (des_tratamento, cod_veterianario) VALUES (?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, tratamento.getDescricao());
        ps.setInt(2, tratamento.getIniciadoPor().getCodigo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
         tratamento.setCodigo((rs.getInt(1)));
        }
        ps.close();
        conexao.close();
    }
}
