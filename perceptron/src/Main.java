import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
//parametry wywołania parametr alfa, plik treningowy, plik testowy
public class Main {
    static Object [] linijkiPlikuTren;
    static Object [] linijkiPlikuTest;

    static File file1;
    static File file2;

    public static void main(String[] args) {

        int liczbaPrzeiterowaniaPoDanych=100;
        double licznik=0;
        double mianownik=0;
        try {
            file1 = new File(args[1]);
            file2 = new File(args[2]);
            double alfa =Double.parseDouble(args[0]);

            BufferedReader br = new BufferedReader(new FileReader(file1));
            linijkiPlikuTren = br.lines().toArray();

            br = new BufferedReader(new FileReader(file2));
            linijkiPlikuTest = br.lines().toArray();





        Perceptron percepek = new Perceptron(alfa,liczbaPrzeiterowaniaPoDanych);
        percepek.wyucz(linijkiPlikuTren);

            System.out.println("ACCURACY= "+ percepek.sprawdz(linijkiPlikuTest));




        GUI gui=new GUI(percepek);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Sprawź gatunek");
        gui.setVisible(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
