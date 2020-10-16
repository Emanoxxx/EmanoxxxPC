var bLogeo = document.getElementById("acceso");
bLogeo.addEventListener('click',function(){
    var psw= document.getElementById('psw').value;
    var eml= document.getElementById('eml').value;
    const parametros = new URLSearchParams();
    parametros.append('email',eml);
    parametros.append('pass',psw);
    axios.post('http://localhost:2021/adiosJson',parametros)
    console.log(response);
            });
    
           /* axios.post('http://localhost:2020/adios'+'?'+parametros)
            .then(function(response){
            console.log(response);
            var mensaje=document.getElementById('mensaje');
            mensaje.innerHTML=response.data;
            }).catch(function(error){
                console.log(error);
            });*/
            /*axios.get('http://localhost:2020/si'+'?'+parametros)
            .then(function(response){
            console.log(response);
            alert(response.data+eml+"tu contraseña es "+psw);
            var mensaje=document.getElementById('mensaje');
            mensaje.innerHTML=response.data;
            }).catch(function(error){
                console.log(error);
            });
 */

    
