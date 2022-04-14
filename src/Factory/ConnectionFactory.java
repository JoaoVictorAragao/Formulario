// situa em qual package ou "pacote" está a classe 
package Factory; 

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 

// conexão SQL para Java 

import java.sql.DriverManager; 

// driver de conexão SQL para Java 

import java.sql.SQLException; 
// classe para tratamento de exceções 
public class ConnectionFactory {
     public Connection getConnection() {
		 try {
			//Subistitua o caminho pelo caminho do seu banco de dados, e as informações de login e senha do banco também.
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/forms?useTimezone=true&serverTimezone=UTC","root","");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
