package beans;

public final class EnderecoPaginas {

	public EnderecoPaginas() {
		throw new UnsupportedOperationException("Esta classe não deve ser instanciada!");
	}

	private static final String REDIRECT_TRUE = "?faces-redirect=true";

	public static final String PAGINA_PRINCIPAL = "/index.xhtml" + REDIRECT_TRUE;
	
	public static final String PAGINA_PRINCIPAL_ITEMDEBIBLIOTECA = "/paginas/item/index.xhtml" + REDIRECT_TRUE;

}
