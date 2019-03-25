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
		System.out.println("Carro " + novaPosicao.getIdCarro() + " estabeleceu seu tempo no grid");
		if(head == null && tail == null && size == 0) 
		{
			System.out.println("Carro " + novaPosicao.getIdCarro() + " teve o primeiro tempo da etapa");
			novaPosicao.setNext(head);
			head = novaPosicao;
			tail = novaPosicao;
			size++;
		}
		else if(size == 1) 
		{
			if(head.getTempo() < novaPosicao.getTempo())
			{
				System.out.println("Carro " + novaPosicao.getIdCarro() + " passou pela verificação A");
				novaPosicao.setNext(head);
				head.setPrevious(novaPosicao);
				tail = head;
				head = novaPosicao;
				size++;
			}
			else if (head.getTempo() >= novaPosicao.getTempo())
			{
				System.out.println("Carro " + novaPosicao.getIdCarro() + " passou pela verificação B");
				novaPosicao.setPrevious(head);
				head.setNext(novaPosicao);
				tail = novaPosicao;
				size++;
			}
		}
		else 
		{
			System.out.println("Carro " + novaPosicao.getIdCarro() + " passou pela verificação C");
			Posicao current = head;
			while(current.getTempo() < novaPosicao.getTempo() && current.getNext() != null) 
			{
				current = current.getNext();
			}
			if(current == tail) 
			{
				System.out.println("Carro " + novaPosicao.getIdCarro() + " passou pela verificação D");
				novaPosicao.setPrevious(tail);
				tail.setNext(novaPosicao);
				tail = novaPosicao;
				size++;
			}
			else if(current == head) 
			{
				System.out.println("Carro " + novaPosicao.getIdCarro() + " passou pela verificação E");
				novaPosicao.setNext(head);
				head.setPrevious(novaPosicao);
				head = novaPosicao;
				size++;
			}
			else 
			{
				System.out.println("Carro " + novaPosicao.getIdCarro() + " passou pela verificação F");
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
		System.out.println("\n Grid de Largada - Grand Prix de S.P.A Francorchamps");
		int CTA = 0;
		Posicao current = head;
		while(current != null) 
		{
			System.out.println("Posição: " + (CTA+1) + "o.   Carro - " + current.getIdCarro() + "   Tempo da Qualificação - " + current.getTempo());
			current = current.getNext();
			CTA++;
		}
	}
}
