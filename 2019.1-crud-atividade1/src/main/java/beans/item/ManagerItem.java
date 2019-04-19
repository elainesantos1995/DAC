package beans.item;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import beans.AbstractBean;
import dac.services.ItemService;
import entities.ItemBiblioteca;
import filters.ItemFilter;
import services.impl.ItemServiceImpl;

@RequestScoped
@ManagedBean
public class ManagerItem extends AbstractBean {

	private static final long serialVersionUID = 1L;

	private ItemService itemService = (ItemService) new ItemServiceImpl();
	private List<ItemBiblioteca> itens;
	private ItemFilter itemFilter;

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<ItemBiblioteca> getItens() {
		return itens;
	}

	public void setItens(List<ItemBiblioteca> itens) {
		this.itens = itens;
	}

	public ItemFilter getItemFilter() {
		return itemFilter;
	}

	public void setItemFilter(ItemFilter itemFilter) {
		this.itemFilter = itemFilter;
	}

	public String filtrar() {
		try {
			itens = itemService.findBy(getItemFilter());
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		return null;
	}
	
	public String limpar() {
		this.itemFilter = new ItemFilter();
		return null;
	}

	@PostConstruct
	public void init() {
		limpar();
		filtrar();
	}

}
