import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by amd3 on 26.02.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        try {
            LibraryStaff admin = new LibraryStaff("amd1", "muzaffer", "dulger", "123456");

            System.out.println("---------------------------------");
            System.out.println("-----KUTUPHANE SISTEM GIRISI-----");
            System.out.println("---------------------------------");
            System.out.println("1 --> Staff\n2 --> User");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            if(choice.equals("1"))
            {
                System.out.println("Information of Admin");
                System.out.println(admin.toString());
                System.out.print("NICKNAME : ");
                String nickname = input.nextLine();
                System.out.print("PASSWORD : ");
                String password = input.nextLine();

                if(nickname.equals(admin.getNickname()) && password.equals(admin.getPassword()))
                {
                    System.out.println("1 --> Add Book");
                    System.out.println("2 --> Remove Book");
                    System.out.println("3 --> Add User");
                    System.out.println("4 --> Show Book");
                    choice = input.nextLine();
                    if (choice.equals("1"))
                    {
                        System.out.print("Bookname: ");
                        String bookname = input.nextLine();
                        admin.addBook(bookname);

                    }
                    else if (choice.equals("2"))
                    {
                        System.out.print("Bookname: ");
                        String bookname = input.nextLine();
                        admin.removeBook(bookname);

                    }
                    else if (choice.equals("3"))
                    {
                        System.out.print("NICKNAME : ");
                        String nicknameUser = input.nextLine();
                        System.out.print("NAME     : ");
                        String nameUser = input.nextLine();
                        System.out.print("SURNAME  : ");
                        String surnameUser = input.nextLine();
                        System.out.print("PASSWORD : ");
                        String passwordUser = input.nextLine();
                        admin.addUser(nicknameUser,nameUser,surnameUser,passwordUser);
                    }
                    else if(choice.equals("4"))
                        admin.showBooks();
                    else {
                        throw new Exception("Hatali giris");
                    }
                }
                else {
                    throw new Exception("Hatali giris");
                }
            }
            else if(choice.equals("2"))
            {
                System.out.print("NICKNAME : ");
                String nickname = input.nextLine();
                System.out.print("PASSWORD : ");
                String password = input.nextLine();

                Scanner myscanUser = new Scanner( new File("user.csv")). useDelimiter(";");
                ArrayList<String> listForUser = new ArrayList<>();

                while (myscanUser.hasNext()) {
                    listForUser.add(myscanUser.next());
                }
                int count = 0;
                for (int i=0; i+3<listForUser.size(); i++)
                {
                    if(nickname.equals(listForUser.get(i)) && password.equals(listForUser.get(i+3)))
                    {
                        count++;
                        LibraryUser user = new LibraryUser( listForUser.get(i),
                                                            listForUser.get(i+1),
                                                            listForUser.get(i+2),
                                                            listForUser.get(i+3));

                        System.out.println("Information of User");
                        System.out.println(user.toString());

                        System.out.println("1 --> Barrow Book\n2 --> Return Book\n3 --> Show Book");
                        choice = input.nextLine();
                        if (choice.equals("1"))
                        {
                            System.out.print("Bookname: ");
                            String bookname = input.nextLine();
                            user.barrowBook(nickname, bookname);
                        }
                        else if (choice.equals("2"))
                        {
                            System.out.print("Bookname: ");
                            String bookname = input.nextLine();
                            user.returnBook(nickname, bookname);
                        }
                        else if(choice.equals("3"))
                            admin.showBooks();
                        else {
                            throw new Exception("Hatali secim!!");
                        }
                    }
                }
                if(count == 0)
                    throw new Exception("Hatali giris");
            }
            else {
                throw new Exception("Hatali secim!!");
            }
        }
        catch (Exception e)
        {
            System.err.println("Hata: " + e.getMessage());
        }
    }
}
