package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classs.USUARIO;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    
 // Método para criar a tabela de usuário
    public void criarTabela() {
        String sql = "CREATE TABLE USUARIO (" +
                     "nome VARCHAR2(100) NOT NULL," +
                     "idade NUMBER NOT NULL" +
                     ")";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabela USUARIO criada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para criar um novo usuário
    public void inserirUsuario(USUARIO usuario) {
        String sql = "INSERT INTO USUARIO (nome, idade) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para atualizar um usuário existente
    public void atualizarUsuario(USUARIO usuario) {
        String sql = "UPDATE USUARIO SET idade = ? WHERE nome = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getIdade());
            stmt.setString(2, usuario.getNome());
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para deletar um usuário
    public void deletarUsuario(String nome) {
        String sql = "DELETE FROM USUARIO WHERE nome = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Usuário deletado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para buscar um usuário por nome
    public USUARIO buscarUsuario(String nome) {
        String sql = "SELECT * FROM USUARIO WHERE nome = ?";
        USUARIO usuario = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new USUARIO();
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    // Método para listar todos os usuários
    public List<USUARIO> listarUsuarios() {
        String sql = "SELECT * FROM USUARIO";
        List<USUARIO> usuarios = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	USUARIO usuario = new USUARIO();
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }
}