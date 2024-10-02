package beybyhair;

import java.util.Scanner;

public class BeybyHair {
    static Scanner ler = new Scanner(System.in);
    static int opMP;

    private static int opSM;

    public static int lerInt() {
        Scanner leia = new Scanner(System.in);
        int num = 99;
        try {
            num = leia.nextInt();
        } catch (Exception e) {
            System.out.print("Tente novamente: ");
            lerInt();
        }
        return num;
    }// Função para ler apenas números.

    public static void main(String[] args) {

    }

}
