package OPP_BIG_PROJECTS.LibrarySystemAdvance;

import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<LibraryBook> books = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        int loginChoice;
        boolean isAuthenticated = false;
        do {

            System.out.println("Welcome To Library");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            loginChoice = s.nextInt();
            s.nextLine();

            if (loginChoice == 1) {
                boolean accountFound = false;
                System.out.print("Enter Username: ");
                String userName = s.nextLine();

                System.out.print("Enter Password: ");
                String userPassword = s.nextLine();

                for (Account account : accounts) {
                    if (account.userName.equalsIgnoreCase(userName) && account.userPassword.equalsIgnoreCase(userPassword)) {
                        System.out.println("Sucessfully logged in!");
                        accountFound = true;
                        isAuthenticated = true;
                        break;
                    }
                }

                if (!isAuthenticated) {
                    System.out.println("Account is not found");
                }

            } else if (loginChoice == 2) {

                boolean exist = false;

                System.out.print("Enter Username: ");
                String userName = s.nextLine();

                System.out.print("Enter Password: ");
                String userPassword = s.nextLine();

                for (Account account : accounts) {
                    if (account.userName.equalsIgnoreCase(account.userName)) {
                        exist = true;
                        break;
                    }
                }
                if (exist) {
                    System.out.println("Username is already taken!");
                } else {
                    Account newAccount = new Account(userName, userPassword);
                    accounts.add(newAccount);
                }

            }

        } while (loginChoice != 3 && !isAuthenticated);

        if (isAuthenticated) {
            int choice;
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Search Book");
                System.out.println("4. Display Book");
                System.out.println("5. Updatw Book");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                choice = s.nextInt();
                s.nextLine();

                if (choice == 1) {
                    System.out.print("Enter Title: ");
                    String title = s.nextLine();


                    System.out.print("Enter Author: ");
                    String author = s.nextLine();


                    System.out.print("Enter Year: ");
                    int year = s.nextInt();
                    s.nextLine();

                    LibraryBook newBook = new LibraryBook(title, author, year);
                    books.add(newBook);


                } else if (choice == 2) {

                    boolean isRemove = false;

                    System.out.print("Entet title to remove: ");
                    String titleRemove = s.nextLine();

                    for (LibraryBook book : books) {
                        if (book.title.equalsIgnoreCase(titleRemove)) {
                            books.remove(book);
                            System.out.println("Succesfull Removed");
                            isRemove = true;
                            break;
                        }
                    }
                    if (!isRemove) {
                        System.out.println("No Books Available");
                    }

                } else if (choice == 3) {

                    boolean isFound = false;

                    System.out.print("Enter title of book to search: ");
                    String search = s.nextLine();

                    for (LibraryBook book : books) {
                        if (book.title.equalsIgnoreCase(search)) {
                            System.out.println("Book Found " + book);
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound) {
                        System.out.println("Book is not found");
                    }


                } else if (choice == 4) {
                    if (books.isEmpty()) {
                        System.out.println("No Books Available");
                    } else {

                        Collections.sort(books, Comparator.comparing(b -> b.title));

                        int i = 1;
                        for (LibraryBook book : books) {
                            System.out.println("Book " + i + ": " + book);
                            i++;
                        }
                    }

                } else if (choice == 5) {
                    boolean isFound = false;
                    int updateChoice;
                    System.out.print("Enter title of book to update: ");
                    String updateBook = s.nextLine();


                    for (LibraryBook book : books) {
                        if (book.title.equalsIgnoreCase(updateBook)) {
                            isFound = true;

                            do {

                                System.out.println("What do you want to update?");
                                System.out.println("1. Title");
                                System.out.println("2. Author");
                                System.out.println("3. Year");
                                System.out.println("4. Exit");
                                updateChoice = s.nextInt();
                                s.nextLine();

                                if (updateChoice == 1) {
                                    System.out.print("Enter New Title: ");
                                    String newTitle = s.nextLine();
                                    book.title = newTitle;
                                } else if (updateChoice == 2) {
                                    System.out.print("Enter New Author: ");
                                    String newAuthor = s.nextLine();
                                    book.author = newAuthor;
                                } else if (updateChoice == 3) {
                                    System.out.print("Enter New Year: ");
                                    int newYear = s.nextInt();
                                    book.year = newYear;
                                }
                                if (!isFound) {
                                    System.out.println("Book is not found");
                                }
                            } while (updateChoice != 4);

                        }
                    }
                }
            } while (choice != 6);

        }
    }}

