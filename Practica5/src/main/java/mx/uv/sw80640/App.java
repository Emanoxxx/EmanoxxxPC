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
        port(2020);
        get("/", (req, res) -> "Hola desde Spark");//Primero es un path, y despues una expresion landa(funcion anonima con una peticion y una respuesta)
        get("/HOLA", (req, res) -> "JIJI desde Spark");
    }
}
