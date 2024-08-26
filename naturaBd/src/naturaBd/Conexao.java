package naturaBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import DAO.UserDAO;
import classs.USUARIO;

public class Conexao {

	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl";
	private static final String USER = "rm94947";
	private static final String PASSWORD = "051203";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			System.out.println("Conexão estabelecida com sucesso.");
			// INICIANDO CLASSE USERDAO
			UserDAO userDAO = new UserDAO(connection);
			
			//LISTAR USUARIOS
			//List<USUARIO> usuarios = userDAO.listarUsuarios();
			//System.out.println("Lista de usuários:");
			//for (USUARIO u : usuarios) {
				//System.out.println("Nome: " + u.getNome() + ", Idade: " + u.getIdade());
			//}
			
			// Criar um novo usuário e inseri-lo
			// USUARIO usuario = new USUARIO();
			// usuario.setNome("Maria da Silva");
			// usuario.setIdade(28);
			// userDAO.inserirUsuario(usuario);
			// System.out.println("Usuário" + usuario.getNome() + " inserido com sucesso.");

			// Lista todos os usuários antes da remoção
            System.out.println("Lista de usuários antes da remoção:");
            List<USUARIO> usuarios = userDAO.listarUsuarios();
            for (USUARIO u : usuarios) {
                System.out.println("Nome: " + u.getNome() + ", Idade: " + u.getIdade());
            }

            // Remove um usuário
            userDAO.deletarUsuario("Maria da Silva");

            // Lista todos os usuários após a remoção
            System.out.println("Lista de usuários após a remoção:");
            usuarios = userDAO.listarUsuarios();
            for (USUARIO u : usuarios) {
                System.out.println("Nome: " + u.getNome() + ", Idade: " + u.getIdade());
            }
			
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
}