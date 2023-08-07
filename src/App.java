import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {

    // Funcion que peremite visualizar el menún
    public static void MostrarMenu() {

        Scanner scaner = new Scanner(System.in);
        String on = "e";
        boolean power = false, estado;
        int agua = 0, leche = 0, cafe = 0, capuchino = 0,
                p1, p2, p3, p4, op, limit = 50,
                _tintoP, _cafeP, _capuchinoP;
        String message;

        Cafetera C1 = new Cafetera();

        do {
            // se usa para colocar el enceder y apagar lavadora
            if (power == false) {
                on = "Encender";
            } else if (power == true) {
                on = "Apagar";
            }

            // opciones del menú
            String[] options = {
                    "1. " + on,
                    "2. Cargar material",
                    "3. Estado de consumo",
                    "4. Establecer precios",
                    "5. Estado de ventas",
                    "6. Hacer café",
                    "0. Cerrar"
            };

            String selectedOption = (String) JOptionPane.showInputDialog(
                    null,
                    "___ café Don José Valdez",
                    "Menú",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            op = Integer.parseInt(selectedOption.substring(0, 1));

            switch (op) {
                // opción que permite modificar el estado que es mostrado en pantalla
                // (encendido, apagado)
                case 1:
                    if (op == 1) {

                        if (power == false) {
                            power = true;
                            C1.setEstado(power);
                            C1.SetPrecios(0, 0, 0);
                            C1.SetCargar(0, 0, 0, 0);
                        } else if (power == true) {
                            power = false;
                            C1.setEstado(power);

                            estado = false;
                        }
                    }
                    break;
                case 2:
                    if (power == true) {
                        // opción que permite cargar el material que se usara, y sus codniciones
                        p1 = Integer.parseInt(JOptionPane.showInputDialog("1. Agua:"));
                        while ((agua + p1) > 100) {
                            p1 = Integer
                                    .parseInt(JOptionPane.showInputDialog("---Cantidad supera el límite---\n1. Agua:"));
                        }
                        agua += p1;

                        p2 = Integer.parseInt(JOptionPane.showInputDialog("2. Leche:"));
                        while ((leche + p2) > limit) {
                            p2 = Integer
                                    .parseInt(
                                            JOptionPane.showInputDialog("---Cantidad supera el límite---\n2. Leche:"));
                        }
                        leche += p2;

                        p3 = Integer.parseInt(JOptionPane.showInputDialog("3. Café:"));
                        while ((cafe + p3) > limit) {
                            p3 = Integer
                                    .parseInt(JOptionPane.showInputDialog("---Cantidad supera el límite---\n3. Café:"));
                        }
                        cafe += p3;

                        p4 = Integer.parseInt(JOptionPane.showInputDialog("4. Capuchino:"));
                        while ((capuchino + p4) > limit) {
                            p4 = Integer.parseInt(
                                    JOptionPane.showInputDialog("---Cantidad supera el límite---\n4. Capuchino:"));
                        }
                        capuchino += p4;

                        C1.SetCargar(agua, leche, cafe, capuchino);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe activar la cafetera", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                    break;
                case 3:
                    // permite ver el estado del material que se usa para hacer bebidas calientes
                    if (power == true) {
                        C1.getMostrarEstado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe activar la cafetera", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                    break;

                case 4:
                    // permite al usuario definir los valores de cada bebida caliiente disponible
                    if (power == true) {
                        int tintoP = Integer.parseInt(JOptionPane.showInputDialog("1. Tinto:"));
                        int cafeP = Integer.parseInt(JOptionPane.showInputDialog("2. Café:"));
                        int capuchinoP = Integer.parseInt(JOptionPane.showInputDialog("3. Capuchino:"));
                        C1.SetPrecios(tintoP, cafeP, capuchinoP);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe activar la cafetera", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                    break;

                case 5:
                    // permite ver el estado de las ventas
                    if (power == true) {
                        JOptionPane.showMessageDialog(null, "---Estado de Ventas---\n" +
                                "Precios: 1. Tinto: " + C1.getPrecioTinto() + "\n" +
                                "         2. Café: " + C1.getPrecioCafe() + "\n" +
                                "         3. Capuchino: " + C1.getPreciocapuchino() + "\n\n" +
                                "Ventas diarias:\n" +
                                "1. Tinto: " + C1.getPrecioTintoT() + "\n" +
                                "2. Café: " + C1.getPrecioCafeT() + "\n" +
                                "3. Capuchino: " + C1.getPreciocapuchinoT() + "\n\n" +
                                "---VALOR TOTAL: " + C1.getPrecioT());
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe activar la cafetera", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                    break;
                case 6:
                    // permite escoger al usuario que tipo de bebida desea
                    if (power == true) {
                        message = "---Haz tu bebida---\n" +
                                "1. Tinto\n" +
                                "2. Café\n" +
                                "3. Capuchino";

                        JOptionPane.showMessageDialog(null, message);

                        int opcionBebida = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción:"));

                        // opciones que se ejecutan con base a la elección del usuario
                        // cada opción relaiza procesos similares
                        switch (opcionBebida) {
                            case 1:
                                // da la elección de escoger el tamaño de la bebida
                                message = "---Tinto---\n" +
                                        "Escoja tamaño:\n" +
                                        "1. 7 Oz\n" +
                                        "2. 9 Oz";

                                JOptionPane.showMessageDialog(null, message);

                                int tamTinto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño:"));
                                int cantTinto = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Tintos:"));
                                // funciones que operan para hacer la bebida caliente y para mostrar factura
                                C1.setHacerTinto(tamTinto, cantTinto);
                                C1.getFactura(tamTinto, cantTinto, C1.getPrecioTinto());
                                break;

                            case 2:
                                // da la elección de escoger el tamaño de la bebida
                                message = "---Café---\n" +
                                        "Escoja tamaño:\n" +
                                        "1. 7 Oz\n" +
                                        "2. 9 Oz";

                                JOptionPane.showMessageDialog(null, message);

                                int tamCafe = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño:"));
                                int cantCafe = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Cafés:"));

                                // funciones que operan para hacer la bebida caliente y para mostrar factura
                                C1.setHacerCafe(tamCafe, cantCafe);
                                C1.getFactura(tamCafe, cantCafe, C1.getPrecioCafe());
                                break;

                            case 3:
                                // da la elección de escoger el tamaño de la bebida
                                message = "---Capuchino---\n" +
                                        "Escoja tamaño:\n" +
                                        "1. 7 Oz\n" +
                                        "2. 9 Oz";

                                JOptionPane.showMessageDialog(null, message);

                                int tamCapuchino = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño:"));
                                int cantCapuchino = Integer
                                        .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Capuchinos:"));

                                // funciones que operan para hacer la bebida caliente y para mostrar factura
                                C1.setHacerCapuchino(tamCapuchino, cantCapuchino);
                                C1.getFactura(tamCapuchino, cantCapuchino, C1.getPreciocapuchino());
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida");
                                break;
                        }
                    } else {
                        // mensaje en caso de que la cafetera no este encendida y quieran acceder a esta
                        // opción
                        JOptionPane.showMessageDialog(null, "Debe activar la cafetera", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    }
                    break;

            }

        } while (op != 0);
    }

    // clase main donde se corre todo el codigo

    public static void main(String[] args) {
        // funcion para ver el menu y operarlo
        MostrarMenu();

    }

}
