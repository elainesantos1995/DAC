package beans.item;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.AbstractBean;
import beans.EnderecoPaginas;
import dac.services.ItemService;
import entities.ItemBiblioteca;
import services.impl.ItemServiceImpl;

@ViewScoped
@ManagedBean
public class ItemDelete extends AbstractBean{

	private static final long serialVersionUID = 4804260264032468336L;
	
	private ItemBiblioteca item;
	private ItemService itemService = (ItemService) new ItemServiceImpl();
	
	public String delete() {
		try {
			itemService.delete(item);
		}catch (Exception e) {
			reportarMensagemDeSucesso("Item"+ item.getTitulo()+ "deletado! ");
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL_ITEMDEBIBLIOTECA;
	}

	public ItemBiblioteca getItem() {
		return item;
	}

	public void setItem(ItemBiblioteca item) {
		this.item = item;
	}
	
	
}
