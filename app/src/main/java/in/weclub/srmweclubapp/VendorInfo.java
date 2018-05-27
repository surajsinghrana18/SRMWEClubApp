package in.weclub.srmweclubapp;


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
