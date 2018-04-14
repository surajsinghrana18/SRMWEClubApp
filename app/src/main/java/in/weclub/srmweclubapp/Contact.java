package in.weclub.srmweclubapp;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Contact {
    private String fname,lname, UID, mobNo;
    private static String Uid;
    Contact(String uid, String m, String fn, String ln)
    {
        UID = uid;
        mobNo = m;
        fname = fn;
        lname = ln;
    }

    Contact(String m, String fn, String ln)
    {
        mobNo = m;
        fname = fn;
        lname = ln;
    }


    public void setFname(String fname){
        this.fname = fname;
    }
    public String getFname(){
        return (this.fname);
    }
    public void setLname(String fname){
        this.lname = lname;
    }
    public String getLname(){
        return (this.lname);
    }
    public void setMobno(String mobno){
        this.mobNo = mobno;
    }
    public String getMobNo(){
        return mobNo;
    }
    public String getUID() {return UID;}
    public static void setid(String s) {Uid = s;}
    public static String getid() {return Uid;}
}
