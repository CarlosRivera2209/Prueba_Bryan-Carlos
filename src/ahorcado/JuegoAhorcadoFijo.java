package ahorcado;

public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {

    private String[] palabrasDisponibles;

    public JuegoAhorcadoFijo(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 6;
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

    void setPalabrasDisponibles(String[] palabras) {
        this.palabrasDisponibles = palabras;
    }
}
