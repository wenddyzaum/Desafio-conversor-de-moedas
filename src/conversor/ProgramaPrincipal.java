package conversor;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ConversorDeMoedas conversor = new ConversorDeMoedas();

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1 - Converter moedas");
            System.out.println("2 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();

            if (opcao == 2) {
                System.out.println("Encerrando...");
                break;
            }

            String origem = MenuMoedas.escolherMoeda("\nEscolha a moeda de ORIGEM:");
            String destino = MenuMoedas.escolherMoeda("\nEscolha a moeda de DESTINO:");

            System.out.print("\nDigite o valor a converter: ");
            double valor = sc.nextDouble();

            try {
                double resultado = conversor.converter(origem, destino, valor);

                System.out.println("\nResultado da conversão:");
                System.out.printf("%.2f %s = %.2f %s\n",
                        valor, origem, resultado, destino);

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}