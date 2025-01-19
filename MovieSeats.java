import java.util.Scanner;

public class MovieSeats {
    private static int rows;
    private static int cols;
    private static char [][] seats;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        cols = scanner.nextInt();
        scanner.nextLine();

        seats = seats(rows, cols);

        boolean running = true;
        while (running){
            System.out.println("\n--- Movie Theater Seat Reservation ---");
            System.out.println("1. View Seating");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    displaySeats();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
            }
        }

    }

    // Initialize all seats to 'O'
    public static char[][] seats(int rows, int cols){
        seats = new char[rows][cols];
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                seats[row][col]= 'O';
            }
        }
                return seats;
    }

    // Display the current seating arrangement
    public static void displaySeats(){
        System.out.println("\nCurrent Seating:");
        for (int row = 0; row < rows; row++ ){
            for(int col = 0; col < cols; col++) {
                System.out.print(seats[row][col]);
            }
            System.out.println();
        }
    }

    // Reserve a seat
    public static void reserveSeat(Scanner scanner){
        System.out.println("Enter row (1-" + rows + "): ");
        int row = scanner.nextInt() - 1;
        System.out.println("Enter col (1-" + cols + "): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= rows || col < 0 || col >= cols ){
            System.out.println("Invalid seat selection.");
            return;
        }
        if (seats[row][col]== 'O'){
            seats[row][col] = 'X';
            System.out.println("Seat reserved successfully!");
        } else {
            System.out.println("This seat is already taken. Suggesting an available seat:");
            suggestSeat();
        }
    }

    // Cancel a reservation
    public static void cancelReservation(Scanner scanner){
        System.out.println("Enter row (1-" + rows + "): ");
        int row = scanner.nextInt() - 1;
        System.out.println("Enter col (1-" + cols + "): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= rows || col < 0 || col >= cols ){
            System.out.println("Invalid seat selection.");
            return;
        }
        if (seats[row][col]== 'X'){
            seats[row][col] = 'O';
            System.out.println("Seat reservation cancelled successfully!");
        } else {
            System.out.println("This seat was not reserved.");
        }
    }

    // Suggest an available seat
    public static void suggestSeat() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (seats[row][col] == 'O') {
                    System.out.println("You can reserve seat at row " + (row + 1) + ", column " + (col + 1));
                    return;
                }
            }
        }
        System.out.println("Sorry, no seats are available.");
    }
}
