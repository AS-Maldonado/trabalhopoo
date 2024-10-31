import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import Entities.Imovel;

public class Main {

	public static void main(String[] args) {
		
		List<Imovel> imoveisCadastrados = new ArrayList<>();
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
			System.out.println("2- Detalhes do Imovel");
			
			if(userAutentication > 1) {
				System.out.println("3- Reservar Imovel");	
			}
			
			if(userAutentication > 2) {
				System.out.println("4- Cadastrar Usuario");
				System.out.println("5- Editar Usuario");
				System.out.println("6- Cadastrar Imovel");
				System.out.println("7- Editar Imovel");
			}
			
			if(userAutentication == 4) {
				System.out.println("8- Gerir Anuncio");	
			}

			System.out.println("--------------------\n");
			System.out.print("RESPOSTA: ");
			userOption = scanner.nextInt();
			
			//PARA FACILITA
			
			switch(userOption) {
			case 1:
				// A BUSCA PODE SER FEITA ATRAVÉS DE UMA BUSCA POR STRING, DIGITANDO O ENDEREÇO DO IMOVEL E ENTÃO COMPARANDO COM OS QUE ESTÃO NA LISTA
				// DEVE SER RETORNADO O IMOVEL
				break;
			case 2: 
				//UM IMOVEL DEVE SER ENCONTRADO NA LISTA PRIMEIRO, PARA DEPOIS O MÉTODO DENTRO DESSE OBJETO SER CHAMADO
				break;
			case 3:
				if(userAutentication > 1) {
					//DEVE SER CRIADA UMA NOVA RESERVA COM ESSE IMOVEL CASO ELE ESTEJA DISPONIVEL NA DATA DIGITADA
					// O IMOVEL DEVE SER BUSCADO ANTES DE VALIDAR A DISPONIBILIDADE
					// AS DATAS ENTRE O dataInicio E dataFim DA RESERVA DEVEM SER ADICIONADAS A LISTA DE DATAS INDISPONIVEIS DO IMOVEL
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 4:
				if(userAutentication > 2) {
					//UM NOVO USUARIO DEVE SER CADASTRADO
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 5:
				if(userAutentication > 2) {
					//UM NOVO IMOVEL DEVE SER CADASTRADO
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 6:
				if(userAutentication > 2) {
					//POSSIBILITAR EDICAO DE IMOVEL
				} else {
					System.out.println("OPCAO INVALIDA... POR FAVOR, DIGITE NOVAMENTE!");
					userOption = 0;
				}
				break;
			case 7:
				if(userAutentication > 2) {
					//POSSIBILITAR EDICAO DE USUARIO
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
