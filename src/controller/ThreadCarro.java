package controller;

import java.util.concurrent.Semaphore;
import controller.Posicao;
import controller.Grid;
public class ThreadCarro extends Thread
{
	
	private static int [] Escuderia = new int[7];
	private Semaphore semaforo;
	private int pista=7004;
	private int idEscuderia;
	private int idcarro;	
	public ThreadCarro(int idEscuderia, int idcarro, Semaphore semaforo)
	{
		this.idEscuderia = idEscuderia;
		this.idcarro = idcarro;
		this.semaforo = semaforo;
	}
	
	public void run()
	{
		try 
		{
			semaforo.acquire();
			if(Escuderia[idEscuderia] < 2)
			{
				Escuderia[idEscuderia]++;
				Volta();
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			Escuderia[idEscuderia]--;
			semaforo.release();
			if(Escuderia[0] == 0 && Escuderia[1] == 0 && Escuderia[2] == 0 && Escuderia[3] == 0 && Escuderia[4] == 0 && Escuderia[5] == 0 && Escuderia[6] == 0) 
			{
				Grid.mostraGrid();
			}
		}
	}
	
	private void Volta()
	{
		System.out.println("O carro " + idcarro + " da Escuderia " + idEscuderia + " entrou na pista");
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
			System.out.println("O carro " + idcarro + " da Escuderia " + idEscuderia +" percorreu a pista com o tempo de " + (tempoFinal));
		}
		Grid.enviaTempo(new Posicao(idcarro, melhorTempo));
		System.out.println("O Carro " + idcarro + " da Escuderia " + idEscuderia + " foi para o Pit Lane");
	}
}
