import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void testFindLastWhenMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        Movie[] lastMovies = manager.findLast();
        Movie[] expected = {
                new Movie("Movie 2"),
                new Movie("Movie 1")
        };

        assertArrayEquals(expected, lastMovies);
    }

    @Test
    public void testFindLastWhenMoviesMoreThanLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");

        Movie[] lastMovies = manager.findLast();
        Movie[] expected = {
                new Movie("Movie 5"),
                new Movie("Movie 4"),
                new Movie("Movie 3")
        };

        assertArrayEquals(expected, lastMovies);
    }

    @Test
    public void testFindLastWhenMoviesEqualToLimit() {
        MovieManager manager = new MovieManager(4);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");

        Movie[] lastMovies = manager.findLast();
        Movie[] expected = {
                new Movie("Movie 4"),
                new Movie("Movie 3"),
                new Movie("Movie 2"),
                new Movie("Movie 1")
        };

        assertArrayEquals(expected, lastMovies);
    }
}

