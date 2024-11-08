package dao;

import java.sql.*;

import domain.*;

public class ClienteDao {
    public void inserir(Cliente cliente) throws Exception {
        Connection conexao = ConexaoMysql.getConexao();
        String sql = "INSERT INTO tb_cliente (nom_cliente, des_telefone, des_endereco, cod_cadastrado_por) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getTelefone());
        ps.setString(3, cliente.getEndereco());
        ps.setInt(4, cliente.getCadastradoPor().getCodigo());

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            cliente.setCodigo((rs.getInt(1)));
        }
        inserirPets(cliente);
        ps.close();
        conexao.close();
    }

    private void inserirPets(Cliente cliente) throws Exception {
        for (Pet pet : cliente.getPets()) {
            Connection conexao = ConexaoMysql.getConexao();
            String sql = "INSERT INTO tb_pet (nom_pet, dat_nascimento, des_genero, cod_tutor, cod_especies) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pet.getNome());
            ps.setObject(2, pet.getDataNascimento());
            ps.setString(3, pet.getGenero().name());
            ps.setInt(4, pet.getTutor().getCodigo());
            ps.setInt(5, pet.getEspecie().getCodigo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pet.setCodigo(rs.getInt(1));
            }
            ps.close();
            conexao.close();
        }

    }

}
