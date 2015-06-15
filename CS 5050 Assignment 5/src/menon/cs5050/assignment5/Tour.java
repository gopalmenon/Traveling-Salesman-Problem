package menon.cs5050.assignment5;

import java.util.ArrayList;
import java.util.List;

public class Tour {

	private List<City> citiesInTour;
	private double tourLength;
	
	public Tour(List<City> citiesInTour, double tourLength) {
		this.citiesInTour = citiesInTour;
		this.tourLength = tourLength;
	}
	
	public Tour(Tour tourToClone) {
		this.citiesInTour = new ArrayList<City>(tourToClone.getCitiesInTour());
		this.tourLength = tourToClone.getTourLength();
	}
	
	public List<City> getCitiesInTour() {
		return citiesInTour;
	}
	public void setCitiesInTour(List<City> citiesInTour) {
		this.citiesInTour = citiesInTour;
	}
	public double getTourLength() {
		return tourLength;
	}
	public void setTourLength(double tourLength) {
		this.tourLength = tourLength;
	}
	
	private City getLastCity() {
		return this.citiesInTour.get(this.citiesInTour.size() - 1);
	}
	
	/**
	 * Add a city to the tour by appending the cities array with the new city and incrementing the tour length by the distance from
	 * the last city to the new city
	 * @param cityToAdd
	 */
	public void addCity(City cityToAdd) {
		
		this.citiesInTour.add(cityToAdd);
		this.tourLength += getLastCity().distanceTo(cityToAdd);
		
	}
	
	@Override
	public String toString() {
		
		StringBuffer returnValue = new StringBuffer();
		
		returnValue.append("[");
		
		boolean firstTime = true;
		for (City city : this.citiesInTour) {
			
			if (firstTime) {
				firstTime = false;
			} else {
				returnValue.append(", ");
			}
			
			returnValue.append(city.toString());
			
		}
		
		returnValue.append("]");
		
		return returnValue.toString();
		
	}
	
}