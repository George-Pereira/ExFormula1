package controller;

public class Posicao 
{
	private int idCarro;
	private double tempo;
	private Posicao next;
	private Posicao previous;
	
	public Posicao(int idCarro, double tempo, Posicao next, Posicao previous) 
	{
		this.idCarro = idCarro;
		this.tempo = tempo;
		this.next = next;
		this.previous = previous;
	}
	public Posicao(int idCarro, double tempo) 
	{
		this.idCarro = idCarro;
		this.tempo = tempo;
	}
	public void setIdCarro(int idCarro) 
	{
		this.idCarro = idCarro;
	}
	public void setTempo(double tempo) 
	{
		this.tempo = tempo;
	}
	public void setNext(Posicao next) 
	{
		this.next = next;
	}
	public void setPrevious(Posicao previous) 
	{
		this.previous = previous;
	}
	public int getIdCarro() 
	{
		return idCarro;
	}
	public double getTempo() 
	{
		return tempo;
	}
	public Posicao getNext() 
	{
		return next;
	}
	public Posicao getPrevious() 
	{
		return previous;
	}
}
