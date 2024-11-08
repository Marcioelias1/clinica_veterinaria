package dao;
import java.sql.*;
import domain.*;
public class VeterinarioDao {
    public void inserir(Veterinario veterinario) throws Exception{
        Connection conexao = ConexaoMysql.getConexao();
        String sql = "INSERT INTO tb_veterinario (nom_veterinario, des_telefone, des_crmv) VALUES (?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, veterinario.getNome());
        ps.setString(2, veterinario.getTelefone());
        ps.setString(3, veterinario.getCrmv());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            veterinario.setCodigo((rs.getInt(1)));
        }
        ps.close();
        conexao.close();
    }

}
