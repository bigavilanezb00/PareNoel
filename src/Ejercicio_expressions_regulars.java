import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio_expressions_regulars {
    public static void main(String[] args) {
        String pareNoel = "\\*<]:-DOo";
        String rens = ">:o\\)";
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
                    Pattern ppareNoel = Pattern.compile(pareNoel);
                    Matcher mpareNoel = ppareNoel.matcher(line);
                    int pareNoelcompte = 0;
                    while (mpareNoel.find()) { pareNoelcompte++; }

                    Pattern prens = Pattern.compile(rens);
                    Matcher mrens = prens.matcher(line);
                    int renscompte = 0;
                    while (mrens.find()) { renscompte++; }

                    Pattern pfollet = Pattern.compile(follets);
                    Matcher mfollet = pfollet.matcher(line);
                    int folletcompte = 0;
                    while (mfollet.find()) { folletcompte++; }
                    folletcompte -= pareNoelcompte;
                    if (pareNoelcompte != 0) {
                        System.out.print("Pare Noel " + "(" + pareNoelcompte + ") ");
                    }

                    if (renscompte != 0) {
                        System.out.print("Rens " + "(" + renscompte + ") ");
                    }

                    if (folletcompte != 0) {
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