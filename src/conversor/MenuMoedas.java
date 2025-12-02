package conversor;

import java.util.Scanner;

public class MenuMoedas {

    public static String escolherMoeda(String mensagem) {
        Scanner sc = new Scanner(System.in);

            System.out.println(mensagem);
            System.out.println("1 - USD (Dólar)");
            System.out.println("2 - BRL (Real)");
            System.out.println("3 - EUR (Euro)");
            System.out.println("4 - GBP (Libra)");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1: return "USD";
                case 2: return "BRL";
                case 3: return "EUR";
                case 4: return "GBP";
                default:
                    System.out.println("Opção inválida. Usando USD.");
                    return "USD";
            }
        }
    }


