package Services;

import java.util.List;
import java.util.Scanner;

import Entities.Imovel;

public class ImovelService {
	public static Imovel BuscarImovel(String endereco, List<Imovel> imoveisCadastrados) {
		for(int i=0; i<imoveisCadastrados.size(); i++) {
			if(imoveisCadastrados.get(i).getEndereco().equals(endereco)) {
				return imoveisCadastrados.get(i);
			}
		}
		
		return null;
	}

	public static void CadastrarImovel(String tipo, float area, String endereco, int qtdQuartos, int qtdBanheiros, float valorDiaria,
									   float valorSemanal, float valorMensal, List<String> datasDisponibilidade, String descricao,
									   List<String> fotos, List<Imovel> imoveisCadastrados){
		Imovel imovel = new Imovel(tipo, area, endereco, qtdQuartos, qtdBanheiros, valorDiaria, valorSemanal, valorMensal,
				datasDisponibilidade, descricao, fotos);
		imoveisCadastrados.add(imovel);
	}

	public static void EditarImovel(List<Imovel> imoveis){
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < imoveis.size(); i++) {
			System.out.print((i + 1) + ". ");
			imoveis.get(i).DetalharImovel();
		}

		System.out.println("Selecione o número do imóvel que deseja editar:");
		int escolhaImovel = scanner.nextInt() - 1;
		if (escolhaImovel < 0 || escolhaImovel >= imoveis.size()) {
			System.out.println("Imóvel inválido.");
			return;
		}

		Imovel imovelSelecionado = imoveis.get(escolhaImovel);

		boolean editar = true;
		while (editar) {
			System.out.println("Escolha o dado que deseja editar:");
			System.out.println("1. Tipo");
			System.out.println("2. Área");
			System.out.println("3. Endereço");
			System.out.println("4. Quantidade de Quartos");
			System.out.println("5. Quantidade de Banheiros");
			System.out.println("6. Valor Diária");
			System.out.println("7. Valor Semanal");
			System.out.println("8. Valor Mensal");
			System.out.println("9. Descrição");
			System.out.println("10. Datas de Disponibilidade");
			System.out.println("0. Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.println("Digite o novo tipo:");
					imovelSelecionado.setTipo(scanner.nextLine());
					break;
				case 2:
					System.out.println("Digite a nova área:");
					imovelSelecionado.setArea(scanner.nextFloat());
					break;
				case 3:
					System.out.println("Digite o novo endereço:");
					imovelSelecionado.setEndereco(scanner.nextLine());
					break;
				case 4:
					System.out.println("Digite a nova quantidade de quartos:");
					imovelSelecionado.setQtd_quartos(scanner.nextInt());
					break;
				case 5:
					System.out.println("Digite a nova quantidade de banheiros:");
					imovelSelecionado.setQtd_banheiros(scanner.nextInt());
					break;
				case 6:
					System.out.println("Digite o novo valor da diária:");
					imovelSelecionado.setValor_diaria(scanner.nextFloat());
					break;
				case 7:
					System.out.println("Digite o novo valor semanal:");
					imovelSelecionado.setValor_semanal(scanner.nextFloat());
					break;
				case 8:
					System.out.println("Digite o novo valor mensal:");
					imovelSelecionado.setValor_mensal(scanner.nextFloat());
					break;
				case 9:
					System.out.println("Digite a nova descrição:");
					imovelSelecionado.setDescricao(scanner.nextLine());
					break;
				case 10:
					editarDatasDisponibilidade(imovelSelecionado, scanner);
					break;
				case 0:
					editar = false;
					System.out.println("Edição finalizada.");
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		}
	}
	public static void editarDatasDisponibilidade(Imovel imovel, Scanner scanner) {
		boolean editarDatas = true;
		while (editarDatas) {
			System.out.println("Datas de Disponibilidade Atuais: " + imovel.getDatas_disponibilidade());
			System.out.println("Escolha uma opção:");
			System.out.println("1. Adicionar Data");
			System.out.println("2. Remover Data");
			System.out.println("3. Atualizar Data");
			System.out.println("0. Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpa o buffer

			switch (opcao) {
				case 1:
					System.out.println("Digite a nova data para adicionar (formato: dd/MM/yyyy):");
					String novaData = scanner.nextLine();
					imovel.getDatas_disponibilidade().add(novaData);
					System.out.println("Data adicionada com sucesso!");
					break;
				case 2:
					System.out.println("Digite a data que deseja remover:");
					String dataRemover = scanner.nextLine();
					if (imovel.getDatas_disponibilidade().remove(dataRemover)) {
						System.out.println("Data removida com sucesso!");
					} else {
						System.out.println("Data não encontrada.");
					}
					break;
				case 3:
					System.out.println("Digite a data que deseja atualizar:");
					String dataAtualizar = scanner.nextLine();
					int index = imovel.getDatas_disponibilidade().indexOf(dataAtualizar);
					if (index != -1) {
						System.out.println("Digite a nova data:");
						String novaDataAtualizada = scanner.nextLine();
						imovel.getDatas_disponibilidade().set(index, novaDataAtualizada);
						System.out.println("Data atualizada com sucesso!");
					} else {
						System.out.println("Data não encontrada.");
					}
					break;
				case 0:
					editarDatas = false;
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		}
	}
}
