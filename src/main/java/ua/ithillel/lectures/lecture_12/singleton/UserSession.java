package ua.ithillel.lectures.lecture_12.singleton;

public class UserSession {
    private String userName;
    private boolean isAdmin;
    private static UserSession instance;

    private UserSession(){
        this.userName = "Violetta";
        this.isAdmin = true;
    }

    public static UserSession getInstance(){
        if (instance == null){
            instance = new UserSession();
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
