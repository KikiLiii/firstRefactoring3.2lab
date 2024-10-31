package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CustomerTest {
    private Customer customer;
    private Rental rental1;
    private Rental rental2;
    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    void setUp() {
        // Mock movies and rentals (assuming appropriate constructors)
        movie1 = new Movie("Movie A", Movie.REGULAR);
        movie2 = new Movie("Movie B", Movie.NEW_RELEASE);

        rental1 = new Rental(movie1, 3); // Assuming 3 days rental
        rental2 = new Rental(movie2, 1); // Assuming 1 day rental

        List<Rental> rentals = Arrays.asList(rental1, rental2);
        customer = new Customer("John Doe", rentals);
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", customer.getName());
    }


    @Test
    void testStatementWithNoRentals() {
        Customer customerWithNoRentals = new Customer("Jane Doe", Collections.emptyList());
        String expectedStatement = "Rental Record for Jane Doe\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(expectedStatement, customerWithNoRentals.statement());
    }
    @Test
    void testGetTotalCharge() {
        assertEquals(6.5, customer.getTotalCharge(), 0.001);
    }

    @Test
    void testGetTotalFrequentRenterPoints() {
        assertEquals(2, customer.getTotalFrequentRenterPoints());
    }


}
