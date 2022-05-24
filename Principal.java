import java.util.Scanner;
import java.util.Random;

public class Principal
{   public static Bestia[][] bestias = new Bestia[3][3];

    public static void main (String [] args){
        MostrarMenu();
    }

    public static void MostrarMenu(){
        Scanner Scan = new Scanner(System.in);

        System.out.println("|****************************************************************************************************************************|");
        System.out.println("|**|                                                       BESTIAS SALVAJES                                               |**|");
        System.out.println("|**|                                                          LA INVASION                                                 |**|");
        System.out.println("|**|                                                                                                                      |**|");
        System.out.println("|**|                                             ¡Consigue acabar con todas para ganar!                                   |**|");
        System.out.println("|****************************************************************************************************************************|");
        System.out.println("\n");
        System.out.println("Digite el numero de accion que desea realizar");   
        System.out.println("[0] FIN DEL JUEGO");
        System.out.println("[1] DISPARA! (-5 Salud para la bestia)");
        System.out.println("[2] BOMBA ATOMICA! (Mata una bestia de forma aleatoria)");
        System.out.println("[3] CONVERTIR EN MUTANTE (Transforma en mutante a la bestia con menos vida)");
        System.out.println("[4] CONVERSION DE SANGRE ! (La bestia con menos salud evoluciona)");
        System.out.println("[5] FRASE INSPIRADORA DE LA ABUELA!");

        Principal.GeneraBestiaAleatoria(bestias);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        Principal.MostrarBestias(bestias);

        int opcionTeclado = Scan.nextInt();
        while(opcionTeclado != 0){
            while(Principal.Ganarjuego(bestias) != true){

                switch(opcionTeclado){
                    case 1:
                        System.out.println("ELIGA LA CORDENADA DONDE DESEA DISPARAR (X,Y)");
                        System.out.println("DIGITE LA CORDENA FILA (Recuerde Filas: 1-3)");
                        int coordenadaX = Scan.nextInt();
                        System.out.println("DIGITE LA CORDENA COLUMNA (Recuerde Columnas: 1-3)");
                        int coordenadaY = Scan.nextInt();
                        coordenadaX = coordenadaX - 1;
                        coordenadaY = coordenadaY - 1;

                        if(bestias[coordenadaX][coordenadaY] == null){
                            System.out.println("FALLASTE EL TIRO");
                        }else{
                            bestias[coordenadaX][coordenadaY].Disparar();
                            System.out.println("ACERTASTE");
                        }

                        break;
                    case 2:
                        int aleatorioFila = 0;
                        int aleatorioColumna = 0;

                        aleatorioFila = (int)(Math.random() * 2);
                        aleatorioColumna = (int)(Math.random() * 2);

                        System.out.println("BOOOOOOOM!");
                        bestias[aleatorioFila][aleatorioColumna].BombaAtomica();

                        break;
                    case 3:
                        Principal.ConversionSangre(bestias);
                        System.out.println("Esta evolucionando!");

                        break;
                    case 4:
                        Principal.ConvertirMutante(bestias);
                        System.out.println("Escuchas un rugido desgarrador...MUTANTE!");

                        break;    
                    case 5:
                        String[] frases = new String [5];
                        frases[0]= "La peor guerra es la que no se lucha.";
                        frases[1]= "Le esta yendo mas mal que a un marrano en patines.";
                        frases[2]= "La vida apesta, Pero al menos no huele a ti.";
                        frases[3]= "Nos acercamos lo más que podemos a la muerte, para sentirnos vivos.";
                        frases[4]= "La gente solo ama un reflejo cuando no es el suyo.";
                        int fraseAleatoria = (int)(Math.random() * frases.length);
                        System.out.println(frases[fraseAleatoria]);
                        break;
                }

                System.out.println("\n");
                System.out.println("Digite el numero de accion que desea realizar");   
                System.out.println("[0] FIN DEL JUEGO");
                System.out.println("[1] DISPARA! (-5 Salud para la bestia)");
                System.out.println("[2] BOMBA ATOMICA! (Mata una bestia de forma aleatoria)");
                System.out.println("[3] CONVERTIR EN MUTANTE (Transforma en mutante a la bestia con menos vida)");
                System.out.println("[4] CONVERSION DE SANGRE ! (La bestia con menos salud evoluciona)");
                System.out.println("[5] FRASE INSPIRADORA DE LA ABUELA!");

                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                Principal.MostrarBestias(bestias);

                opcionTeclado = Scan.nextInt();

            }

            if(Principal.Ganarjuego(bestias) == true){
                opcionTeclado = 0;
            }
        }
        System.out.println("FIN DEL JUEGO !");

    }

    public static int GeneraNumeroAleatorio(int numero ){
        int aleatorio = 0;
        aleatorio = (int)(Math.random() * numero) + 1;

        return aleatorio;
    }

    public static void GeneraBestiaAleatoria(Bestia[][] bestias){
        int posFila = 0;
        int posColumna = 0;
        for(int i = 0 ; i <= Principal.GeneraNumeroAleatorio(9) ; i++){

            int aleatorioB = 0;
            aleatorioB = (int)(Math.random()* 3)+1;

            if(aleatorioB == 1){
                BestiaNormal BestiaNormal1 = new BestiaNormal("Normal", 10);
                bestias[posFila][posColumna] = BestiaNormal1 ;
            }else if(aleatorioB == 2){
                BestiaAlien BestiaAlien1 = new BestiaAlien("Alien", 20);
                bestias[posFila][posColumna] = BestiaAlien1;
            }else{
                BestiaEspacial BestiaEspacial1 = new BestiaEspacial("Espacial", 30);
                bestias[posFila][posColumna] = BestiaEspacial1;
            }

            if(posColumna < 2){
                posColumna += 1;
            }else{
                posColumna = 0;
                posFila += 1;
            }
        }
    }

    public static void MostrarBestias(Bestia[][] bestias){
        int contador = 0;
        for(int i = 0; i <= 2; i++ ){

            for(int j = 0; j <= 2; j++){
                contador += 1;
                if(bestias[i][j] != null){
                    System.out.print(bestias[i][j].toString());
                }else{
                    System.out.print("||                                      ||");
                }

                if(contador > 2){
                    System.out.println("\n");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");

                    contador = 0;
                }
            }
        }
    }

    public static void ConvertirMutante(Bestia[][] bestias){

        Bestia bestiaMenosSalud = bestias[0][0];
        int menosSalud = bestias[0][0].getSalud();

        for(int i = 0; i <= 2; i++ ){

            for(int j = 0; j <= 2; j++){
                if((bestias[i][j] != null) && (bestias[0][0].getSalud() > bestias[i][j].getSalud()) && (bestias[i][j].getSalud() != 0)){
                    menosSalud = bestias[i][j].getSalud();
                    bestiaMenosSalud = bestias[i][j];
                }
            }
        }
        bestiaMenosSalud.Mutante();
    }

    public static boolean Ganarjuego(Bestia[][] bestias){

        int contador = 0;
        boolean verificador = false;

        for(int i = 0; i <= 2; i++ ){

            for(int j = 0; j <= 2; j++){
                if(bestias[i][j] == null || bestias[i][j].getSalud() <= 0){
                    contador += 1;
                }
            }
        }

        if(contador == 9){
            verificador = true;
        }

        return verificador;
    }

    public static void ConversionSangre(Bestia[][] bestias){

        Bestia bestiaMenosSalud = bestias[0][0];
        int menosSalud = bestias[0][0].getSalud();

        for(int i = 0; i <= 2; i++ ){

            for(int j = 0; j <= 2; j++){
                if((bestias[i][j] != null) && (bestias[0][0].getSalud() > bestias[i][j].getSalud()) && (bestias[i][j].getSalud() != 0)){
                    menosSalud = bestias[i][j].getSalud();
                    bestiaMenosSalud = bestias[i][j];
                }
            }
        }
        bestiaMenosSalud.Conversion();
    }
}