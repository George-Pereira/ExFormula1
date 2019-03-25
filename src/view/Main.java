package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;
import java.util.Random;
public class Main 
{

	public static void main(String[] args) 
	{
		int permissoes = 1;
		Random r = new Random();
		Semaphore semaforoMerc = new Semaphore(permissoes);
		Semaphore semaforoFerrari = new Semaphore(permissoes);
		Semaphore semaforoMcLaren = new Semaphore(permissoes);
		Semaphore semaforoAmrbr = new Semaphore(permissoes);
		Semaphore semaforoForce = new Semaphore(permissoes);
		Semaphore semaforoAlfa = new Semaphore(permissoes);
		Semaphore semaforoWilliams = new Semaphore(permissoes);
		Semaphore semaforoPista = new Semaphore(5);
		int idCarro = 0;
		int Escuderia[] = new int [7];
		int Scuderia = 0;
		for(int CTA = 0; CTA<14; CTA++) 
		{
			idCarro++;
			Scuderia = r.nextInt(7);
			while(Escuderia[Scuderia] >= 2) 
			{
				Scuderia = r.nextInt(7);
			}
			Escuderia[Scuderia]++;
			Thread t1 = new ThreadCarro(Scuderia, idCarro, semaforoMerc, semaforoFerrari, semaforoMcLaren, semaforoAmrbr, semaforoForce, semaforoAlfa, semaforoWilliams, semaforoPista);
			t1.start();
		}
	}

}
