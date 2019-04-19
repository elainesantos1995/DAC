package entities.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import dac.services.ItemService;
import dac.services.ServiceDacException;
import entities.ItemBiblioteca;
import services.impl.ItemServiceImpl;

@FacesConverter(forClass = ItemBiblioteca.class)
public class ItemConversor implements Converter<ItemBiblioteca>{
	
	private ItemService itemService = (ItemService) new ItemServiceImpl();
	
	@Override
	public ItemBiblioteca getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		try {
			int id = Integer.parseInt(value);
			return itemService.getByID(id);
	//		return null;
		} catch (ServiceDacException | NumberFormatException e) {
			String msgErroStr = String.format(
					"Erro de conversão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.",
					value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, ItemBiblioteca value) {
		if (!(value instanceof ItemBiblioteca)) {
			return null;
		}
		
		Integer id = ((ItemBiblioteca) value).getId();
		return (id != null) ? id.toString() : null;
	}

}
