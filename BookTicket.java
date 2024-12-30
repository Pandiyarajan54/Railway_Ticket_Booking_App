import java.util.*;

public class BookTicket{

public static void book(Flight currentFlight,int tickets,int passengerId){

    String passengerDetail ="";

    passengerDetail = "PassengerId " + passengerId + "--" + "Number of tickets booked " + tickets +
            "--"+ "Total cost " +  currentFlight.price * tickets;

    currentFlight.addPassengerDetails(passengerDetail,tickets,passengerId);

    currentFlight.flightSummary();

    currentFlight.printDetails();


}


public static void cancel(Flight currentFlight,int passengerId )
{
    currentFlight.cancelTicket(passengerId);

    currentFlight.flightSummary();

    currentFlight.printDetails();
}

public static void print(Flight f)
{
    f.printDetails();
}


public static void main(String[] args) {


    ArrayList<Flight> flights = new ArrayList<Flight>();
    for (int i = 0; i < 2; i++)
        flights.add(new Flight());


    int passengerId = 1;

    while (true) {

        System.out.println("1. Book\n2.Cancel\n3.Print\n ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {

            case 1: {
                System.out.println("Enter the flight  id : ");
                int fid = sc.nextInt();

                if (fid > flights.size()) {
                    System.out.println("Invalid flight id");
                    break;
                }

                Flight currentFlight = null;

                for (Flight f : flights) {
                    if (f.flightId == fid) {
                        currentFlight = f;
                        f.flightSummary();
                        break;
                    }
                }

                System.out.println("Enter the number of tickets :");
                int t = sc.nextInt();

                if (t > currentFlight.tickets) {
                    System.out.println("Not enough tickets ");
                    break;
                }
                book(currentFlight, t, passengerId);

                passengerId = passengerId + 1;
                break;

            }

            case 2: {
                System.out.println("Enter the flight id and passenger id to cancel the booking");

                int fid = sc.nextInt();

                if (fid > flights.size()) {
                    System.out.println("Invalid flight id");
                    break;
                }

                Flight currentFlight = null;

                for (Flight f : flights) {
                    if (fid == f.flightId) {
                        currentFlight = f;
                        break;
                    }
                }
                int id = sc.nextInt();

                cancel(currentFlight, id);
                break;

            }

            case 3: {
                for (Flight f : flights) {
                    if (f.passengerDetails.size() == 0) {
                        System.out.println("No passenger details for the flight " + f.flightId);
                        break;
                    } else
                        print(f);
                }
                break;
            }
            default:
                break;

        }


    }

}

}