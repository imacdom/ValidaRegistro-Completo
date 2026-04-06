package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ListaSolicitudes implements Serializable, Iterable<Solicitud>{

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

    public Iterator<Solicitud> iterator() {
        return listaSolicitudes.values().iterator();
    }

}
