package in.weclub.srmweclubapp;

public class Contact {
    int mobNo;
    String fname,lname,email,pass;
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
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return (this.email);
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getPass(){
        return (this.pass);
    }
    public void getMobno(int mobno){
        this.mobNo = mobno;
    }
    public int getMobNo(){
        return(this.mobNo);
    }
}
