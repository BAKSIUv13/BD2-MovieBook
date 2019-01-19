package pl.moviebook.otherEntities;

public class BasicArtist {

    private String name;
    private String surname;
    private String pictureUrl;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the photoUrl
     */
    public String getPhotoUrl() {
        return pictureUrl;
    }

    /**
     * @param photoUrl the pictureUrl to set
     */
    public void setPhotoUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

}
