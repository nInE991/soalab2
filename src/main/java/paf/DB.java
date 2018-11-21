package paf;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {
    static final String DB_URL = "jdbc:sqlserver://localhost";
    static final String USER = "sa";
    static final String PASS = "EbKnCew3gV";

    public Connection Connect(){
        Connection connection;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            return null;
        }catch (ClassNotFoundException ex){
            return  null;
        }
        return connection;
    }

    public List<Cake> Read() {
        List<Cake> cakeList = new ArrayList<>();
        HashMap<String,Cake> hashMap=new HashMap<>();

        try{
            Statement statement = Connect().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from lab2soa.dbo.Cake");
            while (resultSet.next()) {
                Cake cake = new Cake();
                cake.setId(resultSet.getInt("Id"));
                cake.setName(resultSet.getString("Name"));
                cake.setCost(resultSet.getFloat("Cost"));
                cake.setCount(resultSet.getFloat("Count"));
                cakeList.add(cake);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException ex){
            return null;
        }
        finally {
             try{
              Connect().close();
              }catch (SQLException ex){

             }
        }
      return cakeList;
    }

    public int Create(Cake cake){
        int status = 0;
        try{
            PreparedStatement preparedStatement =Connect().prepareStatement("insert into lab2soa.dbo.Cake(Name,Cost,Count) values (?,?,?)");
            preparedStatement.setString(1,cake.getName());
            preparedStatement.setFloat(2,cake.getCost());
            preparedStatement.setFloat(3,cake.getCount());
            status=preparedStatement.executeUpdate();
        }catch (Exception ex){
        }finally{
            try {
                Connect().close();
            }catch(Exception ex){

            }
        }
        return status;
    }

    public int Update(Cake cake){
        int status;
        try{
            PreparedStatement preparedStatement =Connect().prepareStatement("update lab2soa.dbo.Cake set Name=?,Cost=?,Count=? where id=?");
            preparedStatement.setString(1,cake.getName());
            preparedStatement.setFloat(2,cake.getCost());
            preparedStatement.setFloat(3,cake.getCount());
            preparedStatement.setInt(4,cake.getId());
            status=preparedStatement.executeUpdate();
        }catch (Exception ex){
            status=0;
        }finally{
            try {
                Connect().close();
            }catch(Exception ex){

            }
        }
        return status;
    }

    public int Delete(int id){
        int status;
        try{
            PreparedStatement preparedStatement= Connect().prepareStatement("delete from lab2soa.dbo.Cake where id=?");
            preparedStatement.setInt(1,id);
            status = preparedStatement.executeUpdate();
        }catch(Exception ex){
            status=0;
        }
        finally {
            try{
                Connect().close();
            }catch(Exception ex){

            }
        }
        return status;
    }

}

