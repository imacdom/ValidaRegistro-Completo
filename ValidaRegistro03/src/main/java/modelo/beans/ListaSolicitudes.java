package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ListaSolicitudes implements Serializable {

    private final HashMap<String, Solicitud> listaSolicitudes;

    public ListaSolicitudes(){
        listaSolicitudes =new HashMap<String, Solicitud>();
    }


    public void putSolicitud(Solicitud solicitud){
        if(!listaSolicitudes.containsKey(solicitud.getLogin())){
            listaSolicitudes.put(solicitud.getLogin(), solicitud);
        }
    }

    public boolean loginDuplicado(Solicitud solicitud){
        return listaSolicitudes.containsKey(solicitud.getLogin());
    }

    public Collection<Solicitud> solicitudes(){
        return listaSolicitudes.values();
    }

}
