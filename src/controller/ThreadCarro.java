package controller;

import java.util.concurrent.Semaphore;
import controller.Posicao;
import controller.Grid;
public class ThreadCarro extends Thread
{
	
	private static String [] Scuderia = {"Mercedes-Benz", "Ferrari", "McLaren", "Aston Martin - Red Bull Racing", "Force India", "Alfa Romeo Racing", "Williams"};
	private Semaphore semaforoMerc;
	private Semaphore semaforoFerrari;
	private Semaphore semaforoMcLaren;
	private Semaphore semaforoAmrbr;
	private Semaphore semaforoForce;
	private Semaphore semaforoAlfa;
	private Semaphore semaforoWilliams;
	private Semaphore Pista;
	private int pista=7004;
	private int idEscuderia;
	private int idcarro;
	private static int voltasRegistradas;
	public ThreadCarro(int idEscuderia, int idcarro, Semaphore semaforoMerc, Semaphore semaforoFerrari, Semaphore semaforoMcLaren, Semaphore semaforoAmrbr, Semaphore semaforoForce, Semaphore semaforoAlfa, Semaphore semaforoWilliams, Semaphore Pista)
	{
		this.idEscuderia = idEscuderia;
		this.idcarro = idcarro;
		this.semaforoMerc = semaforoMerc;
		this.semaforoFerrari = semaforoFerrari;
		this.semaforoMcLaren = semaforoMcLaren;
		this.semaforoAmrbr = semaforoAmrbr;
		this.semaforoForce = semaforoForce;
		this.semaforoAlfa = semaforoAlfa;
		this.semaforoWilliams = semaforoWilliams;
		this.Pista = Pista;
	}
	
	public void run()
	{
		if(idEscuderia == 0) 
		{
			try 
			{
				semaforoMerc.acquire();
				Pista.acquire();
				Volta();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoMerc.release();
				Pista.release();
			}
		}
		else if(idEscuderia == 1) 
		{
			try 
			{
				semaforoFerrari.acquire();
				Pista.acquire();
				Volta();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoFerrari.release();
				Pista.release();
			}
		}
		else if (idEscuderia == 2) 
		{
			try 
			{
				semaforoMcLaren.acquire();
				Pista.acquire();
				Volta();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoMcLaren.release();
				Pista.release();
			}
		}
		else if (idEscuderia == 3)
		{
			try 
			{
				semaforoAmrbr.acquire();
				Pista.acquire();
				Volta();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoAmrbr.release();
				Pista.release();
			}
		}
		else if (idEscuderia == 4) 
		{
			try 
			{
				semaforoForce.acquire();
				Pista.acquire();
				Volta();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoForce.release();
				Pista.release();
			}
		}
		else if (idEscuderia == 5) 
		{
			try 
			{
				semaforoAlfa.acquire();
				Pista.acquire();
				Volta();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoAlfa.release();
				Pista.release();
			}
		}
		else
		{
			try 
			{
				semaforoWilliams.acquire();
				Pista.acquire();
				Volta();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				semaforoWilliams.release();
				Pista.release();
			}
		}
		if(voltasRegistradas == 14) 
		{
			Grid.mostraGrid();
		}
	}
	
	private void Volta()
	{
		System.out.println("O Carro " + idcarro + " da Escuderia " + Scuderia[idEscuderia] + " entrou na pista");
		int distPercorrida = 0;
		double melhorTempo = 0;
		int velocidade=0;
		double tempoInicial = 0;
		for(int volta=1;volta<=3;volta++)
		{
			while(distPercorrida<pista)
			{
				tempoInicial = System.nanoTime();
				velocidade = (int) ((Math.random()*160)+140);
				distPercorrida+= velocidade;
				try 
				{
					Thread.sleep(200);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			double tempoFinal = ((System.nanoTime() - tempoInicial)/(Math.pow(10, 8)));
			if(melhorTempo > tempoFinal || melhorTempo == 0) 
			{
				melhorTempo = tempoFinal;
			}
			distPercorrida = 0;
			System.out.println("O Carro " + idcarro + " da Escuderia " + Scuderia[idEscuderia] +" percorreu a pista com o tempo de " + (tempoFinal));
		}
		Grid.enviaTempo(new Posicao(idcarro, melhorTempo));
		System.out.println("O Carro " + idcarro + " da Escuderia " + Scuderia[idEscuderia] + " foi para o Pit Lane");
		voltasRegistradas++;
	}
}
