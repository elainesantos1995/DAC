package services.impl;

import java.io.Serializable;
import java.util.List;

import dac.services.ItemService;
import dac.services.ServiceDacException;
import dao.ItemDAO;
import dao.PersistenciaDacException;
import dao.impl.memory.ItemInMemoriaDB;
import entities.ItemBiblioteca;
import filters.ItemFilter;

public class ItemServiceImpl implements Serializable, ItemService{
	private static final long serialVersionUID = -7803325791425670859L;
	private ItemDAO itemDAO = new ItemInMemoriaDB();

	@Override
	public void save(ItemBiblioteca itemBiblioteca) throws ServiceDacException {
		try {
			itemDAO.save(itemBiblioteca);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
		
	}

	@Override
	public ItemBiblioteca update(ItemBiblioteca item) {
		try {
			return (ItemBiblioteca) itemDAO.update(item);
		} catch (PersistenciaDacException e) {
			try {
				throw new ServiceDacException(e.getMessage(), e);
			} catch (ServiceDacException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void delete(ItemBiblioteca itemBiblioteca) throws ServiceDacException {
		try {
			itemDAO.delete(itemBiblioteca);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public ItemBiblioteca getByID(int itemBibliotecaId) throws ServiceDacException {
		try {
			return itemDAO.getByID(itemBibliotecaId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public List<ItemBiblioteca> getAll() throws ServiceDacException {
		try {
			return itemDAO.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	@Override
	public List<ItemBiblioteca> findBy(ItemFilter filter) throws ServiceDacException {
		try {
			filter.validate();
			return itemDAO.findBy(filter);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

}
