package filters;

import java.util.Date;

import dac.services.ServiceDacException;
import entities.Tipo;

public class ItemFilter implements Filter{
	
	private static final long serialVersionUID = 1L;
	
	private Tipo tipo;
	private String titulo;
	private String editora;
	private Date dataPublicacao;
	private String descricao;
	private String isbn;
	private Integer numeroPaginas;
	
	private String assunto;
	private String tags;
	private Integer id;
	
	public ItemFilter() {
		
	}
	
	public boolean isEmpty() {
		if (this.id != null) {
			return false;
		}
		if (this.tipo != null) {
			return false;
		}
		if (this.isbn!= null) {
			return false;
		}
		if (this.descricao != null && !this.descricao.trim().isEmpty()) {
			return false;
		}
		if (this.numeroPaginas != null) {
			return false;
		}
		
		if (this.titulo != null && !this.titulo.trim().isEmpty()) {
			return false;
		}
		if (this.assunto != null && !this.assunto.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ItemFilter [tipo=" + tipo + ", titulo=" + titulo + ", editora=" + editora + ", dataPublicacao="
				+ dataPublicacao + ", descricao=" + descricao + ", isbn=" + isbn + ", numeroPaginas=" + numeroPaginas
				+ ", assunto=" + assunto + ", tags=" + tags + ", id=" + id + "]";
	}
	
	public void validate() throws ServiceDacException {
		if (this.dataPublicacao != null && this.dataPublicacao != null) {
			
		}
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
