import java.time.*;

public class InicioAdmin {

    public static void saludar(String usuario){
        String ingreso = LocalDate.now()+"-"+LocalTime.now()+"-"+usuario;
        Escribirtxt.escribir(ingreso);
    }
}
