package dac.services;

import java.util.List;

import entities.ItemBiblioteca;
import filters.ItemFilter;

public interface ItemService {

	void save(ItemBiblioteca itemBiblioteca) throws ServiceDacException;

	ItemBiblioteca update(ItemBiblioteca item);

	void delete(ItemBiblioteca itemBiblioteca) throws ServiceDacException;

	ItemBiblioteca getByID(int itemBibliotecaId) throws ServiceDacException;

	List<ItemBiblioteca> getAll() throws ServiceDacException;

	List<ItemBiblioteca> findBy(ItemFilter filter) throws ServiceDacException;

//	boolean senhaConfere(User user, String supostaSenha) throws ServiceDacException;
}
