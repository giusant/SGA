package br.si.es.sga.exeception;

public class ValidacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ValidacaoException(String msg, Exception exception){
		super(msg, exception);
	}
	public ValidacaoException(String msg){
		super(msg);
	}
}
