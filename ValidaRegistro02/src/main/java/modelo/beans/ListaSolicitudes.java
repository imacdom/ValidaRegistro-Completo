package modelo.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ListaSolicitudes {

    private final HashMap<String, Solicitud> listaSolicitudes;

    public ListaSolicitudes(){
        listaSolicitudes =new HashMap<String, Solicitud>();
    }


    public void putSolicitud(Solicitud solicitud){
        if(!listaSolicitudes.containsKey(solicitud.getLogin())){
            listaSolicitudes.put(solicitud.getLogin(), solicitud);
        }
        //No se ha utilizado .putIfAbsent() porque acepta logins nulos
    }

    public boolean loginDuplicado(Solicitud solicitud){
        return listaSolicitudes.containsKey(solicitud.getLogin());
    }

    public Collection<Solicitud> solicitudes(){
        return listaSolicitudes.values();
    }

}
