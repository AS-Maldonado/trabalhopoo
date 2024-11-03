package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Entities.Administrador;
import Entities.Cliente;
import Entities.Imovel;
import Entities.Proprietario;
import Entities.Reserva;
import Entities.Usuario;


public class UserService {
	
	// Método para validar email
	private static boolean isValidEmail(String email) {
	    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    return pattern.matcher(email).matches();
	}

	// Método para validar telefone
	private static boolean isValidPhone(String phone) {
	    String phoneRegex = "^\\d{11}$"; // Valida se o telefone tem exatamente 11 dígitos
	    Pattern pattern = Pattern.compile(phoneRegex);
	    return pattern.matcher(phone).matches();
	}

    public static Usuario BuscarUsuario(String nome, List<Usuario> usuariosCadastrados) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }
    
    public static Usuario CadastrarUsuario(int tipo) {
        Scanner scanner = new Scanner(System.in);
        Usuario novoUsuario = null;
        List<Imovel> listaFavoritos = new ArrayList<>();
        List<Reserva> historicoReservas = new ArrayList<>();

        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            String email;
            while (true) {
                System.out.print("Digite o email: ");
                email = scanner.nextLine();
                if (isValidEmail(email)) {
                    break; // Sai do loop se o email for válido
                } else {
                    System.out.println("Email inválido. Tente novamente.");
                }
            }

            String telefone;
            while (true) {
                System.out.print("Digite o telefone (deve conter 11 dígitos): ");
                telefone = scanner.nextLine();
                if (isValidPhone(telefone)) {
                    break; // Sai do loop se o telefone for válido
                } else {
                    System.out.println("Telefone inválido. Tente novamente.");
                }
            }

            System.out.print("Digite a senha: ");
            int senha = scanner.nextInt();

            switch (tipo) {
                case 1:
                    novoUsuario = new Cliente(nome, email, telefone, senha, listaFavoritos, historicoReservas);
                    break;
                case 2:
                    novoUsuario = new Administrador(nome, email, telefone, senha, listaFavoritos, historicoReservas);
                    break;
                case 3:
                    List<Imovel> listaImovel = new ArrayList<>();
                    novoUsuario = new Proprietario(nome, email, telefone, senha, listaImovel);
                    break;
                default:
                    System.out.println("Tipo de usuário inválido.");
                    return null;
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante o cadastro: " + e.getMessage());
        }

        return novoUsuario;
    }
    
    public static int EditarUsuario(List<Usuario> usuariosCadastrados, List<Imovel> listaImoveis) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o usuário para editar: ");
        
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            System.out.println((i + 1) + " - " + usuariosCadastrados.get(i).getNome());
        }

        int usuarioId = scanner.nextInt();
        
        if (usuarioId < 1 || usuarioId > usuariosCadastrados.size()) {
            System.out.println("Usuário inválido.");
            return 0;
        }

        Usuario usuarioEditado = usuariosCadastrados.get(usuarioId - 1);

        System.out.print("Novo nome (ou pressione Enter para manter " + usuarioEditado.getNome() + "): ");
        scanner.nextLine(); // Limpar o buffer
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) {
            usuarioEditado.setNome(novoNome);
        }

        String novoEmail;
        while (true) {
            System.out.print("Novo email (ou pressione Enter para manter " + usuarioEditado.getEmail() + "): ");
            novoEmail = scanner.nextLine();
            if (novoEmail.isEmpty()) {
                break; // Sai do loop se o usuário pressionar Enter
            } else if (isValidEmail(novoEmail)) {
                usuarioEditado.setEmail(novoEmail);
                break; // Sai do loop se o email for válido
            } else {
                System.out.println("Email inválido. Tente novamente.");
            }
        }

        String novoTelefone;
        while (true) {
            System.out.print("Novo telefone (ou pressione Enter para manter " + usuarioEditado.getTelefone() + "): ");
            novoTelefone = scanner.nextLine();
            if (novoTelefone.isEmpty()) {
                break; // Sai do loop se o usuário pressionar Enter
            } else if (isValidPhone(novoTelefone)) {
                usuarioEditado.setTelefone(novoTelefone);
                break; // Sai do loop se o telefone for válido
            } else {
                System.out.println("Telefone inválido. Tente novamente.");
            }
        }

        System.out.print("Nova senha (ou pressione Enter para manter): ");
        String novaSenha = scanner.nextLine();
        if (!novaSenha.isEmpty()) {
            usuarioEditado.setSenha(Integer.parseInt(novaSenha));
        }

        System.out.println("Deseja adicionar ou remover imóveis? (1 - Adicionar, 2 - Remover, 3 - Não adicionar/remover): ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            AdicionarImoveis(usuarioEditado, usuarioEditado instanceof Proprietario ? 3 : (usuarioEditado instanceof Cliente ? 1 : 2), listaImoveis);
        } else if (opcao == 2) {
            RemoverImoveis(usuarioEditado, usuarioEditado instanceof Proprietario ? 3 : (usuarioEditado instanceof Cliente ? 1 : 2));
        }

        System.out.println("\nUsuário editado com sucesso!");
        
        return 0;
    }

    
    public static void AdicionarImoveis (Usuario novoUsuario, int tipo, List<Imovel> listaImoveis) {
        Scanner scanner = new Scanner(System.in);
        
        if(listaImoveis.isEmpty()) {
        	System.out.println("Nao e possivel adicionar imoveis as listas de imoveis ou favoritos, pois nao existe um imovel cadastrado...");
        	System.out.println("Edite este usuario cadastrado apos adicionar um imovel ao sistema!");
        	return;
        }
        
        System.out.print("Deseja adicionar um imóvel à lista de favoritos ou imóveis? (1 - Favoritos, 2 - Imóveis, 3 - Nao adicionar): ");
        int adicionarTipo = scanner.nextInt();

        if (adicionarTipo == 1 && (tipo == 1 || tipo == 2)) {
        	System.out.println("Escolha qual endereco adicionar: ");
        	
        	for(int i=0; i<listaImoveis.size(); i++) {
        		System.out.println((i+1) + "- " + listaImoveis.get(i).getEndereco());
        	}
        	
        	int enderecoId = scanner.nextInt();
        	
        	if (enderecoId < 1 || enderecoId > listaImoveis.size()) {
                System.out.println("Usuário inválido.");
                return;
            }
        	
            
            String endereco = listaImoveis.get(enderecoId - 1).getEndereco();
            
            Imovel imovelFavorito = ImovelService.BuscarImovel(endereco, listaImoveis);
            
            if (imovelFavorito != null) {
            	
                if (novoUsuario instanceof Cliente) {
                    ((Cliente) novoUsuario).getListaFavoritos().add(imovelFavorito);
                } else if (novoUsuario instanceof Administrador) {
                    ((Administrador) novoUsuario).getListaFavoritos().add(imovelFavorito);
                }
                
                System.out.println("Imóvel adicionado aos favoritos.");
                
            } else {
                System.out.println("Imóvel não encontrado.");
            }
        } else if (adicionarTipo == 2 && tipo == 3) {
        	
        	System.out.println("Escolha qual endereco adicionar: ");
        	
        	for(int i=0; i<listaImoveis.size(); i++) {
        		System.out.println((i+1) + "- " + listaImoveis.get(i).getEndereco());
        	}	
        	
            int enderecoId = scanner.nextInt();
            String endereco = listaImoveis.get(enderecoId).getEndereco();
            
            Imovel novoImovel = ImovelService.BuscarImovel(endereco, listaImoveis);
            
            if (novoImovel != null) {
                ((Proprietario) novoUsuario).getListaImovel().add(novoImovel);
                System.out.println("Imóvel adicionado à lista de imóveis.");
            } else {
                System.out.println("Imóvel não encontrado.");
            }
        } else {
        	System.out.println("Opção inválida!");
        }
    }

    private static int RemoverImoveis(Usuario usuario, int tipo) {
        Scanner scanner = new Scanner(System.in);
        
        if (tipo == 1 || tipo == 2) {
        	
        	 List<Imovel> listaFavoritos = (tipo == 1) ? ((Cliente) usuario).getListaFavoritos() : ((Administrador) usuario).getListaFavoritos();
        	
        	if(listaFavoritos.isEmpty()) {
            	System.out.println("Nao e possivel adicionar imoveis as listas de favoritos, pois nao existe um imovel cadastrado...");
            	System.out.println("Edite este usuario cadastrado apos adicionar um imovel ao sistema!");
            	return 0;
            }
        	
            System.out.println("Escolha um imóvel para remover da lista de favoritos:");
           
            
            for (int i = 0; i < listaFavoritos.size(); i++) {
                System.out.println((i + 1) + " - " + listaFavoritos.get(i).getEndereco());
            }
            
            int index = scanner.nextInt();
            
            if (index > 0 && index <= listaFavoritos.size()) {
                listaFavoritos.remove(index - 1);
                System.out.println("Imóvel removido da lista de favoritos.");
            } else {
                System.out.println("Índice inválido.");
            }
            
        } else if (tipo == 3) {
        	List<Imovel> listaImoveis = ((Proprietario) usuario).getListaImovel();
        	
        	if(listaImoveis.isEmpty()) {
            	System.out.println("Nao e possivel adicionar imoveis as listas de imoveis, pois nao existe um imovel cadastrado...");
            	System.out.println("Edite este usuario cadastrado apos adicionar um imovel ao sistema!");
            	return 0;
            }
        	
            System.out.println("Escolha um imóvel para remover da sua lista de imóveis:");
            
            for (int i = 0; i < listaImoveis.size(); i++) {
                System.out.println((i + 1) + " - " + listaImoveis.get(i).getEndereco());
            }
            
            int index = scanner.nextInt();
            if (index > 0 && index <= listaImoveis.size()) {
                listaImoveis.remove(index - 1);
                System.out.println("Imóvel removido da lista de imóveis.");
            } else {
                System.out.println("Índice inválido.");
            }
        } else {
        	System.out.println("Opção inválida!");
        }
        
        return 0;
    }

}
