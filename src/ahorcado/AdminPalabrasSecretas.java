
package ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminPalabrasSecretas {
    private List<String> palabrasSecretas;
    private Random random;
    private String[] palabras;

    public AdminPalabrasSecretas() {
        palabrasSecretas = new ArrayList<>();
        random = new Random();
        agregarPalabra("pera");
        agregarPalabra("manzana");
        agregarPalabra("naranja");
        palabras = palabrasSecretas.toArray(new String[0]);
    }

    public void agregarPalabra(String palabra) {
        palabrasSecretas.add(palabra);
    }

    public String seleccionarPalabraAlAzar() {
        int indice = random.nextInt(palabrasSecretas.size());
        return palabrasSecretas.get(indice);
    }

    public String[] getPalabras() {
        return palabras;
    }
}



