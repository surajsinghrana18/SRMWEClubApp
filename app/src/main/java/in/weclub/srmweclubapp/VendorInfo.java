package in.weclub.srmweclubapp;

/**
 * Created by root on 5/23/18.
 */

public class VendorInfo {
    private String vendorName, vendorLoc, offer, vendorImage;
    public VendorInfo(String vN, String vL, String offer, String vi){
        vendorName=vN;
        vendorLoc=vL;
        this.offer = offer;
        vendorImage = vi;
    }

    public String getVendorName() {return vendorName; }
    public String getVendorLoc() { return vendorLoc; }
    public String getOffer() { return offer; }
    public String getVendorImage() { return vendorImage; }
}
