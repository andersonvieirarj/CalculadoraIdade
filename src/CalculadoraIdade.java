import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
    public class CalculadoraIdade {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Solicita a data de nascimento do usuário
            System.out.println("Digite sua data de nascimento (dd/MM/yyyy): ");
            String dataNascimento = input.nextLine();

            // Converte a string em um objeto LocalDate (DATA REAL)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, formatter);

            // Calcula a idade do usuário
            LocalDate dataAtual = LocalDate.now();
            int idade = dataAtual.getYear() - dataNascimentoFormatada.getYear();

            if (dataAtual.getMonthValue() < dataNascimentoFormatada.getMonthValue()
                    || (dataAtual.getMonthValue() == dataNascimentoFormatada.getMonthValue()
                    && dataAtual.getDayOfMonth() < dataNascimentoFormatada.getDayOfMonth())) {
                idade--;
            }
            System.out.println("Sua idade é: " + idade);

            // Obtém o dia do mês em que o usuário nasceu
            int diaNascimento = dataNascimentoFormatada.getDayOfMonth();
            System.out.println("Você nasceu no dia " + diaNascimento);

            // Verifica se o ano de nascimento era bissexto
            int anoNascimento = dataNascimentoFormatada.getYear();
            boolean bissexto = (anoNascimento % 4 == 0 && anoNascimento % 100 != 0) || (anoNascimento % 400 == 0);
            if (bissexto) {
                System.out.println("O ano em que você nasceu era bissexto.");
            } else {
                System.out.println("O ano em que você nasceu não era bissexto.");
            }

            input.close();
        }
    }

