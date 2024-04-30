package Modelos;

import Calculos.Calcula;
import com.google.gson.JsonObject;

public class Moneda {
    private String result;
    private String baseCode;
    private JsonObject conversionRates;

    public Moneda(String result, String baseCode, JsonObject conversionRates) {
        this.result = result;
        this.baseCode = baseCode;
        this.conversionRates = conversionRates;
    }

    public Moneda(MonedaExchange monedaExchange) {
        this.baseCode = monedaExchange.baseCode();
        this.conversionRates = monedaExchange.conversionRates();
    }

    public double EncuentraMoneda(String moneda) {
        return this.conversionRates.get(moneda).getAsDouble();
    }

    public double ObtenerMoneda(int valor, String moneda2) {
        double valorMoneda = this.EncuentraMoneda(moneda2);
        Calcula calcula = new Calcula();
        return calcula.CalculaMoneda(valor, valorMoneda);
    }

    public String toString() {
        String var10000 = this.baseCode;
        return "Moneda{base_code='" + var10000 + "', conversion_rates=" + String.valueOf(this.conversionRates) + "}";
    }
}
