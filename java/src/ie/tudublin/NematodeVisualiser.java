package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();
		printNematodes();			
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);

		}
	}

	public void printNematodes()
	{
		for(Nematode n:nematodes)
		{
			System.out.println(n);
		}
	}

	public void arrows()
	{
		stroke(255);

		line(100, 400, 250, 400);
		line(100, 400, 150, 425);
		line(100, 400, 150, 375);

		line(700, 400, 550, 400);
		line(700, 400, 650, 425);
		line(700, 400, 650, 375);
	}


	public void draw()
	{
		arrows();
	}
}
