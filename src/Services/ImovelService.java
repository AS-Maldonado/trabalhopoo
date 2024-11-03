package Services;

import Entities.Imovel;
import Enums.TipoImovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImovelService {
    private static final Scanner scanner = new Scanner(System.in);

    public static Imovel BuscarImovel(String endereco, List<Imovel> imoveisCadastrados) {
        for (Imovel imovel : imoveisCadastrados) {
            if (imovel.getEndereco().equals(endereco)) {
                return imovel;
            }
        }
        return null;
    }

    public static Imovel CadastrarImovel() {
        Scanner scanner = new Scanner(System.in);
        String tipo = "";
        
        System.out.println("Escolha o tipo de imóvel:");
        
        int tipoEscolhido = 0;
        
        try {
        	while(tipoEscolhido == 0) {
        		for (TipoImovel tipoImovel : TipoImovel.values()) {
                    System.out.println(tipoImovel.ordinal() + 1 + " - " + tipoImovel);
                }
            	
                tipoEscolhido = scanner.nextInt();
                
                if (tipoEscolhido < 1 || tipoEscolhido > TipoImovel.values().length) {
    		        System.out.println("Tipo de imóvel inválido!");
    		        System.out.println("TENTE NOVAMENTE: \n");
    		        tipoEscolhido = 0;
                } 
        	}
        	
            tipo = TipoImovel.values()[tipoEscolhido - 1].name();

            System.out.print("Digite a área em m²: ");
            float area = scanner.nextFloat();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Digite o endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite a quantidade de quartos: ");
            int qtdQuartos = scanner.nextInt();

            System.out.print("Digite a quantidade de banheiros: ");
            int qtdBanheiros = scanner.nextInt();

            System.out.print("Digite o valor da diária: ");
            float valorDiaria = scanner.nextFloat();

            System.out.print("Digite o valor semanal: ");
            float valorSemanal = scanner.nextFloat();

            System.out.print("Digite o valor mensal: ");
            float valorMensal = scanner.nextFloat();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Digite uma descrição: ");
            String descricao = scanner.nextLine();

            return new Imovel(tipo, area, endereco, qtdQuartos, qtdBanheiros, valorDiaria, valorSemanal, valorMensal, new ArrayList<>(), descricao, new ArrayList<>());
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o imóvel...");
            return null;
        }
    }


    public static void EditarImovel(Imovel imovel) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Editando imóvel: " + imovel.getEndereco());

        try {
            // Editar tipo de imóvel
            System.out.println("Escolha o novo tipo de imóvel (ou pressione Enter para manter):");
            int tipoEscolhido = -1;

            while (tipoEscolhido == -1) {
                for (TipoImovel tipoImovel : TipoImovel.values()) {
                    System.out.println(tipoImovel.ordinal() + 1 + " - " + tipoImovel);
                }
                System.out.print("Digite o número correspondente: ");
                if (scanner.hasNextInt()) {
                    tipoEscolhido = scanner.nextInt();
                    if (tipoEscolhido < 1 || tipoEscolhido > TipoImovel.values().length) {
                        System.out.println("Tipo de imóvel inválido! Tente novamente.");
                        tipoEscolhido = -1;
                    }
                } else {
                    scanner.nextLine(); // Limpa o buffer se não for um inteiro
                    tipoEscolhido = 0;
                }
            }

            if (tipoEscolhido > 0) {
                imovel.setTipo(TipoImovel.values()[tipoEscolhido - 1].name());
            }

            System.out.print("Digite a nova área em m² (ou -1 para manter): ");
            float novaArea = scanner.nextFloat();
            if (novaArea >= 0) {
                imovel.setArea(novaArea);
            }

            System.out.print("Digite a nova quantidade de quartos (ou -1 para manter): ");
            int novaQtdQuartos = scanner.nextInt();
            if (novaQtdQuartos >= 0) {
                imovel.setQtd_quartos(novaQtdQuartos);
            }

            System.out.print("Digite o novo valor da diária (ou -1 para manter): ");
            float novoValorDiaria = scanner.nextFloat();
            if (novoValorDiaria >= 0) {
                imovel.setValor_diaria(novoValorDiaria);
            }

            System.out.print("Digite o novo valor semanal (ou -1 para manter): ");
            float novoValorSemanal = scanner.nextFloat();
            if (novoValorSemanal >= 0) {
                imovel.setValor_semanal(novoValorSemanal);
            }

            System.out.print("Digite o novo valor mensal (ou -1 para manter): ");
            float novoValorMensal = scanner.nextFloat();
            if (novoValorMensal >= 0) {
                imovel.setValor_mensal(novoValorMensal);
            }

            scanner.nextLine();

            System.out.print("Digite uma nova descrição (ou pressione Enter para manter): ");
            String novaDescricao = scanner.nextLine();
            if (!novaDescricao.isEmpty()) {
                imovel.setDescricao(novaDescricao);
            }

            System.out.println("Imóvel atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao editar o imóvel: " + e.getMessage());
        }
    }



}
