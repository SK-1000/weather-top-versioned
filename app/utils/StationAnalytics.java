package utils;

import models.Reading;

import java.util.List;

import java.lang.Math;
import java.util.Collections;

public class StationAnalytics {


  public static double getLatestTemp(List<Reading> readings) {
    Reading latestReading = null;
    double latestTemp = 0.;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestTemp = latestReading.temp;
    }
    return latestTemp;
  }




  public static double getLatestPressure(List<Reading> readings) {
    Reading latestReading = null;
    double latestPressure = 0;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestPressure = latestReading.pressure;
    }
    return latestPressure;
  }


  public static String getWeatherCode(List<Reading> readings) {
    Reading latestReading = null;
    String codeDefinition = "invalid code";
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      switch (latestReading.code) {
        case 100:
          codeDefinition = "clear";
          break;
        case 200:
          codeDefinition = "partial clouds";
          break;
        case 300:
          codeDefinition = "cloudy";
          break;
        case 400:
          codeDefinition = "light showers";
          break;
        case 500:
          codeDefinition = "heavy showers";
          break;
        case 600:
          codeDefinition = "rain";
          break;
        case 700:
          codeDefinition = "snow";
          break;
        case 800:
          codeDefinition = "thunder";
          break;
        default:
          codeDefinition = "invalid code";
      }
    }
    return codeDefinition;
  }

  public static String getLatestWind(List<Reading> readings) {

    Reading latestReading = null;
    String beaufort = "No Wind Info Available";
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);

      if (latestReading.windSpeed <= 1) {
        beaufort = "0 hpa";
      } else if (latestReading.windSpeed > 1 && latestReading.windSpeed <= 5) {
        beaufort = "1 hpa";
      } else if (latestReading.windSpeed >= 6 && latestReading.windSpeed <= 11) {
        beaufort = "2 hpa";
      } else if (latestReading.windSpeed > 12 && latestReading.windSpeed <= 19) {
        beaufort = "3 hpa";
      } else if (latestReading.windSpeed > 20 && latestReading.windSpeed <= 28) {
        beaufort = "4 hpa";
      } else if (latestReading.windSpeed > 29 && latestReading.windSpeed <= 38) {
        beaufort = "5 hpa";
      } else if (latestReading.windSpeed > 39 && latestReading.windSpeed <= 49) {
        beaufort = "6 hpa";
      } else if (latestReading.windSpeed > 50 && latestReading.windSpeed <= 61) {
        beaufort = "7 hpa";
      } else if (latestReading.windSpeed >= 62 && latestReading.windSpeed <= 74) {
        beaufort = "8 hpa";
      } else if (latestReading.windSpeed > 75 && latestReading.windSpeed <= 88) {
        beaufort = "9 hpa";
      } else if (latestReading.windSpeed > 89 && latestReading.windSpeed <= 102) {
        beaufort = "10 hpa";
      } else if (latestReading.windSpeed > 103 && latestReading.windSpeed <= 117) {
        beaufort = "11 hpa";
      }
    }
    return beaufort;
  }



  public static String getWindDirection(List<Reading> readings) {
    Reading latestReading = null;
    String convertToTextDir = "invalid Direction";
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      if ((latestReading.windDirection >= 348.75) && (latestReading.windDirection <= 360) || (latestReading.windDirection >= 0) &&
          (latestReading.windDirection <= 11.25)) {
        convertToTextDir = "North"; }
      else if ((latestReading.windDirection >=11.25) && (latestReading.windDirection <=33.75)) {
        convertToTextDir = "North North East";}
      else if ((latestReading.windDirection >=33.75) && (latestReading.windDirection <=56.25)) {
        convertToTextDir = "North East";}
      else if ((latestReading.windDirection >=56.25) && (latestReading.windDirection <=78.75)) {
        convertToTextDir = "East North East";}
      else if ((latestReading.windDirection >=78.25) && (latestReading.windDirection <=101.25)) {
        convertToTextDir = "East";}
      else if ((latestReading.windDirection >=101.25) && (latestReading.windDirection <=123.75)) {
        convertToTextDir = "East South East";}
      else if ((latestReading.windDirection >=123.75) && (latestReading.windDirection <=146.25)) {
        convertToTextDir = "South East";}
      else if ((latestReading.windDirection >=146.25) && (latestReading.windDirection <=168.75)) {
        convertToTextDir = "South South East";}
      else if ((latestReading.windDirection >=168.75) && (latestReading.windDirection <=191.25)) {
        convertToTextDir = "South";}
      else if ((latestReading.windDirection >=191.25) && (latestReading.windDirection <=213.75)) {
        convertToTextDir = "South South West";}
      else if ((latestReading.windDirection >=213.75) && (latestReading.windDirection <=236.25)) {
        convertToTextDir = "South West";}
      else if ((latestReading.windDirection >=236.25) && (latestReading.windDirection <=258.75)) {
        convertToTextDir = "West South West";}
      else if ((latestReading.windDirection >=258.75) && (latestReading.windDirection <=281.25)) {
        convertToTextDir = "West";}
      else if ((latestReading.windDirection >=281.25) && (latestReading.windDirection <=303.75)) {
        convertToTextDir = "West North West";}
      else if ((latestReading.windDirection >=303.75) && (latestReading.windDirection <=326.25)) {
        convertToTextDir = "North West";}
      else if ((latestReading.windDirection >=236.25) && (latestReading.windDirection <=348.75)) {
        convertToTextDir = "North North West";}

    }
    return convertToTextDir;
  }


  // Wind Chill calculation



  public static double getWindChill(List<Reading> readings) {
    Reading latestReading = null;
    double latestWindChill = 0;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestWindChill = Math.round(13.12 + 0.6215*latestReading.temp -  11.37*Math.pow(latestReading.windSpeed, 0.16) + 0.3965*latestReading.temp*Math.pow(latestReading.windSpeed, 0.16));
      System.out.print("The wind chill index is " + latestWindChill);
    }
    return latestWindChill;
  }



}

