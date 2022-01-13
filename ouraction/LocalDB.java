package ouraction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocalDB {
    private static Map data;
     //references the number of elements in the lists
    private static String location = "users.txt";

    static String user;
    static String pass;
    static String email;
    static long clicks;
    static long keys;
    static long time;

    static int nElems;
    //Map value <Username, Person(email, username, password>
    static Map<String, Person> personMap = new HashMap<String, Person>();
    static Map<String, Stats> statsMap = new HashMap<String,Stats>();
    //Map value <Username, Email> for user and email cnfirmation
    static Map<String, String> userEmailMap = new HashMap<String,String>();

    public LocalDB(){
        data = readIn("users.txt");
        System.out.println("This Worked!");
    }

    public static Map<String,Person> readIn(String location){
        System.out.println("ReadIn Called\n\n");
        nElems = 0;

        System.out.println("ReadIn is Working in Main");

        Scanner sc;
        try{
            sc = new Scanner(new FileInputStream(location));
            while(sc.hasNext()){
                email = sc.next();
                user = sc.next();
                pass = sc.next();
                clicks = sc.nextLong();
                keys = sc.nextLong();
                time = sc.nextLong();

                Person person = new Person(email, user, pass,clicks,keys,time);

                if(!personMap.containsKey(user)){
                    personMap.put(user, person);
                    userEmailMap.put(user, email);
                    String userTest = personMap.get(user).getUsername();
                    System.out.println(userTest);
                }
                else
                    System.out.println("duplicate");

                //Create find duplicate method within database structure to reference and delete dups
                //data[nElems] = new Person(email, user, pass, 0);
                nElems++;


            }
            sc.close();
        }
        catch (IOException f){
            System.out.println(f);
        }
    return personMap;
    }

}
