
public class BookLibrary 
{
    public static void main(String[] args) 
    {
        Library lib = new Library();
        while (true) 
        {
            IO.println("1. Add Book");
            IO.println("2. Display Books");
            IO.println("3. Update Quantity");
            IO.println("4. Delete Book");
            IO.println("5. Exit");
            IO.print("Choose an option: ");
            int choice = Integer.parseInt(IO.readln());
            
            switch (choice) 
            {

                case 1:

                    IO.print("Enter Title: ");
                    String title = IO.readln();

                    IO.print("Enter Author: ");
                    String author = IO.readln();

                    IO.print("Enter ISBN: ");
                    long isbn = Long.parseLong(IO.readln());

                    IO.print("Enter Price: ");
                    double price = Double.parseDouble(IO.readln());

                    IO.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(IO.readln());

                    Book b = new Book(title, author, isbn, price, quantity);
                    lib.addBook(b);
                    break;

                case 2:

                    lib.displayAllBooks();
                    break;

                case 3:

                    IO.print("Enter ISBN: ");
                    long searchISBN = Long.parseLong(IO.readln());
                    IO.print("Enter new Quantity: ");
                    int newQuantity = Integer.parseInt(IO.readln());
                    lib.updateBookQuantityByISBN(searchISBN, newQuantity);
                    break;

                case 4:

                    IO.println("Enter Book Title :");
                    String deleteTitle = IO.readln();
                    lib.deleteBookByTitle(deleteTitle);
                    break;

                case 5:

                    IO.println("Exiting from the Application. Thank you!!!");
                    return;

                default:

                    IO.println("Invalid choice.");
                    break;
            }
        }
    }
}
