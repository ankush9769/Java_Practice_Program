package DAO;

import model.Student;
import util.dbconfig;

import java.sql.*;

public class StudentDAO {
    public static void insert(Student s){
        try{
            Connection conn = dbconfig.connect();
            PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?)");
            ps.setInt(1,s.getId());
            ps.setString(2,s.getName());
            ps.setString(3,s.getCourse());
            ps.setInt(4,s.getMarks());
            ps.executeUpdate();
            System.out.println("student added successfully");
        }catch(Exception e){
            System.out.println("error =>"+e);
        }
    }
    public static void view(){
        try{
            Connection conn = dbconfig.connect();
            String query = "select * from student";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("id="+rs.getInt(1)+"...name="+rs.getString(2)+"...course="+rs.getString(3)+"...marks="+rs.getInt(4));
            }
        }catch(Exception e){
            System.out.println("error=>"+e);
        }
    }
    public static void update(int reqid,int reqmarks){
        try{
            Connection conn = dbconfig.connect();
            PreparedStatement ps = conn.prepareStatement("update student set marks = ? where id = ?");
            ps.setInt(1,reqmarks);
            ps.setInt(2,reqid);
            ps.executeUpdate();
            System.out.println("updated successfully");
        }catch(Exception e){
            System.out.println("error ="+e);
        }
    }

    public static void delete(int delid){
        try{
            Connection conn = dbconfig.connect();
            PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");
            ps.setInt(1,delid);
            ps.executeUpdate();
            System.out.println("delete successfully");
        }catch(Exception e){
            System.out.println("error="+e);
        }


    }
}
