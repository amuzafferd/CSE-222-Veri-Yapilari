/**
 * Created by Ahmet Muzaffer Dülger on 23.02.2017.
 *
 * This is an ABSTRACT class. All users will extended from USER CLASS.
 * This class implements UserInterface for common properties
 */
public abstract class User implements UserInterface
{
    private String stringNickname = null;
    private String stringName = null;
    private String stringSurname = null;
    private String stringPassword = null;


    /**
     * User constructor
     * @param stringNickname nickname of user
     * @param stringName name of user
     * @param stringSurname surname of user
     * @param stringPassword password of user
     */
    public User(String stringNickname, String stringName, String stringSurname, String stringPassword)
    {
        this.stringNickname = stringNickname;
        this.stringName = stringName;
        this.stringSurname = stringSurname;
        this.stringPassword = stringPassword;
    }

    /**
     * This method gets nickname
     * @return stringNickname
     */
    public String getNickname() { return stringNickname; }

    /**
     * This method gets name
     * @return stringName
     */
    public String getName(){ return stringName; }

    /**
     * This method gets surname
     * @return stringSurname
     */
    public String getSurname() { return stringSurname; }

    /**
     * This method gets password
     * @return stringPassword
     */
    public String getPassword() { return stringPassword; }

    @Override
    public String toString() {
        return  String.format(  "nickname: " + getNickname() + "\n" +
                                "name    : " + getName() + "\n" +
                                "surname : " + getSurname() + "\n" +
                                "password: " + getPassword() + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!stringNickname.equals(user.stringNickname)) return false;
        if (!stringName.equals(user.stringName)) return false;
        if (!stringSurname.equals(user.stringSurname)) return false;
        return stringPassword.equals(user.stringPassword);
    }

    /**
        Will be override
     */
    public abstract void showBooks();
}
