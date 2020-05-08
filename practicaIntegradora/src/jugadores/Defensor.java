package jugadores;

public class Defensor extends JugadorCampo {

    /*
     * Constructor con 3 parametros y un parametro con una heredacion con super de Jugador
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @param TipoEquipo el tipo de equipo del jugador   
     */
    public Defensor(int dorsal, String nombre, TipoEquipo nombreEquipo) {
        super(dorsal, nombre, nombreEquipo);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    @Override
    public int obtenerValoracion() { //Sobreescritura del metodo abstracto obtenerValoracion

        int resultado;

        resultado = (getNumGoles() * 20) + (getPases() * 1) + (this.getBalonesRecuperados() * 4);
        return resultado;
    }

    /*
     * Imprime valores de la clase Defensor
     */
    public String toString() {
        return "Defensor: " + this.getDorsal() + " " + this.getNombre() + " (Atacante) Goles: " + this.getNumGoles() + " Pases: " + this.getPases() + " Recuperados: " + this.getBalonesRecuperados()
                + " Valoracion: " + obtenerValoracion();
    }

}
