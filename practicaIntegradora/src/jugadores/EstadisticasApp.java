/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadores;

import java.util.Scanner;

/**
 *
 * @author Cesar
 */
public class EstadisticasApp {

    /*
    *Creacion del metodo main y la implementacion del código con sus métodos ya creados.
    @return Valores del metodo ya creados en clase Jugador.
     */
    public static void main(String[] args) throws Exception {

        Partido partido = new Partido();

        Scanner teclado = new Scanner(System.in); //Implemento de la clase Scanner, donde el usuario introducira opciones.

        System.out.println("Intoduzca una opcion: \n 1. Añadir Atacante \n 2. Añadir Defensor \n 3. Añadir Portero \n 4. Contabilizar gol \n 5. Contabilidad pase con exito \n 6. "
                + "Contabilidad recuperacion \n 7. Contabilidad parada \n 8. Mostar jugadores \n 9. Eliminar jugador \n 10. Mostrar alineaciones \n 11. Calcular goles \n "
                + "12. Calcular media de pases \n 13. Ordenar por goles \n 14. Salir");

        int opcion = teclado.nextInt();

        while (opcion < 1 || opcion > 13) {
            System.out.println("Opcion invalida, introduce un numero del 1 al 13");
            opcion = teclado.nextInt();
        }

        while (opcion >= 1 && opcion <= 13) {

            switch (opcion) {

                case 1:  // Añadir Atacante

                    partido.añadirJugadorAtacante();

                    break;

                case 2: // Añadir Defensor

                    partido.añadirJugadorDefensor();

                    break;

                case 3: // Añadir Portero

                    partido.añadirJugadorPortero();

                    break;

                case 4: //Contabilizar Gol

                    partido.contabilizarGol();

                    break;

                case 5: //Contailizar pase

                    partido.contabilizarPases();

                    break;

                case 6: // Contabilizar Recuperacion del jugador

                    partido.contabilizarRecuperacion();

                    break;

                case 7: //Contabilizar parada del portero

                    partido.contabilizarParada();
                    break;

                case 8: //Mostrar listado de jugadore

                    partido.mostrarDatosJugador();

                    break;

                case 9: //Eliminar jugadores del campo

                    partido.eliminarJugador();

                    break;

                case 10: //Muestra la alineacion del equipo Local y Visitante

                    partido.mostrarAlineacionLyV();

                    break;

                case 11: //Calcula el resultado del partido

                    partido.calcularTotalGoles();

                    break;

                case 12: //Calcula la media de pases dados por los jugadores de campo

                    partido.mediaDePases();

                    break;

                case 13: //Ordena los jugadores por mayor rango de goles.

                    partido.ordenarJugadoresPorGoles();

                    break;
                    
                case 14: //Ordenar por pases realizados
                    
                    partido.ordernarJugadoresPorPases();
                    
                    break;
                    
                    
            } //Cierre del programa switch

            System.out.println("Introduzca una opcion: \n 1. Añadir Atacante \n 2. Añadir Defensor \n 3. Añadir Portero \n 4. Contabilizar gol \n 5. Contabilidar pase con exito \n 6. "
                    + "Contabilidar recuperacion \n 7. Contabilidar parada \n 8. Mostar jugadores \n 9. Eliminar jugador \n 10. Mostrar alineaciones \n 11. Calcular goles \n "
                    + "12.Calcular media de pases \n 13. Ordenar por goles \n 14. Ordenar jugadores por pases \n 15. Salir");
            opcion = teclado.nextInt();

            while (opcion < 1 || opcion > 13) {
                System.out.println("Introduzca un numero del 1 al 13");
                opcion = teclado.nextInt();

            }

        } //Cierre del while
        System.out.println("HASTA LUEGO");
    }
} //Fin del programa
