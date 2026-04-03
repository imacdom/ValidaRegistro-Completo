package modelo.beans;

import modelo.procesos.VerificacionSolicitud;

import java.util.HashMap;

public class ListaSolicitudes {

    private final HashMap<String, Solicitud> solicitudesValidas;

    public ListaSolicitudes(){
        solicitudesValidas=new HashMap<String, Solicitud>();
    }


    public void putSolicitud(Solicitud solicitud){
            solicitudesValidas.put(solicitud.getLogin(), solicitud);
    }

}
