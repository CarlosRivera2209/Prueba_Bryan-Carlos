package ahorcado;

import java.util.Random;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    private AdminPalabrasSecretas adminPalabrasSecretas;
    private String[] palabrasPosibles;
    private Random random;

    public JuegoAhorcadoAzar(AdminPalabrasSecretas adminPalabrasSecretas) {
        this.adminPalabrasSecretas = adminPalabrasSecretas;
        this.palabraSecreta = adminPalabrasSecretas.seleccionarPalabraAlAzar();
        this.palabraActual = generarPalabraActual(this.palabraSecreta);
        
    }

    public JuegoAhorcadoAzar(String[] palabrasPosibles) {
        this.palabrasPosibles = palabrasPosibles;
        this.random = new Random();
        seleccionarPalabraSecreta();
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 6;

    }

    private void seleccionarPalabraSecreta() {
        int indice = random.nextInt(palabrasPosibles.length);
        palabraSecreta = palabrasPosibles[indice];
    }

    public void actualizarPalabraActual(char letra) {
        StringBuilder sb = new StringBuilder(palabraActual);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                sb.setCharAt(i, letra);
            }
        }
        palabraActual = sb.toString();
    }

    public boolean verificarLetra(char letra) {
        return palabraSecreta.contains(String.valueOf(letra));
    }

    public boolean hasGanado() {
        return palabraSecreta.equals(palabraActual);
    }

    private String generarPalabraActual(String palabraSecreta) {
        StringBuilder palabraActual = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual.append("_");
        }
        return palabraActual.toString();
    }

}
