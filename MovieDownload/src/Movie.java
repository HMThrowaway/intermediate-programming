class Movie {

    // fields
    String movieName;
    String movieNameForUrl;
    String movieScreenshotFilename;
    String movieYear;


    Movie(String name) {


        movieName = name;
        movieNameForUrl = getMovieNameForURL();
        movieScreenshotFilename = getMovieFilename();
    }

    String getMovieNameForURL() {
        movieNameForUrl = movieName.replaceAll(" ", "+");
        return movieNameForUrl;
    }

    String getMovieFilename() {
        movieScreenshotFilename = movieName.replaceAll("\\+", "_") + ".png";
        return movieScreenshotFilename;
    }
}




