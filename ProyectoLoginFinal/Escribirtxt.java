import java.io.*;

public class Escribirtxt {

    public static void escribir(String ingreso) {
        String nombreArchivo = "login.log";
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(ingreso);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
