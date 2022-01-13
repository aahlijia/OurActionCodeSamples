package ouraction;

public class Person {

    //Variables
    private String email;
    private String username;
    private String password;
    private long mouseClicks;
    private long timeActive;
    private long keystrokes;

    //Constructor
    public Person(String eMail, String user, String pass, long mouseClicks, long keys, long time){
        //New Strings
        //this.mouseClicks += clicks;
        email = new String(eMail);
        username = new String(user);
        password = new String(pass);
        this.mouseClicks = mouseClicks;
        this.keystrokes = keys;
        this.timeActive = time;

    }

    //GETTERS FOR ALL VARIABLES
    public String getUsername(){return username;}

    public String getEmail(){
        return email;
    }

    public String getPassword() {return password;}

    public long getMouseClicks() {return mouseClicks; }
    public void setMouseClicks(int clicks){
        this.mouseClicks = this.mouseClicks + clicks;
    };

    public long getTimeActive() {return timeActive;}
    public void setTimeActive(long timeActive) {
        this.timeActive = this.timeActive + timeActive;
    }

    public long getKeystrokes() {return keystrokes;}
    public void setKeystrokes(int keystrokes){
        this.keystrokes = this.keystrokes + keystrokes;
    }

    public String toString(){
        return ("Username: " + username);
    }
    public Person toPerson(){
        return this.toPerson();
    }
}
