package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class UtilidadesES {
    private final BufferedReader flujoEntrada;
    private final PrintStream flujoSalida;

    public UtilidadesES(BufferedReader flujoEntrada, PrintStream flujoSalida){
        this.flujoEntrada=flujoEntrada;
        this.flujoSalida=flujoSalida;
    }

    public void mostrarMensaje(String mensaje){
        flujoSalida.print(mensaje);
    }

    public void mostrarMensajeln(String mensaje){
        flujoSalida.println(mensaje);
    }

    public String pedirCadena(String mensaje) throws IOException {
        String lectura;
        mostrarMensaje(mensaje);
        try{
            lectura= flujoEntrada.readLine();

        } catch (IOException e) {
            throw new IOException("Error al leer cadena");
        }
        return lectura;
    }


    public int pedirNumero(String mensaje) throws IOException {
        int lectura;
        mostrarMensaje(mensaje);
        try{
            lectura= Integer.parseInt(flujoEntrada.readLine());

        } catch (IOException e) {
            throw new IOException("Error al leer entero");
        }
        return lectura;
    }

}
