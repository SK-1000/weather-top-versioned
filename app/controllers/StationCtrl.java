package controllers;

import java.util.List;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;
import java.util.ArrayList;
/* The index method creates a object called station from the station class. It then renders this to the station view.
 * This method also includes algorithm to find the latest temperature value added as a element from an array list
 */


public class StationCtrl extends Controller
{
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    render("station.html", station);
  }



// may need to take this out. This is a new method to handle the route created bringing information from list Readings view

  /**
   * Method to allow the web application to remove a reading from a Station, when the remove reading is button is clicked on the
   * ListReadings View.This will actually remove the reading and delete it from the Station and the database.
   */



  public static void deletereading (Long id, Long readingid)
  {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing " + reading.code);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }


  /**
   * Method to allow the web application to add a reading from a Station, when the remove reading is button is clicked on the
   * ListReadings View.This will actually remove the reading and delete it from the Station and the database.
   */

  public static void addReading (Long id, int code, double temp, double windSpeed, int pressure)
  {
    Reading reading = new Reading(code, temp, windSpeed, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect ("/station/" + id);
  }




}