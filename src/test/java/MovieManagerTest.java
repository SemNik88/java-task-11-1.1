import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {

    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        Movie[] movies = manager.findAll();

        Movie[] expected = {
                new Movie("Movie 1"),
                new Movie("Movie 2"),
                new Movie("Movie 3")
        };

        assertArrayEquals(expected, movies);
    }

    @Test
    public void testFindAllEmpty() {
        MovieManager manager = new MovieManager();
        Movie[] movies = manager.findAll();
        assertEquals(0, movies.length);
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");

        Movie[] lastMovies = manager.findLast();
        Movie[] expected = {
                new Movie("Movie 6"),
                new Movie("Movie 5"),
                new Movie("Movie 4"),
                new Movie("Movie 3"),
                new Movie("Movie 2")
        };

        assertArrayEquals(expected, lastMovies);
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        Movie[] lastMovies = manager.findLast();
        Movie[] expected = {
                new Movie("Movie 3"),
                new Movie("Movie 2")
        };

        assertArrayEquals(expected, lastMovies);
    }
}


