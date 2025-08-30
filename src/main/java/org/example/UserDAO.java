package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void insertuser(String firstname, String lastname, String email, String pass) throws Exception {
        String sql = "INSERT INTO user(firstname, lastname,email,password) VALUES (?, ?,?,?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, pass);
            ps.executeUpdate();
        }
    }

    public List<String> getUsers() throws Exception
    {
        List<String> list = new ArrayList<>();
        String sql="Select * from user";
        try(Connection con=DBUtil.getConnection();
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        ) {
            while (rs.next())
            {
                list.add(rs.getString("firstname") + " - " + rs.getString("lastname") + " - " + rs.getString("email")+ " - " + rs.getString("password"));

            }
        }
        return list;
    }
    public void updateUser(String fname,String lname,String email)
    {
        String sql = "UPDATE user SET firstname=?, lastname=? WHERE email=?";

        try {
            Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,email);

            if (ps.executeUpdate()==1) {
                System.out.println("Updated successfully");
            }else {
                System.out.println("Not able to update ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(String email)
    {
        String sql="Delete from user where email=?";
        try{
            Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,email);
            if (ps.executeUpdate()==1)
            {
                System.out.println("Deleted successfully");
            }
            else {
                System.out.println("Not able to delete");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}