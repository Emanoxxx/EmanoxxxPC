package com.emanoxxx.app;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson=new Gson();
    private static Map<String, Usuarios> usuariosm =new HashMap<>();
        public static void main( String[] args )
    {
        port(2021);
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // no deberia afectar
        before((req, res) -> res.type("application/json"));
        get("/usuarios",(req,res)->gson.toJson(usuariosm.values()));
        post("/usuarios",(req,res)->{
            String query = req.body();
           // try{
            System.out.println("1Peticion: "+query);
            Usuarios usuario=gson.fromJson(query,Usuarios.class);
            System.out.println(usuario.toString());
            String id=UUID.randomUUID().toString();
            usuario.setId(id);
            usuariosm.put(id, usuario);
            return "Se creo Usuario: "+id;
          /*  }catch(Exception e){
                System.out.println("No se pudo crear Excepcion: "+e.getMessage());
                return "No se pudo crear Excepcion: "+e.getMessage();
            }*/
        });
        
    }
}
