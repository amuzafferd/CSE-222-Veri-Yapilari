import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ahmet Muzaffer Dülger on 22.02.2017.
 */
public class LibraryUser extends User
{
    /**
     * Library user constructor
     * Creates new library staff object and initialize it
     * @param otherNickname nickname of library user
     * @param otherName name of library user
     * @param otherSurname surname of library user
     * @param otherPassword password of library user
     */
    public LibraryUser(String otherNickname, String otherName, String otherSurname, String otherPassword)
    {
        super(otherNickname, otherName, otherSurname, otherPassword);
    }

    @Override
    public String toString()
    {
        return String.format(super.toString());
    }


    /**
     * This method is used to barrow books from the library.
     * @param nickname nickname of library user
     * @param bookname name of book
     */
    public void barrowBook(String nickname, String bookname)
    {
        String bookFile = "book.csv";
        String barrowFile = "barrow.csv";
        String userFile = "user.csv";

        ArrayList<String> bookList = new ArrayList<>();
        ArrayList<String> userList = new ArrayList<>();

        try
        {
            File f = new File(bookFile);
            if(!f.exists())
                throw new Exception("Kutuphanede kitap yok!!");

            Scanner myForBook = new Scanner( new File(bookFile)). useDelimiter(";");
            while (myForBook.hasNext()) {
                bookList.add(myForBook.next());
            }

            Scanner myForUser = new Scanner( new File(userFile)). useDelimiter(";");
            while (myForUser.hasNext()) {
                userList.add(myForUser.next());
            }

            int count = 0;
            for (int i = 0; i<bookList.size(); i++)
            {
                if (bookname.equals(bookList.get(i)))
                    count++;
            }

            if (count == 0)
                throw new Exception("Boyle bir kitap yok");


            count = 0;
            for (int k = 0; k<userList.size(); k++)
            {
                for (int i = 0; i<bookList.size(); i++)
                {
                    if (bookname.equals(bookList.get(i)) && nickname.equals(userList.get(k*4)) && count == 0) {
                        FileWriter fw = new FileWriter(barrowFile, true);
                        fw.append(nickname);
                        fw.append(";");
                        fw.append(bookname);
                        fw.append(";");
                        fw.close();

                        bookList.remove(i);
                        count++;
                    }
                }
            }

            PrintWriter pw = new PrintWriter(bookFile);

            for (int i = 0; i < bookList.size(); ++i)
            {
                pw.write(bookList.get(i));
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
     * This method is used to return books from the library.
     * @param nickname nickname of library user
     * @param bookname name of book
     */
    public void returnBook(String nickname, String bookname)
    {
        String barrowFile = "barrow.csv";
        String bookFile = "book.csv";

        ArrayList<String> barrowList = new ArrayList<>();

        try {
            Scanner myForBarrow = new Scanner(new File(barrowFile)).useDelimiter(";");
            while (myForBarrow.hasNext()) {
                barrowList.add(myForBarrow.next());
            }

            int count = 0;
            for (int i = 1; i<barrowList.size(); i+=2)
            {
                if (bookname.equals(barrowList.get(i)))
                    count++;
            }

            if (count == 0)
                throw new Exception("Boyle bir kitap yok");


            int i = 0;
            while (i < barrowList.size()) {
                if (nickname.equals(barrowList.get(i)) && bookname.equals(barrowList.get(i+1)))
                {
                    barrowList.remove(i);
                    barrowList.remove(i);
                    FileWriter fw = new FileWriter(bookFile, true);
                    fw.append(bookname);
                    fw.append(";");
                    fw.close();
                }
                i++;
            }

            PrintWriter pw = new PrintWriter(barrowFile);
            for (int k = 0; k < barrowList.size(); ++k)
            {
                pw.write(barrowList.get(k));
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