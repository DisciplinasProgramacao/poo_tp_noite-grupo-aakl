import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorCSV <T extends IStringConverter>{
    private static String line;
    
    public Map<String, T> lerCSV(IStringConverter dado, String arquivoCSV) {
        Map<String, T> dadosMap = new HashMap<>(1000000);
        try (BufferedReader buffer = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((line = buffer.readLine()) != null) {
                IStringConverter objeto = dado.converterToObject(line); 
                dadosMap.put(objeto.getChave(), (T) Utils.converterParaTipo(objeto, dado.getClass()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dadosMap;
    }    

    public static List<String> lerCSV(String arquivoCSV) {
        List<String> dadosList = new ArrayList<>(1000000);
        try (BufferedReader buffer = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((line = buffer.readLine()) != null) {
                dadosList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dadosList;
    }    
}
