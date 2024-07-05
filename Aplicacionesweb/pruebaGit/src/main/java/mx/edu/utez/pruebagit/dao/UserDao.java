package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.User;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Me permite hacer funciones CRUD
public class UserDao {
    //Para la lectura de una entidad en la base de datos
    public User getOne(String user_name, String pass){
        User u = new User();
        // Los símbolos de ? son para evitar la inyección de código SQL
        String query = "select * from users where user_name = ? and pass = sha2(?, 256)";

        try{
            //Conectarse a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Definir los parámetros del query (los símbolos de interrogación)
            ps.setString(1,user_name);
            ps.setString(2, pass);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //El usuario si existe en la base de datos
                u.setId(rs.getInt("id"));
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setCody(rs.getString("cody"));
                u.setEstado(rs.getBoolean("status"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public boolean insert(User user){
        boolean flag = false;
        String query = "insert into users(user_name, pass, email) values (?,sha2(?, 256),?)";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getEmail());
            if(ps.executeUpdate()==1){
                flag = true; //Si se insertó el dato
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<User> getAll(){
        ArrayList<User> users = new ArrayList<>();
        String query = "select * from users";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ //Iteramos cada fila resultado de la query
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setCody(rs.getString("cody"));
                u.setEstado(rs.getBoolean("estado"));
                users.add(u);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    // Si voy a editar debo tener 2 parámetros 1 el ID del usuario y 2 el Usuario como tal
    public boolean update(int id, User u){
        boolean flag = false;
        String query = "update users set user_name = ?, email = ?, pass = sha2(?,256) where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, u.getUser_name());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPass());
            ps.setInt(4, id);
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return flag;
    }
    public boolean updateWithEmail(String email, String codigoRecuperacion){
        boolean flag = false;
        String query = "update users set cody = ? where email = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, codigoRecuperacion);
            ps.setString(2, email);
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return flag;
    }

    public User getOne(int id){
        User u = new User();
        // Los símbolos de ? son para evitar la inyección de código SQL
        String query = "select * from users where id = ?";

        try{
            //Conectarse a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Definir los parámetros del query (los símbolos de interrogación)
            ps.setInt(1,id);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                //El usuario si existe en la base de datos
                u.setId(rs.getInt("id"));
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setCody(rs.getString("cody"));
                u.setEstado(rs.getBoolean("status"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public Boolean getOne(String correo){
        Boolean flag = false;
        // Los símbolos de ? son para evitar la inyección de código SQL
        String query = "select * from users where email = ?";

        try{
            //Conectarse a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Definir los parámetros del query (los símbolos de interrogación)
            ps.setString(1,correo);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
    public Boolean codeExist(String codigo){
        Boolean flag = false;
        // Los símbolos de ? son para evitar la inyección de código SQL
        String query = "select * from users where cody = ?";

        try{
            //Conectarse a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Definir los parámetros del query (los símbolos de interrogación)
            ps.setString(1,codigo);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la información del ResultSet
            if(rs.next()){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
    public boolean updatePassword(String cody,String nuevaContra) {
        boolean flag = false;
        String query = "update users set pass = sha2(?, 256),cody = null where cody = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nuevaContra);
            ps.setString(2, cody);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }



}
