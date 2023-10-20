package gestorAplicacion.campeonato;
import java.text.DecimalFormat;

public interface Decimales {

    default double dosDecimales(double valor) {
        DecimalFormat formatoDecimal = new DecimalFormat("#.00");
        String valorFormateado = formatoDecimal.format(valor);

        // Parseamos el valor formateado de vuelta a un double
        double valorRedondeado = Double.parseDouble(valorFormateado);

        return valorRedondeado;
    }
    void redondear();


    static double dosDecimalesP(double valor) {
        DecimalFormat formatoDecimal = new DecimalFormat("#.00");
        String valorFormateado = formatoDecimal.format(valor);

        // Parseamos el valor formateado de vuelta a un double
        double valorRedondeado = Double.parseDouble(valorFormateado);

        return valorRedondeado;
    }
}
