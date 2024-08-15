package BookMyShow;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookMyShow {

    public static void main(String[] args) {

        MovieController movieController= new MovieController();
        TheatreController theatreController = new TheatreController();

        //Add Movies
        List<Movie> movieList = new ArrayList<>();
        Movie heraPheri = new Movie("Hera Pheri","comedy",3, List.of("Hindi"));
        Movie johnWick = new Movie("John Wick","action",3,List.of("English","Hindi"));
        Movie maharaja = new Movie("Maharaja","drama",3,List.of("Hindi","Tamil","Telugu","Kannada"));
        movieList.add(heraPheri);
        movieList.add(johnWick);
        movieList.add(maharaja);

        //Add Theatres
        Theatre blrTheatre = createTheatre("PVR INOX","ORION Mall","Bengaluru",List.of(johnWick,maharaja));
        Theatre mznTheatre = createTheatre("Meenakshi Hall","Mahawir Chowk","Muzaffarnagar",List.of(heraPheri,maharaja));

        movieController.addMovie(heraPheri,"Muzaffarnagar");
        movieController.addMovie(maharaja,"Muzaffarnagar");
        movieController.addMovie(johnWick,"Bengaluru");
        movieController.addMovie(maharaja,"Bengaluru");

        theatreController.addTheatre(blrTheatre,"Bengaluru");
        theatreController.addTheatre(mznTheatre,"Muzaffarnagar");

        Scanner sc = new Scanner(System.in);
        User user = new User("Sarthak","sarthaktyagi@gmail.com","8956542315");
        System.out.println("Please Enter the city");
        String city = sc.next();
        sc.nextLine();
        System.out.println("Movie Available");
        List<Movie>  movies = movieController.getMovies(city);
        if(movies.isEmpty()){
            System.out.println("No movies available currently");
        }
        else{
            for(Movie movie: movies){
                System.out.println("Movie: "+movie.getName()+"\nDurtion: "+movie.getDuration()+"\nGenre "+movie.getGenre());
                System.out.println("***********");
            }
            System.out.println("Enter movie name");
            String movieName = sc.nextLine();
            System.out.println(movieName);
            List<Show> shows = theatreController.getShows(city,movieName);
            if(shows.isEmpty()){
                System.out.println("Currenty no shows are available for "+movieName+" in "+city);
            }
            else{
                int showSerial = 0;
                for(Show  show: shows){
                    showSerial++;
                    if(show.getBookedSeats().size()!=show.getScreen().getSeatList().size()){
                        System.out.println("Show details showSerialNumber: "+ showSerial+" for "+show.getMovie().getName()+"\nTime"+show.getStartTime()+"\nLanguage "+show.getAudioLanguage());
                    }
                }
                int showId = sc.nextInt();
                Show chosenShow = shows.get(showId-1);
                Map<Integer,Seat> seatMap = new HashMap<>();
                if(chosenShow.getBookedSeats().size()!=chosenShow.getScreen().getSeatList().size()){
                    System.out.println("Please select seat Id: ");
                    for(Seat seat: chosenShow.getScreen().getSeatList()){
                        if(!chosenShow.getBookedSeats().contains(seat.getSeatId())){
                            seatMap.put(seat.getSeatId(),seat);
                            System.out.println("SeatId: "+seat.getSeatId()+
                                    "\nSeat Row "+seat.getRow()+
                                    "\nSeat Price: "+seat.getPrice()+"\nSeat Type: "+seat.getSeatType());
                        }
                    }
                    System.out.println("Enter seat ids");
                    sc.nextLine();
                    String seatIds = sc.nextLine();
                    String[] seatsIds = seatIds.split("\\s+");
                    List<Seat> bookedSeats = new ArrayList<>();
                    for (String strNumber : seatsIds) {
                        bookedSeats.add(seatMap.get(Integer.parseInt(strNumber)));
                    }
                    PaymentMode paymentMode = new CreditCardPayment();
                    Booking booking = new Booking(user,chosenShow,paymentMode,bookedSeats);
                    booking.pay();
                }
            }
        }
    }

    private static Theatre createTheatre(String name, String address, String city, List<Movie> movieList){
        int n = movieList.size();
        List<Screen> screenList = new ArrayList<>();
        List<Show> showList = new ArrayList<>();
        for(int i=0;i<n;i++){
            screenList.add(getScreen());
        }
        for(int i=0;i<n;i++){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
            String time = "12.00";
            LocalTime localTimeObj = LocalTime.parse(time, formatter);
            for(int j=0;j<3;j++){
                Show show = createShow(movieList.get(i),screenList.get(i),localTimeObj,movieList.get(i).getAudioLanguages().get(0));
                showList.add(show);
                localTimeObj = localTimeObj.plusHours(3);
            }
        }
        Theatre theatre = new Theatre(name,address,city);
        theatre.setShowList(showList);
        theatre.setScreenList(screenList);
        return theatre;
    }

    private static Show createShow(Movie movie,Screen screen, LocalTime time, String language){
        Show show = new Show(movie,screen,time,"Hindi");
        return show;
    }

    private static Screen getScreen(){
        Screen screen = new Screen();
        List<Seat> seatList = createSeats(10,10);
        screen.setSeatList(seatList);
        return screen;
    }

    private static List<Seat> createSeats(int m, int n){
        List<Seat> seatList = new ArrayList<>();
        for(int i=1;i<=(m/3);i++){
            for(int j=1;j<=n;j++) {
                seatList.add(new Seat(((i - 1) * n + j), i, 150, SeatType.SILVER));
            }
        }
        for(int i=(m/3)+1;i<=(2*m)/3;i++){
            for(int j=1;j<=n;j++){
                seatList.add(new Seat(((i - 1) * n + j), i, 250, SeatType.GOLDEN));
            }
        }
        for(int i=(2*m/3)+1;i<=m;i++){
            for(int j=1;j<=n;j++){
                seatList.add(new Seat(((i - 1) * n + j), i, 350, SeatType.PLATINUM));
            }
        }
        return seatList;
    }
}
