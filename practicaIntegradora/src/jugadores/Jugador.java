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
public abstract class Jugador implements Comparable<Jugador> {

    /**
     * Dorsal del jugador
     */
    private int dorsal;
    /**
     * Nombre del jugador
     */
    private String nombre;
    /**
     * TipoEquipo del jugador
     */
    private TipoEquipo nombreEquipo;
    /**
     * Numero de goles del jugador
     */
    private int numGoles;
    
    /*
     * Constructor por defecto
     */
    public Jugador() {
    }
    
    /*
     * Constructor con 4 parametros
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @param TipoEquipo el tipo de equipo del jugador
     * @param numGoles goles del jugador
     */
    public Jugador(int dorsal, String nombre, TipoEquipo nombreEquipo) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.nombreEquipo = nombreEquipo;
        this.numGoles = numGoles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        dorsal = dorsal;
    }

    public TipoEquipo getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(TipoEquipo nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    public void contabilizarGol() {
    }

    public abstract int obtenerValoracion(); //Metodo privado  
    
     /*
     * Recorre el ArrayList y lo ordena de mayor a menor numero de goles.
     * @return Devuelte -1 si la primera posicion en mayor que la segunda
     * @return Devuelte  1 si la primera posicion en menor que la segunda
     * @return Devuelte  0 si no hay ninguna posicion que ordenar.
     */
    public int compareTo(Jugador j2) {  
        if (this.numGoles > j2.numGoles) {
            return -1;
        }
        if (this.numGoles < j2.numGoles) {
            return 1;
        }
    
        return 0;
    }    
    
    /*
    Devuelve los atributos del jugador
    */    
    public String toString() {
        return " El jugador " + this.nombre + " con dorsal " + this.dorsal + " juega en el equipo "
                + this.nombreEquipo + " y ha marcado un total de " + this.numGoles + " goles ";
    }
    

}
