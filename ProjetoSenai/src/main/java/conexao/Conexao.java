
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3307/Projetosenai";
    private static final String user  = "root";
    private static final String senha = "";
    
public static Connection conexao(){
    Connection conn = null;
    try{
        conn = DriverManager.getConnection(url, user, senha);
    } catch (Exception e){
        e.printStackTrace();
    }
    return conn;
    
     
     
 }
   public void testarConexao(){
      Connection conn = conexao();
       if (conn == null) {
           JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
       } else {
           
       }
       
   } 
    
   
}
