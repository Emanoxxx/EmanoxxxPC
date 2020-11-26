package mx.uv.sw80640;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        port(2020);
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

        
        get("/", (req, res) -> "Hola desde Spark");//Primero es un path, 
        //y despues una expresion landa(funcion anonima con una peticion 
        //y una respuesta)
        get("/si",(request,response)->{
            String psw= ""+request.queryParams("pass");
            String eml= ""+request.queryParams("email");
            return "Hola "+eml+" tu pass es: "+psw+"\n";
        });
        post("/adiosJson",(request,response)-> {
            try{
             JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String psw= ""+peticion.get("pass");
           String eml= ""+peticion.get("email");
           return "Hola "+eml+" tu pass es: "+psw+"\n";
            }catch(Exception e){
                return e.getMessage();
            }
           
            
            
        });
}}
