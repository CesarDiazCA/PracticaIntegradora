/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

/**
 *
 * @author Cesar
 */
public class Portero extends Jugador {

    private int paradas;

    /*
     * Constructor con 3 parametros 
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @param TipoEquipo el tipo de equipo del jugador    
     */
    public Portero(int dorsal, String nombre, TipoEquipo nombreEquipo) {
        super(dorsal, nombre, nombreEquipo);
    }

    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        this.paradas = paradas;
    }

    public int contabilizarParada() {
        return this.paradas = this.paradas + 1;
    }

    @Override
    public int obtenerValoracion() { //Valoracion del portero
        int resultado;

        resultado = (getNumGoles() * 10) + (getParadas() * 5);
        return resultado;
    }

    public String toString() {

        return "Portero: " + this.getDorsal() + " " + this.getNombre() + " (Portero) Goles: " + this.getNumGoles() + " Paradas: " + this.getParadas() + " Valoracion: " + this.obtenerValoracion();
    }
    // Metodo to String que nos imprimirá los valores que nos pide la práctica
}
