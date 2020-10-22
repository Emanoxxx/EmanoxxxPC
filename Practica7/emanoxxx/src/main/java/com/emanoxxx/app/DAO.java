package com.emanoxxx.app;

//import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class DAO {
    public static Conexion conn = new Conexion();
    public static void addUsuario(String id,String eml,String pass){
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        con = conn.getConexion();
        try {
            String sql="INSERT INTO usuarios VALUES('"+id+"','"+eml+"','"+pass+"')";
            stm=con.createStatement();
            stm.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                stm=null;
            }
            if(con!=null){
                try {
                    con.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                con=null;
                System.out.println("Conexion cerrada");
            }
        }

    }
    public static List<Usuarios> getUsuarios(){
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        con = conn.getConexion();
        try {
            String sql="SELECT * from usuarios";
            stm=con.createStatement();
            rs= stm.executeQuery(sql);
            int i=0;
            while(rs.next()){
                i++;
                Usuarios u= new Usuarios(rs.getString("id"),rs.getString("email"),rs.getString("password"));
                u.setEmail(rs.getString("email"));
                System.out.println(i+".- "+u.toString());
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                stm=null;
            }
            if(con!=null){
                try {
                    con.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                con=null;
                System.out.println("Conexion cerrada");
            }
        }
        return resultado;
    }
}
