package Services;

import java.util.List;

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
}
