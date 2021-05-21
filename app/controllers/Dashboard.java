package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * The Dashboard class renders a table which has a list of weather related readings for each weather station
 *
 * @author Sheila Kirwan
 * @version baseline
 */


public class Dashboard extends Controller
{

  public static void index() {
    Logger.info("Rendering Dashboard");
    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }

  public static void addStation (String name)
  {
    Station station = new Station (name);
    Logger.info ("Adding a new station called " + name);
    station.save();
    redirect ("/dashboard");
  }


  public static void umbrella() {
    render("umbrella.jpg");
  }
}