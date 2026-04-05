package controlador;

import modelo.beans.ListaSolicitudes;
import modelo.beans.Solicitud;
import modelo.procesos.VerificacionSolicitud;
import vista.UtilidadesES;

import java.io.*;

import static controlador.ColorTexto.*;

public class Programa {
    UtilidadesES utilES;
    VerificacionSolicitud verificacionSolicitud;

    public void ejecutar() throws IOException {

        utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        verificacionSolicitud= new VerificacionSolicitud();
        GestionRegistro gr= new GestionRegistro(utilES, verificacionSolicitud);
        File archivo;
        String nombreArchivo;


        nombreArchivo = gr.nombrarArchivo();
        archivo = new File(nombreArchivo);

        gr.leerarchivo(archivo);
        utilES.mostrarMensajeln("");
        gr.copiarRegistro();
    }


}

