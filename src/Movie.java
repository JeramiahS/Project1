public class Movie extends MotionPicture {
    protected int duration;

    public Movie(String id, String type, String title, String director, String country, int releaseYear, String rating, int duration, String description) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.country = country;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + type + ", " + "'" + title + "'" + " by " + director;
    }
}