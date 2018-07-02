package in.weclub.srmweclubapp;


public class VendorInfo {
    private String vendorName, vendorLoc, offer, vendorImage, offerID;
    public VendorInfo(String vN, String vL, String offer, String vi, String offid){
        vendorName=vN;
        vendorLoc=vL;
        this.offer = offer;
        vendorImage = vi;
        offerID = offid;
    }

    public String getVendorName() {return vendorName; }
    public String getVendorLoc() { return vendorLoc; }
    public String getOffer() { return offer; }
    public String getVendorImage() { return vendorImage; }
}
