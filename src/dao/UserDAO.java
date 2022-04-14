package dao;
import Factory.ConnectionFactory;
import modelo.User;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

//esta classe realiza o envio e a consulta dos dados no banco de dados MySQL

public class UserDAO { 
    private Connection connection;
    private Long id;
    private String nome;
    private String cpf;
    private String Sexo;
    private int Idade;
    private String Endereço;
    private String Escolaridade;
    private String Pai;
    private String Mãe;
    private String Descr;
    private Connection conn;
    
    public UserDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(User User){ 
        String sql = "INSERT INTO user(nome,cpf,sexo,idade, endereço, escolaridade, pai, mãe, descricao) VALUES(?,?,?,?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, User.getNome());
            stmt.setString(2, User.getCPF());
            stmt.setString(3, User.getSexo());
            stmt.setInt(4, User.getIdade());
            stmt.setString(5, User.getEndereço());
            stmt.setString(6, User.getEscolaridade());
            stmt.setString(7, User.getPai());
            stmt.setString(8, User.getMae());
            stmt.setString(9, User.getDescr());
           
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
         
    } 
    
    public List<User> Relatório(){
    	List<User> Users = new ArrayList<User>();
    	try {
    		Connection connection = new ConnectionFactory().getConnection();
    		
    		String sql = "SELECT * FROM user ORDER BY id DESC";
    		
    		PreparedStatement statement = connection.prepareStatement(sql);
    		
    		ResultSet resultset = statement.executeQuery();
    		
    		while(resultset.next()) {
    			User user = new User();
    			user.setId(resultset.getInt("id"));
    			user.setNome(resultset.getString("nome"));
    			user.setCPF(resultset.getString("cpf"));
    			user.setSexo(resultset.getString("sexo"));
    			user.setIdade(resultset.getInt("idade"));
    			user.setEndereço(resultset.getString("endereço"));
    			user.setEscolaridade(resultset.getString("escolaridade"));
    			user.setPai(resultset.getString("pai"));
    			user.setMae(resultset.getString("mãe"));
    			user.setDescr(resultset.getString("descricao"));
    			
    			Users.add(user);
    			
    		}
    		connection.close();
    		
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return Users;
    }
    
}