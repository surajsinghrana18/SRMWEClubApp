package in.weclub.srmweclubapp;

/**
 * Created by root on 1/4/18.
 */

public class EventInfo {

    private String eventName, speaker, time, venue, evID, date;

    public EventInfo(String name, String spkr, String date, String time, String ven , String ID)
    {
        eventName = name; speaker = spkr; this.time = time; venue = ven; evID = ID; this.date = date;
    }

    public String getName() {return eventName; }
    public String getSpeaker() {return speaker; }
    public String getTime() {return time; }
    public String getVenue() { return venue; }
    public String getEvID() {return evID;}
    public String getDate() {return date;}

    public void setInfo(String name, String spkr, String time, String ven , String ID)
    {
        eventName = name; speaker = spkr; this.time = time; venue = ven; evID = ID;
    }
}
