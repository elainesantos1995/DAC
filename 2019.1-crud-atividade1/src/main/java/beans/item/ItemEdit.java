package beans.item;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.AbstractBean;
import beans.EnderecoPaginas;
import dac.services.ItemService;
import dac.services.ServiceDacException;
import entities.ItemBiblioteca;
import filters.ItemFilter;
import services.impl.ItemServiceImpl;

@ViewScoped
@ManagedBean
public class ItemEdit extends AbstractBean{
	
	private static final long serialVersionUID = -7779155604704232174L;
	
	private ItemService itemService = (ItemService) new ItemServiceImpl();
	
	private ItemBiblioteca itemBiblioteca;
	
	private List<ItemBiblioteca> itens;
	
	public ItemEdit() {
		
	}
	
	public void init() {
		try {
		if(itemBiblioteca == null) {
			itemBiblioteca = new ItemBiblioteca();
		}else {
			ItemFilter itemFilter = new ItemFilter();
			itemFilter.setTitulo(itemBiblioteca.getTitulo());
				itens=itemService.findBy(itemFilter);
		}} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			}
		}
	
	public String salvarItem() {
		try {
			if(isEdicaoItem()) {
		//		itemService.update(itemBiblioteca, false);
				itemService.update(itemBiblioteca);
				
			}else {
				itemService.save(itemBiblioteca);
			}
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL_ITEMDEBIBLIOTECA;
	}
	
	public boolean isEdicaoItem() {
		return itemBiblioteca != null && itemBiblioteca.getId() != null;
	}

	public ItemBiblioteca getItemBiblioteca() {
		return itemBiblioteca;
	}

	public void setItemBiblioteca(ItemBiblioteca itemBiblioteca) {
		this.itemBiblioteca = itemBiblioteca;
	}
	
	

}
