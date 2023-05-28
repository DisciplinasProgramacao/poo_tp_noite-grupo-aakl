import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static LocalDate converteStringParaData(String dataString) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataString, formatador);
    }

    public static <T> T converterParaTipo(IStringConverter objeto, Class<T> tipo) {
        if (tipo.isAssignableFrom(objeto.getClass())) {
            return tipo.cast(objeto);
        } else {
            throw new IllegalArgumentException("O objeto não é compatível com o tipo desejado.");
        }
    }
}
