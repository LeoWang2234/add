package com.ecust;


import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;

public class JdbcTest extends HttpServlet {
    /*
     *java驱动的测试
     */
    @Test
    public void service() throws ServletException, IOException {
        //加载驱动
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                    .newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //与指定数据库创建连接
        try {
            String uri = "jdbc:sqlserver://127.0.0.1:1434;DatabaseName=addTestdb";
            String user = "sa";
            String password = "root";
            Connection con = DriverManager.getConnection(uri, user, password);

            Statement st = con.createStatement();

            //第四步：写出sql语句，并用statement对象的方法来执行

//            String sql ="update person set pname ='ling' where pname ='ling'";
//            st.executeUpdate(sql);           增删改都用这条执行语句       因为增删改都更新了数据库
            String sql = "select * from addTestdb.dbo.student; ";
            ResultSet rs = st.executeQuery(sql);                   //查询用这条执行语句         查询的结果保存在结果集 ResultSet 类的对象rs中
            while (rs.next()) {                                                      //rs.next()   表示如果结果集rs还有下一条记录，那么返回true；否则，返回false
//                int id = rs.getInt("personid");
                String name = rs.getString(2);
                String sex = rs.getString(3);
//                System.out.println(id + "--->" + name + "--------" + sex);
                System.out.println(con.toString());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


