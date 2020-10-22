package com.emanoxxx.app;

public class Usuarios {
    private String id;
    private String email;
    private String password;

    public Usuarios(String id, String nombre, String password) {
        this.setId(id);
        this.setEmail(email);
        this.setContrasena(password);
    }
    public String toString(){
        return "Usuario: "+email+"Password: "+ password;
    }
    public Usuarios( String email, String password) {
        this.id="";
        this.setEmail(email);
        this.setContrasena(password);
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
