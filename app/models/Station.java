package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

/**
 * The Station class creates a list of weather codes within each weather station.
 *
 * @author Sheila Kirwan
 * @version baseline
 */



/**
 * Constructor for objects of class Station
 * @param location a string which describes the location of a weatherstation
 * @param codes a list array of the weather codes that relate to a particular weatherstation

 */

@Entity
public class Station extends Model
{
  public String name;
  public String latitude;
  public String longitude;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public double latestTemperature;
  public double latestPressure;
  public String latestWeatherCodeStr;
  public String beaufort;
  public String convertToTextDir;
  public double latestWindChill;

  public Station(String name,String latitude,String longitude)
  {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}