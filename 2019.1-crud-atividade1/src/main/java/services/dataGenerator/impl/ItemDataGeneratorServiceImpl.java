package services.dataGenerator.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dac.services.ItemService;
import dac.services.ServiceDacException;
import entities.ItemBiblioteca;
import entities.Tipo;
import filters.ItemFilter;
import services.dataGenerator.ItemDataGeneratorService;
import services.impl.ItemServiceImpl;
import util.DateUtil;

public class ItemDataGeneratorServiceImpl implements Serializable, ItemDataGeneratorService {

	private static final long serialVersionUID = 3371124651147613246L;

	private ItemService itemService = new ItemServiceImpl();

	
	@Override
	public void generateData() throws ServiceDacException {
		List<ItemBiblioteca> itensAdicionar = new ArrayList<ItemBiblioteca>();
		ItemBiblioteca item = getItemBiblioteca(); 

		ItemFilter itemFilter = new ItemFilter();
		List<ItemBiblioteca> itens = itemService.findBy(itemFilter);

		if (itens.size() == 0) {
			itensAdicionar.add(item);
		} else {
			item = itens.get(itens.size());
		}
		
		for (ItemBiblioteca i : itensAdicionar) {
			itemService.save(i);
		}
	}
	
	private ItemBiblioteca getItemBiblioteca() {
		ItemBiblioteca itemBiblioteca = new ItemBiblioteca();
		itemBiblioteca.setTipo(Tipo.EBOOK);
		itemBiblioteca.setAssunto("Romance");
		itemBiblioteca.setDescricao("É inspirado em um episódio ocorrido no século XIX, no município sertanejo de São José do Belmonte,"
				+ " a 470 quilômetros do Recife, onde uma seita, em 1836, tentou fazer ressurgir o rei Dom Sebastião - transformado em "
				+ "lenda em Portugal depois de desaparecer na África (Batalha de Alcácer-Quibir): sob domínio espanhol, os portugueses "
				+ "sonhavam com a volta do rei que restituiria a nação tomada à força. O sentimento sebastianista ainda hoje é lembrado em"
				+ " Pernambuco, durante a Cavalgada da Pedra do Reino, por manifestação popular que acontece anualmente no local onde inocentes "
				+ "foram sacrificados pela volta do rei.");
		itemBiblioteca.setTitulo("Romance d'A Pedra do Reino e o Príncipe do Sangue do Vai-e-Volta");
		itemBiblioteca.setIsbn(" 1807943100007");
		itemBiblioteca.setEditora("Editora Duetto");
		itemBiblioteca.setId(0);		
		itemBiblioteca.setDataPublicacao(DateUtil.getStartOfDay(new Date()));		
		return itemBiblioteca;
	}

}
