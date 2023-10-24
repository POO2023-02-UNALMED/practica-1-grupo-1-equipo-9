package gestorAplicacion.campeonato;
import java.text.DecimalFormat;

public interface Decimales {

    default double dosDecimales(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
    void redondear();

    static double dosDecimalesP(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
