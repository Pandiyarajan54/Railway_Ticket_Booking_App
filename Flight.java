import java.util.*;


public class Flight {

    static int id = 0;
    int flightId;
    int tickets;
    int price;

    ArrayList<String> passengerDetails;
    ArrayList<Integer> passengerIds;
    ArrayList<Integer> bookedTicketsPerPassenger;
    ArrayList<Integer>  passengerCost;


    public Flight()
    {
        tickets = 50;
        price = 5000;
        id  = id + 1;
        flightId = id;
        passengerDetails = new ArrayList<String>();
        passengerCost = new ArrayList<Integer>();
        bookedTicketsPerPassenger = new ArrayList<Integer>();
        passengerIds = new ArrayList<Integer>();

    }

    public void addPassengerDetails(String passengerDetail,int numberOfTickets,int passengerId)
    {
        passengerDetails.add(passengerDetail);
        passengerIds.add(passengerId);
        passengerCost.add(price * numberOfTickets);
        bookedTicketsPerPassenger.add(numberOfTickets);

        price = price + 200 * numberOfTickets;
        tickets = tickets - numberOfTickets;

        System.out.println("Tickets Booked Successfully !!!");

    }

    public void cancelTicket(int passengerId)
    {
        int indexToRemove = passengerIds.indexOf(passengerId);

        if(indexToRemove < 0)
        {

                System.out.println("PassengerId not found !!");
                return;
        }

        int ticketToCancel = bookedTicketsPerPassenger.get(indexToRemove);


        tickets = tickets + ticketToCancel;
        price = price - 200  * ticketToCancel;
        System.out.println("Refund amount after cancel : " + passengerCost.get(indexToRemove));

        bookedTicketsPerPassenger.remove(indexToRemove);
        passengerIds.remove(Integer.valueOf(passengerId));
        passengerDetails.remove(indexToRemove);
        passengerCost.remove(indexToRemove);

        System.out.println("Tickets cancelled successfully!!");
    }


    public void flightSummary()
    {
        System.out.println("Flight id : " + flightId + "Remaining Tickets : " + tickets + "Current Ticket Price : " + price);

    }

    public void printDetails()
    {
        System.out.println("Flighht id : " + flightId + "-->");
        for(String detail : passengerDetails)
            System.out.println(detail);
    }



}
