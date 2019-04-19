package beans.dataGenerator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dac.DacRuntimeException;
import dac.services.ServiceDacException;
import services.dataGenerator.ItemDataGeneratorService;
import services.dataGenerator.impl.ItemDataGeneratorServiceImpl;

@ManagedBean
@ApplicationScoped
public class InitDatabaseIfNeeded {

	private ItemDataGeneratorService itemDataGeneratorService = new ItemDataGeneratorServiceImpl();
	
	@PostConstruct
	public void postConstruct() {
		
		try {
			itemDataGeneratorService.generateData();
		} catch (ServiceDacException e) {
			throw new DacRuntimeException("Ocorreu algum erro ao tentar inicializar a base de dados.", e);
		}
	}
	
}
