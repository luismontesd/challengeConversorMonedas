package Datos;


public class DatosMoneda {
    String[] nombresPaises = new String[]{"United Arab Emirates", "Afghanistan", "Albania", "Armenia", "Netherlands Antilles", "Angola", "Argentina", "Australia", "Aruba", "Azerbaijan", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Bulgaria", "Bahrain", "Burundi", "Bermuda", "Brunei", "Bolivia", "Brazil"};
    String[] codigosMoneda = new String[]{"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL"};

    public DatosMoneda() {
    }

    public void MuestraPaises() {
        System.out.println("Seleccione un país:");

        for(int i = 0; i < this.nombresPaises.length; ++i) {
            System.out.println(i + 1 + ". " + this.nombresPaises[i]);
        }

    }

    public String RegresaMondeda(int opcion) {
        String aux = "";

        for(int i = 0; i < this.codigosMoneda.length; ++i) {
            if (i + 1 == opcion) {
                aux = this.codigosMoneda[i];
            }
        }

        return aux;
    }
}
