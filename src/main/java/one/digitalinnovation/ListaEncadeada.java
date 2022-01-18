package one.digitalinnovation;

public class ListaEncadeada<T> {
	
	No<T> noRefEntrada;
	
	public ListaEncadeada() {
		this.noRefEntrada = null;
	}
	
	public void add(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if(this.isEmpty()) {
			noRefEntrada = novoNo;
			return;
		}
		No<T> noAuxiliar = noRefEntrada;
		for(int i = 0; i < this.size()-1; i++) {
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		noAuxiliar.setProximoNo(novoNo);
	}
	
	public T get(int index) {
		return getNo(index).getConteudo();
	}
	
	private No<T> getNo(int index) {
		validaIndice(index);
		No<T> noAuxiliar = noRefEntrada;
		No<T> noRetorno = null;
		for (int i = 0; i <= index; i++) {
			noRetorno = noAuxiliar;
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		return noRetorno;
	}
	
	public T remove(int index) {
		No<T> noPivor = this.getNo(index);
		if(index == 0) {
			noRefEntrada = noPivor.getProximoNo();
			return noPivor.getConteudo();
		}
		No<T> noAnterior = getNo(index - 1);
		noAnterior.setProximoNo(noPivor.getProximoNo());
		return noPivor.getConteudo();
	}
	
	public int size() {
		int tamanhoLista = 0;
		No<T> noRefAuxiliar = noRefEntrada;
		while(true) {
			if(noRefAuxiliar != null) {
				tamanhoLista++;
				if(noRefAuxiliar.getProximoNo() != null) {
					noRefAuxiliar = noRefAuxiliar.getProximoNo();
				} else {
					break;
				}
			} else {
				break;
			}
		}
		return tamanhoLista;
	}
	
	public void validaIndice(int index) {
		if(index >= size()) {
			int ultimoIndice = size() - 1;
			throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index
					+ " desta lista. Esta lista só vai até o índice " + ultimoIndice);
		}
	}
	
	public boolean isEmpty( ) {
		return noRefEntrada == null ? true : false;
	}

	@Override
	public String toString() {
		String strRetorno = "";
		No<T> noAuxiliar = noRefEntrada;
		for(int i = 0; i < this.size(); i++) {
			strRetorno += "{No [conteudo=" + noAuxiliar.getConteudo() + "]}--->";
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		strRetorno += "null";
		return strRetorno;
	}
	
	
	
}
