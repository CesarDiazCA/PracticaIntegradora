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
public abstract class JugadorCampo extends Jugador {

    /**
     * Pases del jugador
     */
    private int pases;

    /**
     * BaloresRecuperados del jugador
     */
    private int balonesRecuperados;

    /*
     * Constructor con 2 parametros y un parametro con una heredacion con super de Jugador
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @param TipoEquipo el tipo de equipo del jugador
     * @param pases del jugador
     * @param balonesRecuperados del jugador
     */
    public JugadorCampo(int dorsal, String nombre, TipoEquipo nombreEquipo) {
        super(dorsal, nombre, nombreEquipo);
        this.pases = pases;
        this.balonesRecuperados = balonesRecuperados;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getBalonesRecuperados() {
        return balonesRecuperados;
    }

    public void setBalonesRecuperados(int recuperados) {
        this.balonesRecuperados = balonesRecuperados;
    }

    public void contabilizarPase() {
        this.pases = this.pases + 1;
    }

    public int contabilizarRecuperado() {
        return this.balonesRecuperados = this.balonesRecuperados + 1;
    }

    public abstract int obtenerValoracion(); //Metodo abstracto

    /*
     * Imprime los atributos del jugadorCampo
     */
    public String toString() {
        return "El jugador de campo " + this.getNombre() + "con dorsal " + this.getDorsal() + " y en el equipo " + this.getNombreEquipo() + ", con numero de pases" + this.getPases()
                + " y ha recuperado " + this.getBalonesRecuperados();
    }

}
