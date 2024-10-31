import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import Entities.Imovel;
import Entities.Usuario;

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
		
		//OUTROS MÉTODOS PODEM SER ADICIONADOS AO MENU, COMO EDITAR USUÁRIO, EDITAR IMOVEL, ETC
		// PARA FACILITAR O MANUSEIO DOS USUÁRIOS E IMÓVEIS PODE SER ADICIONADO UMA PROPRIEDADE ID PARA AMBOS
		// SENÃO, A BUSCA DELES DEVERÁ SER REALIZADA PELO NOME DO USUÁRIO OU ENDEREÇO DO IMÓVEL
		
		while(userOption == 0) {
			System.out.println("--------------------");
			System.out.println("        MENU        ");
			System.out.println("--------------------\n");
			
			System.out.println("1- Buscar Imovel");
			
			if(userAutentication > 1) {
				System.out.println("2- Reservar Imovel");	
			}
			
			if(userAutentication > 2) {
				System.out.println("3- Buscar Usuario");
				System.out.println("4- Cadastrar Usuario");
				System.out.println("5- Editar Usuario");
				System.out.println("6- Cadastrar Imovel");
				System.out.println("7- Editar Imovel");	
			}
			
			if(userAutentication == 4) {
				//OPCIONAL
				System.out.println("8- Gerir Anuncio");
			}

			System.out.println("--------------------\n");
			System.out.print("RESPOSTA: ");
			userOption = scanner.nextInt();
			
			//PARA FACILITA
			
			switch(userOption) {
			case 1:
				// A BUSCA PODE SER FEITA MOSTRANDO UMA LISTA COM AS OPÇÕES E O USUÁRIO ESCOLHE QUAL ELE QUER VISUALIZAR
				// O METODO DEVE SER IMPLEMENTADO PENSANDO QUE ELE VAI RETORNAR O IMÓVEL, NÃO MOSTRAR OS PRINTS
				// OS PRINTS SERÃO CONSTRUIDOS NA MAIN
				// É MAIS FÁCIL FAZER ASSIM PARA QUE OUTROS MÉTODOS POSSAM USAR O RETORNO DESSA BUSCA
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
					//BUSCA PARECIDA COM A DO IMÓVEL, MAS PARA USUÁRIO
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 4:
				if(userAutentication > 2) {
					//O USUÁRIO DEVE SER CRIADO COM UMA DAS OPÇÕES DE LOGIN
					// USAMOS O POLIMORFISMO PARA ADICIONA-LOS À LISTA NA MAIN
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 5:
				if(userAutentication > 2) {
					//POSSIBILITAR EDICAO DE USUARIO
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 6:
				if(userAutentication > 2) {
					//CADASTRAR IMOVEL
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 7:
				if(userAutentication > 2) {
					//EDITAR IMOVEL
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
	}

}
