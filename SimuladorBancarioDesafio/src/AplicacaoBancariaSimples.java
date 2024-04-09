import java.util.Scanner;

public class AplicacaoBancariaSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome = "Lady Gaga";
        String tipoConta = "Corrente";
        double saldo = 2500;
        double valorTransacao;

        System.out.println(String.format("""
                -----------------------------
                
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo de conta: %s
                Saldo inicial: R$ %.2f
                
                ----------------------------

                Operações
                                
                1- Consultar saldo
                2- Depositar
                3- Transferir
                4- Sair
                
                Digite a opção desejada:
                """, nome, tipoConta, saldo));
        int opcao = scanner.nextInt();

        while (true) {
            while (opcao < 1 || opcao > 4) {
                opcao = 0;
                System.out.println("""
                        Opção Inválida
                                        
                        Operações
                                        
                        1- Consultar saldos
                        2- Receber valor
                        3- Transferir valor
                        4- Sair
                                        
                        Digite a opção desejada:
                        """);
                opcao = scanner.nextInt();
            }

            if (opcao == 4) {
                break;
            } else {
                switch (opcao) {
                    case 1:
                        System.out.println(String.format("O saldo atual é: R$ %.2f\n", saldo));
                        break;
                    case 2:
                        System.out.println("Informe o valor a receber:");
                        valorTransacao = scanner.nextDouble();
                        saldo += valorTransacao;
                        System.out.println(String.format("Saldo atualizado: R$ %.2f\n", saldo));
                        break;
                    case 3:
                        System.out.println("Informe o valor a transferir:");
                        valorTransacao = scanner.nextDouble();
                        if (valorTransacao > saldo) {
                            System.out.println("Não há saldo suficiente para fazer essa transferência\n");
                        } else {
                            saldo -= valorTransacao;
                            System.out.println(String.format("Saldo atualizado: R$ %.2f\n", saldo));
                        }
                        break;
                }
                System.out.println("""            
                        Operações
                                        
                        1- Consultar saldos
                        2- Receber valor
                        3- Transferir valor
                        4- Sair
                                        
                        Digite a opção desejada:
                        """);
                opcao = scanner.nextInt();
            }
        }
    }
}
