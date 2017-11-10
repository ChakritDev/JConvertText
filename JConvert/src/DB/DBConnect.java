/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.*;

/**
 *
 * @author Hp
 */
public class DBConnect {
    public final String name_db ="DBJConvert.accdb";
    public final String sql = "Select * from Members where username=? and password=?";
    public boolean validate_login(String username,String passpord){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+name_db);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,passpord);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                //System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
             return true;
            }
            else{
             return false;
            }
            
//            Statement st = conn.createStatement();
//            String sql = "Select * from Members ";
//            ResultSet rs = st.executeQuery(sql);
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
//    public String name_db="DBJConvert.accdb";
//    public void setDB(){
//         try {
//            
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+name_db);
//            Statement st = conn.createStatement();
//            String sql = "Select * from Members ";
//            ResultSet rs = st.executeQuery(sql);
//            
//            while(rs.next()){
//                System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
//            }
//            
//        } 
//            catch (Exception e) {
//                System.out.println(e.getMessage());
//        }
//         
// 
//
//    } 
    
}
