let avatar = document.getElementById("avatar");
let dialogo = document.getElementById("btnDialogo");

let dialogos = [ "Bienvenido", "Wola como estais", "Quieres apostar?"];
let contador = 0;

avatar.onclick = function(){
    if(contador == dialogos.length){
        contador = 0;
    }
    dialogo.innerHTML = "<p id='dialogo'>"+ dialogos[contador] +"</p> " ;
    contador ++;


}