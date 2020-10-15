package mx.uv.sw80640;
import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
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

        
        get("/", (req, res) -> "Hola desde Spark");//Primero es un path, 
        //y despues una expresion landa(funcion anonima con una peticion 
        //y una respuesta)
        get("/si",(request,response)->{
            String psw= ""+request.queryParams("pass");
            String eml= ""+request.queryParams("email");
            return "Hola "+eml+" tu pass es: "+psw+"\n";
        });
        post("/adios",(request,response)->{
            String psw= ""+request.queryParams("pass");
            String eml= ""+request.queryParams("email");
            
            return "Hola "+eml+" tu pass es: "+psw+"\n"+request.contextPath();
        });
}}
