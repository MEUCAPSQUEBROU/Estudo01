import java.util.ArrayList; // Importa a classe ArrayList para armazenar múltiplos alunos
import java.util.Scanner;  // Importa a classe Scanner para entrada de dados pelo usuário

public class SistemaDeNotas {
    public static void main(String[] args) {
        // Cria um Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Lista para armazenar os alunos registrados
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        boolean continuar = true; // Controle do loop principal do programa
        
        while (continuar) {
            System.out.println("\n=== Sistema de Notas ===");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Exibir Resultados");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt(); // Lê a escolha do usuário
            scanner.nextLine(); // Consome o caractere de nova linha (evita problemas com próximas entradas)
            
            switch (opcao) {
                case 1:
                    // Adiciona um novo aluno
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine(); // Lê o nome do aluno
                    
                    double[] notas = new double[3]; // Array para armazenar 3 notas
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Digite a nota " + (i + 1) + ": ");
                        notas[i] = scanner.nextDouble(); // Lê cada nota do aluno
                    }
                    scanner.nextLine(); // Consome o caractere de nova linha
                    
                    // Cria um novo objeto Aluno e adiciona à lista
                    alunos.add(new Aluno(nome, notas));
                    System.out.println("Aluno adicionado com sucesso!");
                    break;
                    
                case 2:
                    // Exibe os resultados de todos os alunos
                    System.out.println("\n=== Resultados ===");
                    for (Aluno aluno : alunos) {
                        System.out.println(aluno); // Chama o método toString() de cada objeto Aluno
                    }
                    break;
                    
                case 3:
                    // Sai do programa
                    continuar = false;
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                    
                default:
                    // Trata opções inválidas
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        scanner.close(); // Fecha o scanner para liberar recursos
    }
}

// Classe para representar um Aluno
class Aluno {
    private String nome;   // Nome do aluno
    private double[] notas; // Notas do aluno
    private double media;  // Média calculada

    public Aluno(String nome, double[] notas) {
        this.nome = nome; // Define o nome do aluno
        this.notas = notas; // Define as notas do aluno
        this.media = calcularMedia(); // Calcula a média ao criar o aluno
    }

    private double calcularMedia() {
        // Calcula a média das notas
        double soma = 0;
        for (double nota : notas) {
            soma += nota; // Soma todas as notas
        }
        return soma / notas.length; // Retorna a média
    }

    @Override
    public String toString() {
        // Retorna uma representação textual do aluno
        String status = media >= 7.0 ? "Aprovado" : "Reprovado"; // Verifica se o aluno foi aprovado
        return "Nome: " + nome + ", Média: " + String.format("%.2f", media) + " (" + status + ")";
    }
}
