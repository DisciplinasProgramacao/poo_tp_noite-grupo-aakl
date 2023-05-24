import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {

    public static void lerArquivo(String arquivoCSV) {
        String line;
        String csvDelimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvDelimiter);
     
                for (String value : data) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
