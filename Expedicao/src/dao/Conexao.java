package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




public class Conexao {

    private static final String Drive = "com.mysql.jdbc.Driver";
    private static final String Url = "jdbc:mysql://localhost:3306/expedicao";
    private static final String User = "root";
    private static final String Pass = "comp16";
    

    public  static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(Drive);

            conn = DriverManager.getConnection(Url, User, Pass);
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println("Problemas ao conectar no banco de dados");
            JOptionPane.showMessageDialog(null, "Problemas ao conectar no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/pet/icones/erro.png"));

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não é possível conectar-se ao banco de dados,\nEntre em contato com o suporte técnico.", "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/pet/icones/erro.png"));
        }
        return conn;
    }
    
    public static  void closeConnction(Connection conn){
        
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
     public static  void closeConnction(Connection conn, PreparedStatement stmt){
        
         closeConnction(conn);
         
         if(stmt != null){
             try {
                 stmt.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        
    }
     public static  void closeConnction(Connection conn, PreparedStatement stmt,ResultSet rs){
     
         closeConnction(conn, stmt);
         
         if(rs != null){
             
             try {
                 rs.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
         
     }
}
