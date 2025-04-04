public class TVShow extends MotionPicture{
    String numOfSeasons;

    public TVShow(String id, String type, String title, String director, String country, int releaseYear, String rating, String numOfSeasons, String description) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.country = country;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.numOfSeasons = numOfSeasons;
        this.description = description;
    }

    public String getNumOfSeasons() {
        return numOfSeasons;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + type + ", " + "'" + title + "'" + " by " + director;
    }

}