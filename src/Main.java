import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import Entities.Imovel;
import Entities.Reserva;
import Entities.Usuario;
import Services.ImovelService;
import Services.UserService;

public class Main {

  public static void main(String[] args) {

    List<Imovel> imoveisCadastrados = new ArrayList<>();
    List<Usuario> usuariosCadastrados = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int userAuthentication = 0;

    while(userAuthentication == 0) {
      System.out.println("--------------------");
      System.out.println("     ENTRAR COMO:   ");
      System.out.println("--------------------\n");
      System.out.println("1- Visitante");
      System.out.println("2- Cliente");
      System.out.println("3- Administrador");
      System.out.println("4- Proprietario");
      System.out.println("5- Sair");
      System.out.println("--------------------\n");
      System.out.print("RESPOSTA: ");

      try {
        userAuthentication = scanner.nextInt();
      } catch (Exception e) {
        System.out.println("Erro: Digite um número válido...");
        scanner.next(); // Limpa a entrada inválida
        continue;
      }

      switch (userAuthentication) {
        case 1: 
        System.out.println("VISITANTE LOGADO COM SUCESSO!\n");
        break;
        case 2: 
        System.out.println("CLIENTE LOGADO COM SUCESSO\n");
        break;
        case 3: 
        System.out.println("ADMINISTRADOR LOGADO COM SUCESSO!\n");
        break;
        case 4: 
        System.out.println("PROPRIETARIO LOGADO COM SUCESSO!\n");
        break;
        case 5:
        System.out.println("ENCERRANDO SISTEMA...");
        System.exit(0);
        default:
        System.out.println("DIGITE UM VALOR VALIDO...\n");
        userAuthentication = 0;
        continue;
      }

      int userOption = 0;

      while(userOption == 0) {
        System.out.println("--------------------");
        System.out.println("        MENU        ");
        System.out.println("--------------------\n");

        System.out.println("1- Buscar Imovel");

        if(userAuthentication > 1) {
          System.out.println("2- Reservar Imovel");
        }

        if(userAuthentication > 2) {
          System.out.println("3- Buscar Usuario");
          System.out.println("4- Cadastrar Usuario");    
          System.out.println("5- Editar Usuario");      
          System.out.println("6- Cadastrar Imovel");  
          System.out.println("7- Editar Imovel");     
        }

        System.out.println("8- Trocar Usuario");
        System.out.println("--------------------\n");
        System.out.print("RESPOSTA: ");

        try {
          userOption = scanner.nextInt();
        } catch (Exception e) {
          System.out.println("Erro: Digite um número válido...");
          scanner.next(); // Limpa a entrada inválida
          userOption = 0; // Reinicia a opção do usuário
          continue;
        }

        switch(userOption) {
          case 1:
          int escolhaImovel;

          if(imoveisCadastrados.isEmpty()) {
            System.out.println("A LISTA DE IMOVEIS ESTA VAZIA...");
            userOption = 0;
            break;
          }

          for(int i=0; i<imoveisCadastrados.size(); i++) {
            System.out.println((i + 1) + "- " + imoveisCadastrados.get(i).getEndereco());
          }

          try {
            System.out.print("\nESCOLHA UM IMOVEL PARA OBTER MAIS DETALHES: ");
            escolhaImovel = scanner.nextInt();

            String endereco = imoveisCadastrados.get(escolhaImovel-1).getEndereco();

            Imovel imovelRetornado = ImovelService.BuscarImovel(endereco, imoveisCadastrados);
            imovelRetornado.DetalharImovel();

          } catch (Exception e) {
            System.out.println("Erro: Digite um número válido...");
            scanner.next(); // Limpa a entrada inválida
          }

          userOption = 0;
          break;
          case 2:
          if(userAuthentication > 1) {
            //DEVE SER CRIADA UMA NOVA RESERVA COM ESSE IMOVEL CASO ELE ESTEJA DISPONIVEL NA DATA DIGITADA
            // O IMOVEL DEVE SER BUSCADO ANTES DE VALIDAR A DISPONIBILIDADE
            // AS DATAS ENTRE O dataInicio E dataFim DA RESERVA DEVEM SER ADICIONADAS A LISTA DE DATAS INDISPONIVEIS DO IMOVEL
            System.out.println("ESCOLHA O IMÓVEL PARA RESERVAR");

            Imovel imovelRetornado = null;

            if(imoveisCadastrados.isEmpty()) {
              System.out.println("A LISTA DE IMOVEIS ESTA VAZIA...");
              userOption = 0;
              break;
            }

            for(int i=0; i<imoveisCadastrados.size(); i++) {
              System.out.println((i + 1) + "- " + imoveisCadastrados.get(i).getEndereco());
            }

            try {
              escolhaImovel = scanner.nextInt();

              String endereco = imoveisCadastrados.get(escolhaImovel-1).getEndereco();

              imovelRetornado = ImovelService.BuscarImovel(endereco, imoveisCadastrados);
            } catch (Exception e) {
              System.out.println("Erro: Digite um número válido...");
            }
            

            // Definindo datas de início e fim
            Date data_inicio = null;
            Date data_fim = null;

            int success = 0;
            while(success == 0){
              try{
                System.out.print("Digite a data de início (DD/MM/AAAA): ");
                scanner.next(); // Limpa a entrada inválida
                String data = scanner.nextLine();

                // Data de início
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                data_inicio = formatador.parse(data);
              }catch(ParseException e){
                success = 0;
                continue;
              }
              try{
                System.out.print("Digite a data de fim (DD/MM/AAAA): ");
                String data = scanner.nextLine();

                // Data de final
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                data_fim = formatador.parse(data);
              }catch(ParseException e){
                success = 0;
                continue;
              }
              success = 1;
            }

            // Não usado para nada :(
            Reserva novaReserva = new Reserva(imovelRetornado, data_inicio, data_fim);

            //Adicionando datas da reserva no imóvel
            imovelRetornado.setDatas_reservadas(data_inicio, data_fim);

          } else {
            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
          }

          userOption = 0;
          break;
          case 3:
          if(userAuthentication > 2) {
            int escolhaUsuario;

            if(usuariosCadastrados.isEmpty()) {
              System.out.println("A LISTA DE USUARIOS ESTA VAZIA...");
              userOption = 0;
              break;
            }

            for(int i=0; i<usuariosCadastrados.size(); i++) {
              System.out.println((i + 1) + "- " + usuariosCadastrados.get(i).getNome());
            }

            try {
              System.out.print("\nESCOLHA UM USUARIO PARA OBTER MAIS DETALHES: ");
              escolhaUsuario = scanner.nextInt();

              String nome = usuariosCadastrados.get(escolhaUsuario-1).getNome();

              Usuario usuarioRetornado = UserService.BuscarUsuario(nome, usuariosCadastrados);
              usuarioRetornado.DetalharUsuario();

            } catch (Exception e) {
              System.out.println("Erro: Digite um número válido...");
              scanner.next(); // Limpa a entrada inválida
            }
          } else {
            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
          }

          userOption = 0;
          break;
          case 4:
          if (userAuthentication > 2) {
            int tipo = 0;

            while(tipo == 0) {
              System.out.println("Digite o tipo de usuário (1 - Cliente, 2 - Administrador, 3 - Proprietario): ");
              try {
                tipo = scanner.nextInt();

                if(tipo != 1 && tipo != 2 && tipo != 3) {
                  System.out.println("Usuario Invalido!");
                  tipo = 0;
                }
              } catch (Exception e) {
                System.out.println("Erro: Digite um número válido...");
                scanner.next(); // Limpa a entrada inválida
              }
            }

            Usuario novoUsuario = UserService.CadastrarUsuario(tipo);

            if(novoUsuario == null) {
              userOption = 0;
              break;
            }

            usuariosCadastrados.add(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!\n");

            UserService.AdicionarImoveis(novoUsuario, tipo, imoveisCadastrados);

          } else {
            System.out.println("OPÇÃO INVÁLIDA... POR FAVOR, DIGITE NOVAMENTE!");
          }

          userOption = 0;
          break;

          case 5:
          if (userAuthentication > 2) {
            userOption = UserService.EditarUsuario(usuariosCadastrados, imoveisCadastrados);
          } else {
            System.out.println("OPÇÃO INVÁLIDA... POR FAVOR, DIGITE NOVAMENTE!");
          }
          break;
          case 6:
          if (userAuthentication > 2) {
            Imovel novoImovel = ImovelService.CadastrarImovel();

            if(novoImovel != null) {
              System.out.println("Imóvel cadastrado com sucesso!");
              imoveisCadastrados.add(novoImovel);
            }

          } else {
            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
          }

          userOption = 0;
          break;

          case 7:
          if (userAuthentication > 2) {

            for(int i = 0; i < imoveisCadastrados.size(); i++) {
              System.out.println((i + 1) + "- " + imoveisCadastrados.get(i).getEndereco());
            }

            System.out.print("Escolha o imóvel que deseja editar: ");

            int enderecoId = scanner.nextInt();
            String endereco = imoveisCadastrados.get(enderecoId - 1).getEndereco();

            Imovel imovelParaEditar = ImovelService.BuscarImovel(endereco, imoveisCadastrados);

            if (imovelParaEditar == null) {
              System.out.println("Imóvel não encontrado.");
              userOption = 0;
              break;
            }

            ImovelService.EditarImovel(imovelParaEditar);

          } else {
            System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
          }

          userOption = 0;
          break;

          case 8:
          System.out.println("TROCAR USUARIO...");
          userAuthentication = 0;
          break;

          default:
          System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
          userOption = 0;
        }
      }
    }

    scanner.close();
  }
}
