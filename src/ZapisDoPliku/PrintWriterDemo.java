package ZapisDoPliku;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo  {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("danie.txt");

        pw.println("Tomek lubi schabowy z kapustą :)");

        //zapisanie kolejnej linii
        pw.println("Michał lubi kluski śląskie");

        pw.close();
    }
}
