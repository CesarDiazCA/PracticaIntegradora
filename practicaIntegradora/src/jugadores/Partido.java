/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Cesar
 */
public class Partido {  //Implementacion de todos los métodos que mite la práctica

    Scanner teclado = new Scanner(System.in);

    private Jugador equipoLocal[];  //Array para equipoLocal
    private ArrayList<Jugador> equipoVisitante;

    /*
     * Constructor con 2 parametros
     * @param equipoLocal Array donde se van a guardar los jugadores del equipo Local.
     * @param quipoVisitante ArrayList donde se van a guardar los jugadores del equipo Visitante.       
     */
    public Partido() {
        equipoLocal = new Jugador[10];
        equipoVisitante = new ArrayList<>();
    }

    /* Método que devuelve un booleano (Comprueba dorsal == true o false) existentes en la serie de Arrays
     * @return El valor booleano (Comprueba dorsal == true o false) de que consta la serie
       @param  Donde vemos que el metodo recibe dos parametros para su uso y comprobacion.
     */
    public boolean dorsalValido(int dorsal, String equipo) {

        if (dorsal < 1 || dorsal > 30) {
            System.out.println("Dorsal fuera de rango");
            return false;
        }

        if (equipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null) {
                    if (dorsal == equipoLocal[i].getDorsal()) {
                        System.out.println("Dorsal repetido");
                        return false;
                    }

                }
            }
        }

        if (equipo.equalsIgnoreCase("VISITANTE")) {
            if (equipoVisitante.isEmpty()) {
                return true;
            } else {
                for (Jugador j : this.equipoVisitante) {
                    if (j.getDorsal() == dorsal) {
                        System.out.println("Dorsal repetido");
                        return false;
                    }
                }
            }
        }
        return true;
    } //Cierre del metodo

    /* Método que devuelve un booleano (Comprueba TipoEquipo == true o false) existentes de lo que elige el usuario
     * @return El valor booleano (Comprueba TipoEquipo == true o false) de que consta el Scanner
       @param Donde el metodo tiene como parametro un String.
     */
    public static boolean equipoCorrecto(String equipo) {

        if (equipo.equalsIgnoreCase("LOCAL")) {
            return true;
        }

        if (equipo.equalsIgnoreCase("VISITANTE")) {
            return true;
        }

        return false;
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo añade un jugador al Array si lo llamas    
       @param Donde el metodo tiene como parametro un String.
     */
    private void añadirJugadorLocal(Jugador j1) {

        // ese jjugador cumpla las condiciones para que se añada
        for (int i = 0; i < equipoLocal.length; i++) {
            if (equipoLocal[i] == null) {
                equipoLocal[i] = j1;
                break;
            }
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo añade un jugador al ArrayList si lo llamas    
     */
    private void añadirJugadorVisitante(Jugador j1) {

        if (!this.equipoVisitante.contains(j1)) {
            this.equipoVisitante.add(j1);
        } else {
            System.out.println("Jugador no añadido, esta repetido.");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo añade un jugador Atacante al ArrayList o Array.
    Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     *@Exception Añadimos una excepcion para que si introduce mal Local o Visitante, lo vuelva a pedir.
     */
    public void añadirJugadorAtacante() throws Exception {

        System.out.println("Introduzca nombre");
        String nombre = teclado.next();

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        try {
            while (!equipoCorrecto(nombreEquipo)) {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        while (dorsalValido(dorsal, nombreEquipo) == false) {
            System.out.println("Introduzca Dorsal [1,30]");
            dorsal = teclado.nextInt();
        }

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) { // Equipo valido
            Jugador jugador = new Atacante(dorsal, nombre, TipoEquipo.LOCAL);
            añadirJugadorLocal(jugador);
            System.out.println("Jugador Local añadido correctamente");
        } else {
            Jugador jugador = new Atacante(dorsal, nombre, TipoEquipo.VISITANTE);
            añadirJugadorVisitante(jugador);
            System.out.println("Jugador Visitante añadido correctamente");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo añade un jugador Defensor al ArrayList o Array.
    Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     */
    public void añadirJugadorDefensor() {

        System.out.println("Introduzca nombre");
        String nombre = teclado.next();

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        while (dorsalValido(dorsal, nombreEquipo) == false) {
            System.out.println("Introduzca Dorsal [1,30]");
            dorsal = teclado.nextInt();
        }

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) { // Equipo valido
            Jugador jugador = new Defensor(dorsal, nombre, TipoEquipo.LOCAL);
            añadirJugadorLocal(jugador);
            System.out.println("Jugador Local añadido correctamente");
        } else {
            Jugador jugador = new Defensor(dorsal, nombre, TipoEquipo.VISITANTE);
            añadirJugadorVisitante(jugador);
            System.out.println("Jugador Visitante añadido correctamente");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo añade un jugador Portero al ArrayList o Array.
    Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     */
    public void añadirJugadorPortero() {

        System.out.println("Introduzca nombre");
        String nombre = teclado.next();

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        while (dorsalValido(dorsal, nombreEquipo) == false) {
            System.out.println("Introduzca Dorsal [1,30]");
            dorsal = teclado.nextInt();
        }

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) { // Equipo valido
            Jugador jugador = new Portero(dorsal, nombre, TipoEquipo.LOCAL);
            añadirJugadorLocal(jugador);
            System.out.println("Jugador Local añadido correctamente");
        } else {
            Jugador jugador = new Portero(dorsal, nombre, TipoEquipo.VISITANTE);
            añadirJugadorVisitante(jugador);
            System.out.println("Jugador Visitante añadido correctamente");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo añade un gol al objeto que creamos al ArrayList o Array.
    Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante y se le suma 1 gol.
     */
    public void contabilizarGol() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        boolean dorsalEncontrado = false;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) { //Recorremo el array y comprobamos que no este vacio.
                if (equipoLocal[i] != null) {
                    if (dorsal == equipoLocal[i].getDorsal()) {
                        equipoLocal[i].setNumGoles(equipoLocal[i].getNumGoles() + 1);
                        System.out.println("Gol añadido");
                        dorsalEncontrado = true;
                    }
                }
            }
        } else {
            for (int i = 0; i < equipoVisitante.size(); i++) {
                if (!equipoVisitante.isEmpty()) { //Recorremos el arrayList y comprobamos que no este vacio.
                    if (dorsal == equipoVisitante.get(i).getDorsal()) {
                        equipoVisitante.get(i).setNumGoles(equipoVisitante.get(i).getNumGoles() + 1);
                        System.out.println("Gol añadido");
                        dorsalEncontrado = true;
                    }
                }
            }
        }

        if (dorsalEncontrado == false) {
            System.out.println("Dorsal no encontrado.");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo contabiliza los pases del objeto que creamos al ArrayList o Array.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante y se le suma 1 pase.
     */
    public void contabilizarPases() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        boolean dorsalEncontrado = false;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null) {
                    if (dorsal == equipoLocal[i].getDorsal()) {

                        if (equipoLocal[i] instanceof JugadorCampo) {

                            if (equipoLocal[i] instanceof Atacante) {  //Usamos el instanceOf para decirle que el objeto que hay en el Array, lo compare con un Atacante.
                                Atacante c1 = (Atacante) equipoLocal[i]; //Creo el Atacante para poder acceder a sus atributos, ya que Atacante es una clsae abstracta.
                                c1.contabilizarPase();
                                System.out.println("Pase añadido a " + equipoLocal[i]);
                                dorsalEncontrado = true;

                            } else if (equipoLocal[i] instanceof Defensor) { //Usamos el instanceOf para decirle que el objeto que hay en el Array, lo compare con un Defensor.
                                Defensor d1 = (Defensor) equipoLocal[i];  //Creo el Atacante para poder acceder a sus atributos, ya que Atacante es una clsae abstracta.
                                d1.contabilizarPase();
                                System.out.println("Pase añadido a " + equipoLocal[i]);
                                dorsalEncontrado = true;

                            }
                        }

                    }

                }
            }

        } else {
            for (int i = 0; i < equipoVisitante.size(); i++) {
                if (!equipoVisitante.isEmpty()) {
                    if (dorsal == equipoVisitante.get(i).getDorsal()) {

                        if (equipoVisitante.get(i) instanceof JugadorCampo) {

                            if (equipoVisitante.get(i) instanceof Atacante) {    //Usamos el instanceOf para decirle que el objeto que hay en el Array, lo compare con un Atacante.
                                Atacante c1 = (Atacante) equipoVisitante.get(i);  //Creo el Atacante para poder acceder a sus atributos, ya que Atacante es una clsae abstracta.
                                c1.contabilizarPase();
                                System.out.println("Pase añadido a " + equipoVisitante.get(i));
                                dorsalEncontrado = true;

                            } else if (equipoVisitante.get(i) instanceof Defensor) {  //Usamos el instanceOf para decirle que el objeto que hay en el Array, lo compare con un Defensor.
                                Defensor d1 = (Defensor) equipoVisitante.get(i);  //Creo el Atacante para poder acceder a sus atributos, ya que Defensor es una clsae abstracta.
                                d1.contabilizarPase();
                                System.out.println("Pase añadido a " + equipoVisitante.get(i));
                                dorsalEncontrado = true;
                            }
                        }

                    }
                }
            }
        }

        if (dorsalEncontrado == false) {
            System.out.println("Dorsal no encontrado.");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo contabiliza las recuperaciones del objeto que creamos al ArrayList o Array.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante y se le suma 1 recuperacion
     */
    public void contabilizarRecuperacion() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        boolean dorsalEncontrado = false;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null) {
                    if (dorsal == equipoLocal[i].getDorsal()) {

                        if (equipoLocal[i] instanceof JugadorCampo) {

                            if (equipoLocal[i] instanceof Atacante) {
                                Atacante c1 = (Atacante) equipoLocal[i];
                                c1.contabilizarRecuperado();
                                System.out.println("Pase añadido a " + equipoLocal[i]);
                                dorsalEncontrado = true;

                            } else if (equipoLocal[i] instanceof Defensor) {
                                Defensor d1 = (Defensor) equipoLocal[i];
                                d1.contabilizarRecuperado();
                                System.out.println("Pase añadido a " + equipoLocal[i]);
                                dorsalEncontrado = true;

                            }
                        }

                    }

                }
            }

        } else {
            for (int i = 0; i < equipoVisitante.size(); i++) {
                if (!equipoVisitante.isEmpty()) {
                    if (dorsal == equipoVisitante.get(i).getDorsal()) {

                        if (equipoVisitante.get(i) instanceof JugadorCampo) {

                            if (equipoVisitante.get(i) instanceof Atacante) {
                                Atacante c1 = (Atacante) equipoVisitante.get(i);
                                c1.contabilizarRecuperado();
                                System.out.println("Recuperacion añadida a " + equipoVisitante.get(i));
                                dorsalEncontrado = true;

                            } else if (equipoVisitante.get(i) instanceof Defensor) {
                                Defensor d1 = (Defensor) equipoVisitante.get(i);
                                d1.contabilizarRecuperado();
                                System.out.println("Recuperacion añadida a " + equipoVisitante.get(i));
                                dorsalEncontrado = true;
                            }
                        }

                    }
                }
            }
        }

        if (dorsalEncontrado == false) {
            System.out.println("Dorsal no encontrado.");
        }

    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo contabiliza las paradas del objeto que creamos al ArrayList o Array.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante y se le suma 1 parada.
     */
    public void contabilizarParada() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        boolean dorsalEncontrado = false;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null) {
                    if (dorsal == equipoLocal[i].getDorsal()) {

                        if (equipoLocal[i] instanceof Portero) {
                            Portero p = (Portero) equipoLocal[i];
                            p.contabilizarParada();
                            System.out.println("Parada añadida a " + equipoLocal[i]);
                            dorsalEncontrado = true;
                        }
                    }

                }
            }

        } else {
            for (int i = 0; i < equipoVisitante.size(); i++) {
                if (!equipoVisitante.isEmpty()) {
                    if (dorsal == equipoVisitante.get(i).getDorsal()) {

                        if (equipoVisitante.get(i) instanceof Portero) {
                            Portero p = (Portero) equipoVisitante.get(i);
                            p.contabilizarParada();
                            System.out.println("Parada añadida a " + equipoVisitante.get(i));
                            dorsalEncontrado = true;

                        }

                    }
                }
            }
        }

        if (dorsalEncontrado == false) {
            System.out.println("Dorsal no encontrado.");
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo muestra por pantalla el jugador/objeto que se le pasa como parametro.
     * Dependiendo si el dorsal encontrado está o no en el Array, lo imprimirá. 
     * @param Se le pasa un parametro entero para comprobar si ese entero está en el Array.
     */
    public void mostrarJLocal(int dorsal) {
        boolean encontrado = false;
        for (int i = 0; i < equipoLocal.length; i++) {
            if (equipoLocal[i] != null && equipoLocal[i].getDorsal() == dorsal) {
                System.out.print(equipoLocal[i].toString() + "\n");
                encontrado = true;
            }
        }

        if (encontrado == false) {
            System.out.println("No se ha encontrado ningun jugador con el dorsal " + dorsal);
        }

    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo muestra por pantalla el jugador/objeto que se le pasa como parametro.
     * Dependiendo si el dorsal encontrado está o no en el Array, lo imprimirá. 
     * @param Se le pasa un parametro entero para comprobar si ese entero está en el Array.
     */
    public void mostrarJVisitante(int dorsal) {
        boolean encontrado = false;

        Iterator<Jugador> it = equipoVisitante.iterator();

        while (it.hasNext() && it.next().getDorsal() == dorsal) {
            System.out.print(it.next().toString() + "\n");
            encontrado = true;
        }

        if (encontrado == false) {
            System.out.println("No se ha encontrado ningun jugador con el dorsal " + dorsal);
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo muestra los jugadores que hay en elArrayList o Array.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     */
    public void mostrarDatosJugador() {

        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        while (dorsal < 1 || dorsal > 30) {
            System.out.println("Introduzca Dorsal [1,30]");
            dorsal = teclado.nextInt();
        }

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            mostrarJLocal(dorsal);
        } else if (nombreEquipo.equalsIgnoreCase("VISITANTE")) {
            mostrarJVisitante(dorsal);
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo elimina un jugador que hace referencia con el dorsal que el usuario pone en el Scanner.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante y sel dorsal coincide, se borra el objeto del Array o ArrayList.
     */
    public void eliminarJugador() {
        System.out.println("Introduzca numero de Dorsal entre [1-30]");
        int dorsal = teclado.nextInt();

        while (dorsal < 1 || dorsal > 30) {
            System.out.println("Introduzca Dorsal [1,30]");
            dorsal = teclado.nextInt();
        }

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        boolean encontrado = false;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {

            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null && equipoLocal[i].getDorsal() == dorsal) {
                    equipoLocal[i] = null;
                    encontrado = true;
                }
            }
        } else if (nombreEquipo.equalsIgnoreCase("VISITANTE")) {
            Iterator<Jugador> it = equipoVisitante.iterator();

            while (it.hasNext() && it.next().getDorsal() == dorsal) {
                equipoVisitante.remove(it.next());
                encontrado = true;
            }
        }

        if (encontrado == false) {
            System.out.println("No se ha encontrado el jugador para eliminarlo.");
        } else {
            System.out.println("Se ha eliminado al jugador con dorsal " + dorsal);
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo muestra/imprime la alineacion, tanto Local como Visitante.     
     */
    public void mostrarAlineacionLyV() {

        System.out.print(" ----- Equipo LOCAL ----- \n");
        for (int i = 0; i < equipoLocal.length; i++) {
            if (equipoLocal[i] != null) {
                System.out.print(equipoLocal[i].toString() + "\n");
            }
        }
        System.out.println("");

        System.out.print("\n ----- Equipo VISITANTE ----- \n");
        Iterator<Jugador> it = equipoVisitante.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().toString() + "\n");
        }

        System.out.println("");
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo calcula el total de goles que han marcado los jugadores de ambos equipos y lo imprime.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     */
    public void calcularTotalGoles() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        int contador = 0;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null) {
                    contador = contador + equipoLocal[i].getNumGoles();
                }
            }

            System.out.println("Nº TOTAL DE GOLES (LOCAL): " + contador);

        } else if (nombreEquipo.equalsIgnoreCase("VISITANTE")) {
            Iterator<Jugador> it = equipoVisitante.iterator(); //Creamos un iterador, como bien nos indica en la práctica, para el uso de recorrer ArrayList. 
            while (it.hasNext()) {
                contador = contador + it.next().getNumGoles();
            }
            System.out.println("Nº TOTAL DE GOLES (VISITANTE): " + contador);
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo calcula la media de pases dados por los jugadores, tanto Locales como Visitantes.
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     * @exception exceptions Ningún error (Excepción) definida ArtichmeticException
     */
    public void mediaDePases() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        int contador = 0;
        int totalPases = 0;

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {
            for (int i = 0; i < equipoLocal.length; i++) {
                if (equipoLocal[i] != null) {

                    if (equipoLocal[i] instanceof JugadorCampo) {
                        if (equipoLocal[i] instanceof Atacante) {
                            Atacante a = (Atacante) equipoLocal[i]; //Casteamos a Atacante para dar a entender al código, que este es un objeto de tipo Atacante si o si.
                            contador = contador + a.getPases();
                            totalPases++;
                        } else if (equipoLocal[i] instanceof Defensor) {
                            Defensor d = (Defensor) equipoLocal[i]; //Casteamos a Defensor para dar a entender al código, que este es un objeto de tipo Defensor si o si.
                            contador = contador + d.getPases();
                            totalPases++;
                        }
                    }
                }
            }

            try {
                System.out.println("MEDIA DE PASES (LOCAL): " + contador / totalPases);
            } catch (ArithmeticException ex) {  //La excepcion de ArithmeticException se usa para uan funcion Aritmetica donde comprobamos si la operacion la hace con éxito o no.
                System.out.println("Error al dividir entre 0");
            }

        } else if (nombreEquipo.equalsIgnoreCase("VISITANTE")) {

            for (Jugador j : this.equipoVisitante) { //Recorremos el arraylist con un for mejorado. (Otra forma de recorrer arrays / Arraylist.)
                if (j instanceof JugadorCampo) { //Instanciamos la clase JugadorCampo para poder acceder a sus atributos.
                    if (j instanceof Atacante) {
                        Atacante a = (Atacante) j; //Casteamos a Atacante para dar a entender al código, que este es un objeto de tipo Atacante si o si.
                        contador = contador + a.getPases();
                        totalPases++;
                    } else if (j instanceof Defensor) {
                        Defensor a = (Defensor) j; //Casteamos a Defensor para dar a entender al código, que este es un objeto de tipo Defensor si o si.
                        contador = contador + a.getPases();
                        totalPases++;
                    }
                }
            }

            try { //Aplicamos el uso de Try Catch para añadir una excepcion que incluye Java. 
                System.out.println("MEDIA DE PASES (LOCAL): " + contador / totalPases);
            } catch (ArithmeticException ex) {
                System.out.println("Error al dividir entre 0");
            }
        }
    } //Cierre del metodo

    /* Método que no devuelve nada. El metodo ordena mediante un CompareTo/Collections las listas de jugadores creados de mayor a menor. 
     * Dependiendo de lo que marque el usuario por teclado, si es Local o Visitante.
     * @param args Arreglo de String's
     * @return Sin valor de retorno
     */
    public void ordenarJugadoresPorGoles() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {

            ArrayList<Jugador> aux = new ArrayList<>(); //Lo que hago en esta funcion es: como el array no puede ordenar con NULLES, creo un nuevo ArrayList, donde van a parar los 
            for (int i = 0; i < this.equipoLocal.length; i++) { // objetos del Array y los nulles los filtra y no los añade, al ser un Array dinamico, uso el CompareTo y me lo ordena.
                if (equipoLocal[i] != null) {
                    aux.add(equipoLocal[i]);
                }
            }
            Collections.sort(aux);

            for (int i = 0; i < aux.size(); i++) {
                equipoLocal[i] = aux.get(i);
            }

            System.out.println("Equipo LOCAL ordenado.");

        } else if (nombreEquipo.equalsIgnoreCase("VISITANTE")) {

            Collections.sort(equipoVisitante);
            System.out.println("Equipo VISITANTE ordenado.");

        }
    } //Cierre del metodo

    public void ordenarJugadoresPorPases() {

        System.out.println("Equipo al que pertenece \n - LOCAL \n - VISITANTE");
        String nombreEquipo = teclado.next();

        while (!equipoCorrecto(nombreEquipo)) {
            System.out.println("Equipo no encontrado, introduzca LOCAL o VISITANTE");
            nombreEquipo = teclado.next();
        }

        if (nombreEquipo.equalsIgnoreCase("LOCAL")) {

            ArrayList<Jugador> aux = new ArrayList<>(); //Lo que hago en esta funcion es: como el array no puede ordenar con NULLES, creo un nuevo ArrayList, donde van a parar los 
            for (int i = 0; i < this.equipoLocal.length; i++) { // objetos del Array y los nulles los filtra y no los añade, al ser un Array dinamico, uso el CompareTo y me lo ordena.
                if (equipoLocal[i] != null) {
                    aux.add(equipoLocal[i]);
                }
            }
            Collections.sort(aux);

            for (int i = 0; i < aux.size(); i++) {
                equipoLocal[i] = aux.get(i);
            }

            System.out.println("Equipo LOCAL ordenado.");

        } else if (nombreEquipo.equalsIgnoreCase("VISITANTE")) {

            Collections.sort(equipoVisitante);
            System.out.println("Equipo VISITANTE ordenado.");

        }
    } //Cierre del metodo

}
