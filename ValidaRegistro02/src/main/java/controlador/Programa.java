package controlador;

import modelo.beans.ListaSolicitudes;
import modelo.beans.Solicitud;
import modelo.procesos.VerificacionSolicitud;
import vista.UtilidadesES;

import java.io.*;

import static controlador.ColorTexto.*;

public class Programa {
    UtilidadesES utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
    VerificacionSolicitud  verificacionSolicitud= new VerificacionSolicitud();
    GestionRegistro gr= new GestionRegistro(utilES, verificacionSolicitud);

    public void ejecutar() throws IOException {


        File archivo;
        String nombreArchivo;
        utilES.mostrarMensajeln("---LEER REGISTRO---");
        do {
            nombreArchivo = gr.nombrarArchivo();
            archivo = new File(nombreArchivo);
            if(!archivo.exists()){
                utilES.mostrarMensajeln("El archivo no exite o no contiene registros.");
            }
        }while(!archivo.exists());
        gr.leerarchivo(archivo);

        utilES.mostrarMensajeln("\n---COPIAR REGISTRO---");

        nombreArchivo = gr.nombrarArchivo();
        archivo = new File(nombreArchivo);

        gr.copiarRegistro(archivo);
    }



}

