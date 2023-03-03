import java.util.Collection;

/**
 *
 * @author liamflynn
 */
public class Customer {
    
    private Collection<SaleItem> saleItems;
    
    private Integer customerID;
    private String familyName;
    private String givenName;
    private String birthDate;
    private Integer phone;
    private String email;
    private String streetAddress;
    private String suburb;
    private String city;
    private String country;
    private String postcode;
    private String passwordHash;
    private String notes;
    private String favouriteArtists;
    private String favouriteGenres;
    private String favouriteEras;

    public Collection<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(Collection<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFavouriteArtists() {
        return favouriteArtists;
    }

    public void setFavouriteArtists(String favouriteArtists) {
        this.favouriteArtists = favouriteArtists;
    }

    public String getFavouriteGenres() {
        return favouriteGenres;
    }

    public void setFavouriteGenres(String favouriteGenres) {
        this.favouriteGenres = favouriteGenres;
    }

    public String getFavouriteEras() {
        return favouriteEras;
    }

    public void setFavouriteEras(String favouriteEras) {
        this.favouriteEras = favouriteEras;
    }
}
