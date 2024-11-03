import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import Entities.Imovel;
import Entities.Usuario;
import Services.ImovelService;
import Services.UserService;

public class Main {

    public static void main(String[] args) {
        ImovelService imovelService = new ImovelService();
        UserService userService = new UserService();

        List<Imovel> imoveisCadastrados = new ArrayList<>();
        List<Usuario> usuariosCadastrados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int userAutentication = 1;

        while (userAutentication != 0) {
            System.out.println("--------------------");
            System.out.println("     ENTRAR COMO:   ");
            System.out.println("--------------------\n");
            System.out.println("1- Visitante");
            System.out.println("2- Cliente");
            System.out.println("3- Administrador");
            System.out.println("4- Proprietario");
            System.out.println("5- Cadastrar");
            System.out.println("--------------------\n");
            System.out.print("Selecione uma opção: ");
            userAutentication = scanner.nextInt();
            int userOption = 1;
            switch (userAutentication) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("Digite o email do usuário: ");
                    String emailLogin = scanner.next();
                    System.out.println("Digite a senha do usuário: ");
                    int senhaLogin = scanner.nextInt();
                    userAutentication = userService.autenticarUsuario(emailLogin, senhaLogin, userAutentication, usuariosCadastrados);

                    if (userAutentication < 0) {
                        System.out.println("Autenticação falhou.");
                    } else {
                        userOption = 0;
                    }
                    break;
                case 5:
                    System.out.println("Digite o nome do usuário: ");
                    String nome = scanner.next();
                    System.out.println("Digite o email do usuário: ");
                    String email = scanner.next();
                    System.out.println("Digite o telefone do usuário: ");
                    String telefone = scanner.next();
                    System.out.println("Digite a senha do usuário (Apenas números): ");
                    int senha = scanner.nextInt();
                    System.out.println("Qual o tipo do usuário? (V - Visitante, C - Cliente, A - Administrador, P - Proprietário");
                    String tipo = scanner.next();
                    userService.cadastrarUsuario(usuariosCadastrados, nome, email, telefone, senha, tipo);
                    break;
                default:
                    System.out.println("DIGITE UM VALOR VALIDO...\n");
                    userAutentication = 0;
                    break;
            }

            while (userOption == 0) {
                System.out.println("--------------------");
                System.out.println("        MENU        ");
                System.out.println("--------------------\n");

                System.out.println("1- Buscar Imovel");

                if (userAutentication > 1) {
                    System.out.println("2- Reservar Imovel");    //LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
                }

                if (userAutentication > 2) {
                    System.out.println("3- Buscar Usuario");
                    System.out.println("4- Cadastrar Usuario");    //LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
                    System.out.println("5- Editar Usuario");    //LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
                    System.out.println("6- Cadastrar Imovel");  //LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
                    System.out.println("7- Editar Imovel");        //LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
                }

                if (userAutentication == 4) {
                    //OPCIONAL
                    System.out.println("8- Gerir Anuncio");
                }
                System.out.println("9- Sair");

                System.out.println("--------------------\n");
                System.out.print("Selecione uma opção: ");
                userOption = scanner.nextInt();

                switch (userOption) {
                    case 1:
                        int escolhaImovel;

                        if (imoveisCadastrados.isEmpty()) {
                            System.out.println("A LISTA DE IMOVEIS ESTA VAZIA...");
                            break;
                        }

                        for (int i = 0; i < imoveisCadastrados.size(); i++) {
                            System.out.println((i + 1) + "- " + imoveisCadastrados.get(i).getEndereco());
                        }

                        try {
                            System.out.print("\nESCOLHA UM IMOVEL PARA OBTER MAIS DETALHES: ");
                            escolhaImovel = scanner.nextInt();

                            String endereco = imoveisCadastrados.get(escolhaImovel - 1).getEndereco();

                            Imovel imovelRetornado = ImovelService.BuscarImovel(endereco, imoveisCadastrados);
                            imovelRetornado.DetalharImovel();

                        } catch (NumberFormatException e) {

                            System.out.println("Erro: Digite um numero valido...");
                        }

                        userOption = 0;
                        break;
                    case 2:
                        if (userAutentication > 1) {
                            //DEVE SER CRIADA UMA NOVA RESERVA COM ESSE IMOVEL CASO ELE ESTEJA DISPONIVEL NA DATA DIGITADA
                            // O IMOVEL DEVE SER BUSCADO ANTES DE VALIDAR A DISPONIBILIDADE
                            // AS DATAS ENTRE O dataInicio E dataFim DA RESERVA DEVEM SER ADICIONADAS A LISTA DE DATAS INDISPONIVEIS DO IMOVEL
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 3:
                        if (userAutentication > 2) {
                            int escolhaUsuario;

                            if (usuariosCadastrados.isEmpty()) {
                                System.out.println("A LISTA DE USUARIOS	 ESTA VAZIA...");
                                userOption = 0;
                                break;
                            }

                            for (int i = 0; i < usuariosCadastrados.size(); i++) {
                                System.out.println((i + 1) + "- " + usuariosCadastrados.get(i).getNome());
                            }

                            try {
                                System.out.print("\nESCOLHA UM IMOVEL PARA OBTER MAIS DETALHES: ");
                                escolhaUsuario = scanner.nextInt();

                                String nome = usuariosCadastrados.get(escolhaUsuario - 1).getNome();

                                Usuario usuarioRetornado = UserService.BuscarUsuario(nome, usuariosCadastrados);
                                usuarioRetornado.DetalharUsuario();

                            } catch (NumberFormatException e) {
                                System.out.println("Erro: Digite um numero valido...");
                            }

                            userOption = 0;
                            break;
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 4:
                        if (userAutentication > 2) {
                            //O USUÁRIO DEVE SER CRIADO COM UMA DAS OPÇÕES DE LOGIN
                            //USAMOS O POLIMORFISMO PARA ADICIONA-LOS À LISTA NA MAIN
                            //LEMBRAR DE VALIDAR OS DADOS
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 5:
                        if (userAutentication > 2) {
                            //POSSIBILITAR EDICAO DE USUARIO
                            //LEMBRAR DE VALIDAR OS DADOS
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 6:
                        if (userAutentication > 2) {

                            System.out.println("Digite o tipo do imóvel:");
                            String tipo = scanner.next();

                            System.out.println("Digite a área do imóvel:");
                            float area = scanner.nextFloat();

                            System.out.println("Digite o endereço do imóvel:");
                            scanner.nextLine();
                            String endereco = scanner.nextLine();

                            System.out.println("Digite a quantidade de quartos:");
                            int qtdQuartos = scanner.nextInt();

                            System.out.println("Digite a quantidade de banheiros:");
                            int qtdBanheiros = scanner.nextInt();

                            System.out.println("Digite o valor da diária:");
                            float valorDiaria = scanner.nextFloat();


                            System.out.println("Digite o valor semanal:");
                            float valorSemanal = scanner.nextFloat();

                            System.out.println("Digite o valor mensal:");
                            float valorMensal = scanner.nextFloat();

                            List<String> datasDisponibilidade = new ArrayList<>();
                            System.out.println("Quantas n° de datas disponiveis?");
                            int diasDisponiveis = scanner.nextInt();

                            for (int i = 1; i <= diasDisponiveis; i++) {
                                System.out.println("Digite a data do " + i + "° dia:");
                                String data = scanner.next();
                                datasDisponibilidade.add(data);
                            }

                            List<String> fotos = new ArrayList<>();

                            System.out.println("Digite uma descrição para o imóvel:");
                            scanner.nextLine();
                            String descricao = scanner.nextLine();

                            ImovelService.CadastrarImovel(tipo, area, endereco, qtdQuartos, qtdBanheiros, valorDiaria, valorSemanal, valorMensal,
                                    datasDisponibilidade, descricao, fotos, imoveisCadastrados);

                            System.out.println("Imóvel cadastrado com sucesso!");
                            userOption = 0;
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 7:
                        if (userAutentication > 2) {
                            ImovelService.EditarImovel(imoveisCadastrados);
                            System.out.println("Imovel editado com sucesso");
                            userOption = 0;
                            break;
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 8:
                        if (userAutentication == 4) {
                            //NÃO SEI OQ FAZER AQUI KKKK
                            // TALVEZ COLOCAR UMA LISTA DE ANUNCIOS COM ALGUNS ANUNCIOS PRE-PRONTOS PARA O PROFESSOR PODER MEXER SE QUISER
                            // MAS PARA ISSO DEVERIA SER ADICIONADO UMA ENTIDADE DE ANUNCIO
                        } else {
                            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                            userOption = 0;
                        }
                        break;
                    case 9:
                        userAutentication = 1;
                        break;
                    default:
                        System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
                        userOption = 0;
                        break;
                }
            }
        }

        scanner.close();
    }
}
