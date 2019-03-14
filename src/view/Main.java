package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Main 
{

	public static void main(String[] args) 
	{
		int permissoes = 5;
		Semaphore semaforo = new Semaphore(permissoes);
		int idCarro = 0;
		for(int CTA = 0; CTA<2; CTA++) 
		{
			for(int CTAB = 1; CTAB<8;CTAB++) 
			{
				idCarro++;
				Thread t1 = new ThreadCarro(CTAB-1, idCarro, semaforo);
				t1.start();
			}
		}
	}

}
