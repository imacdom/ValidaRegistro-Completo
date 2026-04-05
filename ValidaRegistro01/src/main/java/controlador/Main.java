package controlador;

public class Main {
    public static void main(){
        try {
            Programa programa= new Programa();
            programa.ejecutar();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
