package example;

import example.price.Price;

public class Movie {
    public static final Price REGULAR = null;
    public static final Price NEW_RELEASE = null;
    private final String title;
    private final Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    double charge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
