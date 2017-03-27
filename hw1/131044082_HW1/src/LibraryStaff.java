import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Ahmet Muzaffer Dülger on 22.02.2017.
 *
 * This class will store library staff informations and skills.
 */
public class LibraryStaff extends User
{
    /**
     * Library staff constructor
     * Creates new library staff object and initialize it
     * @param otherNickname nickname of library staff
     * @param otherName name of library staff
     * @param otherSurname surname of library staff
     * @param otherPassword password of library staff
     */
    public LibraryStaff(String otherNickname, String otherName, String otherSurname, String otherPassword)
    {
        super(otherNickname, otherName, otherSurname, otherPassword);
    }

    @Override
    public String toString()
    {
        return String.format(super.toString());
    }

    /**
     * This method is used to add books from the library.
     * @param bookname name of book
     */
    public void addBook(String bookname)
    {
        ArrayList<String> listForAddBook = new ArrayList<>();
        listForAddBook.add(bookname);
        String fileName = "book.csv";

        try
        {
            FileWriter fw = new FileWriter(fileName, true);
            for (int i = 0; i < listForAddBook.size(); ++i)
            {
                fw.append(listForAddBook.get(i));
                fw.append(";");
            }
            fw.close();
        }
        catch (Exception e)
        {
            System.err.println("Hata : " + e.getMessage());
        }
    }

    /**
     * This method is used to delete books from the library.
     * @param bookname name of book
     */
    public void removeBook(String bookname)
    {
        ArrayList<String> listForRemoveBook = new ArrayList<>();
        String fileName = "book.csv";

        try
        {
            Scanner myscan = new Scanner( new File(fileName)). useDelimiter(";");

            while (myscan.hasNext()) {
                listForRemoveBook.add(myscan.next());
            }

            int count = 0;
            for (int i = 0; i<listForRemoveBook.size(); i++)
            {
                if (bookname.equals(listForRemoveBook.get(i)))
                    count++;
            }

            if (count == 0)
                throw new Exception("Boyle bir kitap yok");

            count = 0;
            for (int i = 0; i<listForRemoveBook.size(); i++)
            {
                if (bookname.equals(listForRemoveBook.get(i)) && count == 0) {
                    listForRemoveBook.remove(i);
                    count++;
                }
            }

            PrintWriter pw = new PrintWriter(fileName);

            for (int i = 0; i < listForRemoveBook.size(); ++i)
            {
                pw.write(listForRemoveBook.get(i));
                pw.write(";");
            }
            pw.close();
        }
        catch (Exception e)
        {
            System.err.println("Hata : " + e.getMessage());
        }
    }

    /**
     * This method is used to add users to the library.
     * @param userNickname nickname of library user
     * @param userName name of library user
     * @param userSurname surname of library user
     * @param userPassword password of library user
     */
    public void addUser(String userNickname, String userName, String userSurname, String userPassword)
    {
        List<String> listForAddUser = new ArrayList<>();
        String filename = "user.csv";

        try
        {
            File f = new File(filename);
            if(f.exists())
            {
                Scanner myForUser = new Scanner( new File(filename)). useDelimiter(";");
                while (myForUser.hasNext()) {
                    listForAddUser.add(myForUser.next());
                }

                for (int i = 0; i < listForAddUser.size(); i+=4)
                {
                    if (userNickname.equals(listForAddUser.get(i)))
                    {
                        throw new Exception("Bu nickname kullaniliyor!!");
                    }
                }
            }

            listForAddUser.add(userNickname);
            listForAddUser.add(userName);
            listForAddUser.add(userSurname);
            listForAddUser.add(userPassword);

            PrintWriter pw = new PrintWriter(filename);

            for (int i = 0; i < listForAddUser.size(); ++i)
            {
                pw.write(listForAddUser.get(i));
                pw.write(";");
            }
            pw.close();
        }
        catch (Exception e)
        {
            System.err.println("Hata : " + e.getMessage());
        }
    }

    @Override
    public void showBooks()
    {
        ArrayList<String> listForShowBooks = new ArrayList<>();
        String filename = "book.csv";

        try
        {
            Scanner myscan = new Scanner( new File(filename)). useDelimiter(";");

            while (myscan.hasNext()) {
                listForShowBooks.add(myscan.next());
            }

            System.out.println("------Book List-------");
            for (int i=0; i<listForShowBooks.size(); i++) {
                System.out.println(listForShowBooks.get(i));
            }
        }
        catch (Exception e)
        {
            System.err.println("Hata : " + e.getMessage());
        }
    }
}