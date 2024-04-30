package Principal;
import Datos.DatosMoneda;
import Modelos.Moneda;
import Modelos.MonedaExchange;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class Principal {
    public Principal() {
    }

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Gson gson = (new GsonBuilder()).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();

        while(true) {
            System.out.println("**********************************************************");
            System.out.println("Sea bienvenido/a al Conversor de monedas");
            DatosMoneda Datomoneda = new DatosMoneda();
            Datomoneda.MuestraPaises();
            System.out.println("21. Salir");
            int opcionMoneda = Integer.parseInt(lectura.nextLine());
            String moneda1 = Datomoneda.RegresaMondeda(opcionMoneda);
            if (opcionMoneda == 21) {
                return;
            }

            System.out.println("Ingresa el número de la moneda a la que desea convertir: ");
            Datomoneda.MuestraPaises();
            String moneda2 = Datomoneda.RegresaMondeda(Integer.parseInt(lectura.nextLine()));
            System.out.println("Ingrese el número de unidades que desea convertir: ");
            int valorConvertir = Integer.parseInt(lectura.nextLine());
            String direccion = "https://v6.exchangerate-api.com/v6/2d51ced1f65b8310e86e3708/latest/" + moneda1;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                String json = (String)response.body();
                MonedaExchange monedaExchange = (MonedaExchange)gson.fromJson(json, MonedaExchange.class);
                Moneda miMoneda = new Moneda(monedaExchange);
                System.out.println("El valor de " + valorConvertir + " [" + moneda1 + "] a " + moneda2 + " es: " + miMoneda.ObtenerMoneda(valorConvertir, moneda2));
                System.out.println("Presiona ENTER para continuar");
                lectura.nextLine();
            } catch (Exception var15) {
                Exception e = var15;
                System.out.println("Error generico: " + e.getMessage());
            }
        }
    }
}
