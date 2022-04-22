// situa em qual package ou "pacote" está a classe 
package Factory; 

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
import java.sql.*;
//IMPORTANTE!!!! o import java.sql.* foi necessário para que a conexão com o banco de dados que está no google clouds fosse bem sucedida
// conexão SQL para Java 

import java.sql.DriverManager; 

// driver de conexão SQL para Java 

import java.sql.SQLException; 
// classe para tratamento de exceções 
public class ConnectionFactory {
     public Connection getConnection() {
		 try {
			
			//Subistitua o caminho pelo caminho do seu banco de dados, e as informações de login e senha do banco também.
			return DriverManager.getConnection("jdbc:mysql://34.95.199.28:3306/Forms","root","123");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
