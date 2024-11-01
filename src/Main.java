import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import Entities.Imovel;
import Entities.Usuario;
import Services.ImovelService;
import Services.UserService;

public class Main {

	public static void main(String[] args) {
		
		List<Imovel> imoveisCadastrados = new ArrayList<>();
		List<Usuario> usuariosCadastrados = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		int userAutentication = 0;
		
		while(userAutentication == 0) {
			System.out.println("--------------------");
			System.out.println("     ENTRAR COMO:   ");
			System.out.println("--------------------\n");
			System.out.println("1- Visitante");
			System.out.println("2- Cliente");
			System.out.println("3- Administrador");
			System.out.println("4- Proprietario");
			System.out.println("--------------------\n");
			System.out.print("RESPOSTA: ");
			userAutentication = scanner.nextInt();
			
			switch (userAutentication) {
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
			default:
				System.out.println("DIGITE UM VALOR VALIDO...\n");
				userAutentication = 0;
				break;
			}
			
		}
		
		int userOption = 0;
		
		while(userOption == 0) {
			System.out.println("--------------------");
			System.out.println("        MENU        ");
			System.out.println("--------------------\n");
			
			System.out.println("1- Buscar Imovel");
			
			if(userAutentication > 1) {
				System.out.println("2- Reservar Imovel");	//LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
			}
			
			if(userAutentication > 2) {
				System.out.println("3- Buscar Usuario");
				System.out.println("4- Cadastrar Usuario");	//LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
				System.out.println("5- Editar Usuario");  	//LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
				System.out.println("6- Cadastrar Imovel");  //LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
				System.out.println("7- Editar Imovel");	  	//LEMBRAR DE VALIDAR OS DADOS SE NECESSARIO
			}
			
			if(userAutentication == 4) {
				//OPCIONAL
				System.out.println("8- Gerir Anuncio");
			}

			System.out.println("--------------------\n");
			System.out.print("RESPOSTA: ");
			userOption = scanner.nextInt();
			
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
					
				} catch(NumberFormatException e) {
					
					System.out.println("Erro: Digite um numero valido...");
				}
				
				userOption = 0;
				break;
			case 2:
				if(userAutentication > 1) {
					//DEVE SER CRIADA UMA NOVA RESERVA COM ESSE IMOVEL CASO ELE ESTEJA DISPONIVEL NA DATA DIGITADA
					// O IMOVEL DEVE SER BUSCADO ANTES DE VALIDAR A DISPONIBILIDADE
					// AS DATAS ENTRE O dataInicio E dataFim DA RESERVA DEVEM SER ADICIONADAS A LISTA DE DATAS INDISPONIVEIS DO IMOVEL
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 3:
				if(userAutentication > 2) {
					int escolhaUsuario;
					
					if(usuariosCadastrados.isEmpty()) {
						System.out.println("A LISTA DE USUARIOS	 ESTA VAZIA...");
						userOption = 0;
						break;
					}
					
					for(int i=0; i<usuariosCadastrados.size(); i++) {
						System.out.println((i + 1) + "- " + usuariosCadastrados.get(i).getNome());
					}
					
					try {
						System.out.print("\nESCOLHA UM IMOVEL PARA OBTER MAIS DETALHES: ");
						escolhaUsuario = scanner.nextInt();
						
						String nome = usuariosCadastrados.get(escolhaUsuario-1).getNome();
						
						Usuario usuarioRetornado = UserService.BuscarUsuario(nome, usuariosCadastrados);
						usuarioRetornado.DetalharUsuario();
						
					} catch(NumberFormatException e) {
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
				if(userAutentication > 2) {
					//O USUÁRIO DEVE SER CRIADO COM UMA DAS OPÇÕES DE LOGIN
					//USAMOS O POLIMORFISMO PARA ADICIONA-LOS À LISTA NA MAIN
					//LEMBRAR DE VALIDAR OS DADOS
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 5:
				if(userAutentication > 2) {
					//POSSIBILITAR EDICAO DE USUARIO
					//LEMBRAR DE VALIDAR OS DADOS
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 6:
				if(userAutentication > 2) {
					//CADASTRAR IMOVEL
					//LEMBRAR DE VALIDAR OS DADOS
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 7:
				if(userAutentication > 2) {
					//EDITAR IMOVEL
					//LEMBRAR DE VALIDAR OS DADOS
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 8:
				if(userAutentication == 4) {
					//NÃO SEI OQ FAZER AQUI KKKK
					// TALVEZ COLOCAR UMA LISTA DE ANUNCIOS COM ALGUNS ANUNCIOS PRE-PRONTOS PARA O PROFESSOR PODER MEXER SE QUISER
					// MAS PARA ISSO DEVERIA SER ADICIONADO UMA ENTIDADE DE ANUNCIO
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			default:
				System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
				userOption = 0;
				break;
			}
		}
		
		scanner.close();
	}
}
