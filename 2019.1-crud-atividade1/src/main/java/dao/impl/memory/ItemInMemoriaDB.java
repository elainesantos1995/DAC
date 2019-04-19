package dao.impl.memory;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.ItemDAO;
import dao.PersistenciaDacException;
import entities.ItemBiblioteca;
import filters.ItemFilter;


public class ItemInMemoriaDB extends DAO implements ItemDAO{

	private static final long serialVersionUID = 1L;

	private InMemoryDB db = new InMemoryDB();

	public List<ItemBiblioteca> getAll() throws PersistenciaDacException {
		List<ItemBiblioteca> resultado = new ArrayList<>();
		for (ItemBiblioteca obj : db.getAll(ItemBiblioteca.class)) {
			resultado.add(obj.clone());
		}
		return resultado;
	}

	@Override
	public void save(ItemBiblioteca obj) throws PersistenciaDacException {
		db.save(obj);		
	}

	@Override
	public ItemBiblioteca update(ItemBiblioteca obj) throws PersistenciaDacException {
		return (ItemBiblioteca) db.update(obj);
	}

	@Override
	public void delete(ItemBiblioteca obj) throws PersistenciaDacException {
		db.delete(obj);
	}

	@Override
	public ItemBiblioteca getByID(Integer objId) throws PersistenciaDacException {
		return (ItemBiblioteca) db.getByID(objId).clone();
	}

	@Override
	public List<ItemBiblioteca> findBy(ItemFilter filter) throws PersistenciaDacException {
		List<ItemBiblioteca> allObjs = getAll();

		if (filter == null || filter.isEmpty()) {
			return allObjs;
		}

		List<ItemBiblioteca> resultado = new ArrayList<>();
		for (ItemBiblioteca itemBiblioteca : allObjs) {
			
			if (notEmpty(filter.getTitulo())) {
				if (!contains(itemBiblioteca.getTitulo(), filter.getTitulo())) {
					continue;
				}
			}

			if (notEmpty(filter.getTipo())) {
				if (!contains(itemBiblioteca.getAssunto(), filter.getAssunto())) {
					continue;
				}
			}

			if (notEmpty(filter.getDescricao())) {
				if (!contains(itemBiblioteca.getDescricao(), filter.getDescricao())) {
					continue;
				}
			}

			if (notEmpty(filter.getEditora())) {
				if (!contains(itemBiblioteca.getEditora(), filter.getIsbn())) {
					continue;
				}
			}
			
		}

	 	return resultado;

	}

	@Override
	public boolean existeItemBibliotecaComTitulo(ItemBiblioteca item) {
		if (item== null) {
			return false;
		}
		for (ItemBiblioteca aItem : db.getAll(ItemBiblioteca.class)) {
			if (aItem.getId().equals(item.getId())) continue;
			
			boolean loginIgual = aItem.getTitulo().trim().equalsIgnoreCase(item.getTitulo());
			if (loginIgual) {
				return true;
			}
		}
		return false;
	}
	
}
