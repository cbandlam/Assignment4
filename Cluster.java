package Assignment3;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
* 
* @author Chandana Bandlamudi 1220495432
* version 1.0
*/ 
public class Cluster {
	
	public ArrayList<ArrayList<City>> clustering (ArrayList<City> cities)
	{

		int numOfClusters =(Integer.parseInt( JOptionPane.showInputDialog("Enter the Number of Clusters")));
		int citySize = cities.size();
		
		ArrayList<City> centroids = new ArrayList<City>();
		ArrayList<ArrayList<City>> routelist = new ArrayList<ArrayList<City>>();
		if(numOfClusters > citySize)
		{
			JOptionPane.showInputDialog("We can't have more clusters then the citysize");
		}
		else
		{
			for(int i = 0 ; i < numOfClusters ; i++)
			{
				centroids.add(cities.get(i));
				ArrayList<City> routes = new ArrayList<City>();
				routes.add(cities.get(i));
				routelist.add(routes);
			}
			for (int i = numOfClusters; i < citySize; i++)
			{
				ArrayList<Double> distanceMatrix = new ArrayList<Double>();
				for(int j =0 ; j < numOfClusters ; j++)
				{
					distanceMatrix.add(distanceCaluclation(cities.get(i), centroids.get(j)));

				}
				int indexOfMinimum = distanceMatrix.indexOf(Collections.min(distanceMatrix));
				routelist.get(indexOfMinimum).add(cities.get(i));
				City c = centroids.remove(indexOfMinimum);
				City newCity = new City(c.getLabel(), (c.getX()+cities.get(i).getX())/2, (c.getY()+cities.get(i).getY())/2 , 10,10);
				centroids.add(indexOfMinimum, newCity);
			}
			
			
		}
		for( int i =0;i <numOfClusters; i++)
		{
			routelist.get(i).add(centroids.get(i));
		}
		return routelist;
	}
	
	public double distanceCaluclation(City src, City dest)
	{
		double x1 = src.getX(), y1 = src.getY(), x2 = dest.getX(), y2 = dest.getY();
        return Math.sqrt((x1 + x2) * Math.abs(x1 - x2) + (y1 + y2) * Math.abs(y1 - y2));
	}
	

}
