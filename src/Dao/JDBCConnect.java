package Dao;

import Entities.Student;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JDBCConnect {
    public static String drv="com.mysql.jdbc.Driver";//数据库驱动
    public static String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";//数据库网址
    public static String usr="root";//用户名
    public static String pwd="root";//密码

    Connection connect = null;
    Statement stmt=null;
    ResultSet rs = null;


    boolean defaultCommit;

    public JDBCConnect()  throws Exception{
        Class.forName(drv);
        connect = DriverManager.getConnection(url, usr, pwd);
        stmt = connect.createStatement();
    }

    public void  query(String sql) throws SQLException{
        rs = stmt.executeQuery(sql);
    }

    public Integer update(String sql) throws SQLException {
        return stmt.executeUpdate(sql);
    }

    public boolean next() throws SQLException{//rs的下一条记录是否存在
        return rs.next();
    }

    public String getString(String field) throws SQLException{//获取字符串类型字段的值，字段值为null型的，按照空字符串处理
        return rs.getString(field);
    }

    public Integer getInt(String field) throws SQLException{//获取整数类型字段的值
        return rs.getInt(field);
    }

    public Timestamp getTimestamp(String field) throws SQLException{//获取整数类型字段的值
        return rs.getTimestamp(field);
    }

    public LocalDateTime getLocalDateTime(String field) throws SQLException{//获取日期时间类型字段的值
        return rs.getTimestamp(field).toLocalDateTime();
    }

    public Float getFloat(String field) throws SQLException{//获取实数类型字段的值
        return rs.getFloat(field);
    }

    public Student searchOne(Integer id) throws SQLException{
        // 获取表的字段名称，并保存到数组中
        String sql = "select * from student where id="+id;
        connect = DriverManager.getConnection(url, usr, pwd);
        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet fields =statement.executeQuery();
        Student student = new Student();
        while (fields.next()) {
            student.setId(fields.getInt("id"));
            student.setName(fields.getString("name"));
            student.setBirDate(fields.getString("birDate"));
            student.setGender(fields.getBoolean("gander"));
        }
        connect.close();
        statement.close();
        fields.close();

        return student;
    }

    //数据全查
    public ArrayList<Student> searchAllList() throws SQLException{
        // 获取表的字段名称，并保存到数组中
        ArrayList<Student> fieldList = new ArrayList<Student>();
        String sql = "select * from student limit 10";
        connect = DriverManager.getConnection(url, usr, pwd);
        PreparedStatement statement = connect.prepareStatement(sql);
        ResultSet fields =statement.executeQuery();

        while (fields.next()) {
            Student student = new Student();
            student.setId(fields.getInt("id"));
            student.setName(fields.getString("name"));
            student.setBirDate(fields.getString("birDate"));
            student.setGender(fields.getBoolean("gander"));
            fieldList.add(student);
        }
        connect.close();
        statement.close();
        fields.close();
        return fieldList;
    }

    //修改某个表，某条记录（id）的某个字符型字段的值
    public Integer updateById(Integer id,String name,String birDate)throws SQLException{
        String sql="update student set name='"+name+"' ,birDate = '"+ birDate +"' where "+"id="+id.toString();
        return update(sql);
    }

    public Integer insert(Integer id,String name,String birDate,boolean gander)throws SQLException{
        String sql="insert into student(id,name,birDate,gander) values("+id+","+ name +","+birDate+","+gander+")";
        System.out.println(id);
        return update(sql);
    }

    public void setAutoCommit(boolean f) throws SQLException{
        connect.setAutoCommit(f);
    }

    public void commit() throws SQLException{
        connect.commit();
    }

    //删除用户
    public Integer delete(String id)throws SQLException{
        //查询失败返回-1
        if(id!=null){
            String sql = "delete from student where id='"+ id +"'";
            return this.update(sql);
        }else
            return -1;
    }
}
