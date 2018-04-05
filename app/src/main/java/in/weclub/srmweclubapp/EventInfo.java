package in.weclub.srmweclubapp;

/**
 * Created by root on 1/4/18.
 */

public class EventInfo {

    private String eventName, speaker, time, venue, evID;
    public String retName() {return eventName; }
    public String retSpkr() {return speaker; }
    public String retTime() {return time; }
    public String retVen() { return venue; }
    public String retID() {return evID;}

    public void setInfo(String name, String spkr, String time, String ven , String ID)
    {
        eventName = name; speaker = spkr; this.time = time; venue = ven; evID = ID;
    }
}
