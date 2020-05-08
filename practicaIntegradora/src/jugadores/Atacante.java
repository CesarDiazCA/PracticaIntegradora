package jugadores;

public class Atacante extends JugadorCampo {
    
     /*
     * Constructor con 3 parametros y un parametro con una heredacion con super de Jugador
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @param TipoEquipo el tipo de equipo del jugador     
     */   
    public Atacante(int dorsal, String nombre, TipoEquipo nombreEquipo) {
        super(dorsal, nombre, nombreEquipo);

        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    @Override
    public int obtenerValoracion() { //Valoracion del atacante

        int resultado;

        resultado = (getNumGoles() * 30) + (getPases() * 1) + (this.getBalonesRecuperados() * 3);
        return resultado;
    }

    public String toString() {
        return "Atacante: " + this.getDorsal() + " " + this.getNombre() + " (Atacante) Goles: " + this.getNumGoles() + " Pases: " + this.getPases() + " Recuperados: " + this.getBalonesRecuperados()
                + " Valoracion: " + obtenerValoracion();
    }
    
    //Imprime valores del atacante la clase toString

}
