import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorCSV {
    
    public static Map<Integer, IStringConverter> lerCSV(IStringConverter dado, String arquivoCSV) {
        String line;
        Map<Integer, IStringConverter> dadosMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((line = br.readLine()) != null) {
                IStringConverter objeto = dado.converterToObject(line); 
                ;
                dadosMap.put(objeto.getChave(), objeto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dadosMap;
    }    

    public static Map<Integer, List<IStringConverter>> lerCSVMultiplasChaves(IStringConverter dado, String arquivoCSV) {
        String line;
        Map<Integer, List<IStringConverter>> dadosMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((line = br.readLine()) != null) {
                IStringConverter objeto = dado.converterToObject(line);
                if(dadosMap.containsKey(objeto.getChave())){
                    dadosMap.get(objeto.getChave()).add(objeto);
                }
                else{
                    List<IStringConverter> valoresList = new ArrayList<>(100);
                    valoresList.add(objeto);
                    dadosMap.put(objeto.getChave(), valoresList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dadosMap;
    }    
}
