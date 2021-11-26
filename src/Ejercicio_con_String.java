import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio_con_String {
    public static void main(String[] args) {
        String pareNoel = "*<]:-DOo";
        String rens = ">:o)";
        String follets = "<]:-D";


        try {
            FileReader file = new FileReader("C:\\Users\\Pol\\Downloads\\santako.txt");
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            while (!eof) {
                String line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    //System.out.println(line.contains(pareNoel));
                    int pareNoelcompte = 0;
                    int renscompte = 0;
                    int folletcompte = 0;
                    int posicion = 0;

                    //se busca la primera vez que aparece
                    posicion = line.indexOf(pareNoel);
                    while (posicion != -1) { //mientras se encuentre el caracter
                        pareNoelcompte++;           //se cuenta
                        //se sigue buscando a partir de la posición siguiente a la encontrada
                        posicion = line.indexOf(pareNoel, posicion + 1);
                    }


                    posicion = line.indexOf(rens);
                    while (posicion != -1) {
                        renscompte++;
                        posicion = line.indexOf(rens, posicion + 1);
                    }

                    posicion = line.indexOf(follets);
                    while (posicion != -1) {
                        folletcompte++;
                        posicion = line.indexOf(follets, posicion + 1);
                    }


                    folletcompte -= pareNoelcompte;
                    if (pareNoelcompte != 0) {
                        System.out.print("Pare Noel " + "(" + pareNoelcompte + ") ");
                    }

                    if (renscompte != 0) {
                        System.out.print("Rens " + "(" + renscompte + ") ");
                    }

                    if (folletcompte > 0) {
                        System.out.print("Follet " + "(" + folletcompte + ")");
                    }
                    System.out.println();
                    eof = false;
                }
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}