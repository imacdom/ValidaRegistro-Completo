package modelo.procesos;

import modelo.beans.Solicitud;

public class VerificacionSolicitud {
    private final int caracteresMinimos =5;


    public  boolean verificarSolicitud(Solicitud solicitud) {
        if (validaCampo(solicitud.getLogin()) &&
            validaCampo(solicitud.getClave()) &&
            validaEmail(solicitud.getEmail()) &&
            validaCampo(solicitud.getNombreApellidos())) {
            return true;
        }else{
            return false;
        }
    }


    private boolean validaEmail(String email){
        int numRepeticiones=0;
        if(validaCampo(email)) {
            numRepeticiones = contarCaracter(email, '@');
        }
        return numRepeticiones == 1;
    }

    private boolean validaCampo(String cadena){
        return cadena.length() >= caracteresMinimos;
    }

    public int contarCaracter(String cadena, char caracterBuscado){
        int contador=0;

        for(int i=0; i<cadena.length();i++){

            if(cadena.charAt(i)==caracterBuscado){
                contador++;
            }
        }
        return contador;
    }

    public int getCaracteresMinimos(){
        return caracteresMinimos;
    }
}
