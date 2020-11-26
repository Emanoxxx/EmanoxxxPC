var bLogeo = document.getElementById("acceso");
bLogeo.addEventListener('click',function(){
            var psw= document.getElementById('psw').value;
            var eml= document.getElementById('eml').value;
            const parametros = new URLSearchParams();
            parametros.append('email',eml);
            parametros.append('pass',psw);
            axios.post("http://localhost:2021/Addusuarios",{
                email: document.getElementById('eml').value, 
                password: document.getElementById('psw').value,
                op: operacion
                })
            .then(function(response){
                    console.log(response);
                    console.log("contenido: " + response.data);
                    console.log("status: " + response.status);
                    //document.getElementById("titulo").innerHTML = response.data;
            }).catch(function(error){
                console.log(error);
            });
             
            });
    
           

    
