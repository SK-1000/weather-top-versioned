package controllers;

import models.Member;
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
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render ("dashboard.html", stations);
  }

  public static void addStation (String name, String latitude, String longitude)
  {
    Logger.info ("Adding a new station called " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station (name,latitude,longitude);
    member.stations.add(station);
    member.save();
    redirect ("/dashboard");
  }


}