package models;
import javax.persistence.Entity;

import net.sf.ehcache.search.parser.MValue;
import play.db.jpa.Model;

import java.math.BigDecimal;
/**
 * The Code class which creates the parameters relating to the Weather readings
 *
 * @author Sheila Kirwan
 * @version baseline
 */



/**
 * Constructor for objects of class Code
 * @param code Code Number that describes a particular condition
 * @param temp a decimal number which relates to the temperature
 * @param windSpeed a decimal number which describes the wind Speed
 */


@Entity
public class Reading extends Model {

  public int code;
  public double temp;
  public double windSpeed;
  public int pressure;
  public double windDirection;


  public Reading(int code, double temp, double windSpeed, int pressure, double windDirection ) {
    this.code = code;
    this.temp = temp;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
  }



}