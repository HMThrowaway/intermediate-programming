import java.lang.reflect.Type;
import java.util.Scanner;


class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line;
        MoviePosterWriter mpw = new MoviePosterWriter();
        Movie movie;
        while (true){
            line = "";

            while (line.isEmpty()){
                System.out.println("Type in the name of a movie to get the poster in a .png file (Enter Q to quit)");
                line = scanner.nextLine();
            }


            if (line.equals("Q") || line.equals("q")){
                System.out.println("Operation completed!");
                System.exit(0);
            }
            movie = new Movie(scanner.nextLine());

            mpw.setMovieString(movie.getMovieNameForURL());


            mpw.write(movie.getMovieFilename());
            movie.movieYear = mpw.movieYear;

            System.out.println(movie.movieName + " poster in " + movie.movieName.replaceAll(" ", "_") + ".png");
            System.out.println(movie.movieName + " was released in " + movie.movieYear+ "\n");
        }

    }
}
