package br.si.es.sga.exeception;

public class LogicException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LogicException(String msg, Exception exception){
		super(msg, exception);
	}
	public LogicException(String msg){
		super(msg);
	}
}
