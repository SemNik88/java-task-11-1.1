import java.util.Arrays;
public class MovieManager {
    private Movie[] movies;
    private final int limit;

    public MovieManager() {
        this.limit = 5; // По умолчанию лимит 5
        this.movies = new Movie[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new Movie[0];
    }

    public void addMovie(String title) {
        Movie newMovie = new Movie(title);
        Movie[] temp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, temp, 0, movies.length);
        temp[temp.length - 1] = newMovie;
        movies = temp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength = Math.min(limit, movies.length);
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }

    public void displayMovies() {
        MovieManager manager = new MovieManager(5); // Создаем менеджер с лимитом 5

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-неведимка");
        manager.addMovie("Тролли.Мирововй Тур");
        manager.addMovie("Номер один");

        Movie[] allMovies = manager.findAll();
        System.out.println("Все фильмы:");
        for (Movie movie : allMovies) {
            System.out.println(movie.getTitle());
        }

        Movie[] lastMovies = manager.findLast();
        System.out.println("\nПоследние добавленные фильмы:");
        for (Movie movie : lastMovies) {
            System.out.println(movie.getTitle());
        }
    }
}



