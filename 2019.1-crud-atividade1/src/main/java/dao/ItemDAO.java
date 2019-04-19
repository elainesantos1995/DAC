package dao;

import java.util.List;

import entities.ItemBiblioteca;
import filters.ItemFilter;

public interface ItemDAO {
	
	void save(ItemBiblioteca obj) throws PersistenciaDacException;

	ItemBiblioteca update(ItemBiblioteca obj) throws PersistenciaDacException;

	void delete(ItemBiblioteca obj) throws PersistenciaDacException;

	ItemBiblioteca getByID(Integer objId) throws PersistenciaDacException;

	List<ItemBiblioteca> getAll() throws PersistenciaDacException;

	List<ItemBiblioteca> findBy(ItemFilter filter) throws PersistenciaDacException;

	boolean existeItemBibliotecaComTitulo(ItemBiblioteca item);

}
