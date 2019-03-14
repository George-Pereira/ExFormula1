package controller;

public class Grid 
{
	protected static Posicao head;
	protected static Posicao tail;
	protected static long size;
	protected static int [] carros = new int[14];
	
	public Grid() 
	{
		head = null;
		tail = null;
		size = 0;
	}
	public static void enviaTempo(Posicao novaPosicao) 
	{
		if(head == null && tail == null && size == 0) 
		{
			novaPosicao.setNext(head);
			head = novaPosicao;
			tail = novaPosicao;
			size++;
		}
		else if(size == 1) 
		{
			if(head.getTempo() < novaPosicao.getTempo())
			{
				novaPosicao.setNext(head);
				head.setPrevious(novaPosicao);
				tail = head;
				head = novaPosicao;
				size++;
			}
			else 
			{
				novaPosicao.setPrevious(head);
				head.setNext(novaPosicao);
				tail = novaPosicao;
				size++;
			}
		}
		else 
		{
			Posicao current = head;
			while(current.getTempo() < novaPosicao.getTempo() && current.getNext() != null) 
			{
				current = current.getNext();
			}
			if(current == tail) 
			{
				tail.setNext(novaPosicao);
				novaPosicao.setPrevious(tail);
				tail = novaPosicao;
				size++;
			}
			else if(current == head) 
			{
				novaPosicao.setNext(head);
				head.setPrevious(novaPosicao);
				head = novaPosicao;
				size++;
			}
			else 
			{
				novaPosicao.setPrevious(current.getPrevious());
				current.getPrevious().setNext(novaPosicao);
				novaPosicao.setNext(current);
				current.setPrevious(novaPosicao);
				size++;
			}
		}
	}
	
	public static void mostraGrid() 
	{
		int CTA = 0;
		Posicao current = head;
		while(current.getNext() != null) 
		{
			System.out.println("Posi��o: " + (CTA+1) + "o.   Carro - " + current.getIdCarro() + "   Tempo da Qualifica��o - " + current.getTempo());
			current = current.getNext();
			CTA++;
		}
	}
}
