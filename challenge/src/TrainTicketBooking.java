import java.util.Scanner;

public class TrainTicketBooking {

    private static int[] seats = new int[10]; // 10 seats available
    private static Scanner scanner = new Scanner(System.in);
    private static int seatsBooked = 0;
    public static void main(String[] args)
    {

            boolean running = true;
            while (running)
            {
                System.out.println("Welcome to Train Ticket Booking System ");
                System.out.println("1. Book a ticket");
                System.out.println("2. View available seats");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = 0;
                try
                {
                     choice = scanner.nextInt();

                }
                catch(Exception e){
                    System.out.println("Invalid please enter a number");
                    return;
                }
                switch (choice)
                {
                    case 1:
                        bookTicket();
                        break;
                    case 2:
                        viewSeats();
                        break;
                    case 3:
                        running = false;
                        System.out.println("Thank you for using Train Ticket Booking System");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;
                }
            }
        }



    private static void bookTicket() {

        System.out.println("Enter number of tickets to book (max 4 per transaction): ");
        int numTickets = scanner.nextInt();
        if (numTickets < 1 || numTickets > 4) {
            System.out.println("Invalid number of tickets, please try again");
            return;
        }
        if(seatsBooked >=10){

        }
        int totalCost = numTickets * 100; // €100 per ticket
        System.out.println("Total cost is €" + totalCost);
        System.out.println("Enter 1 to confirm booking or any other key to cancel");
        int confirm = scanner.nextInt();
        if (confirm == 1) {

            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 0) {
                    seats[i] = 1;
                    System.out.println("Seat " + (i+1) + " booked successfully");
                    seatsBooked++;
                    if(seatsBooked == numTickets) {
                        break;
                    }
                }
            }
            System.out.println("Tickets booked successfully!");
        } else {
            System.out.println("Booking cancelled");
        }
    }

    private static void viewSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                System.out.println("Seat " + (i+1) + " is available");
            }
        }
    }
}
