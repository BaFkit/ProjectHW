package Java_2.Lesson3.part2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private final HashMap <Integer, String> phoneList = new HashMap<>();

       public void add(int phone, String surname){
           phoneList.put(phone, surname);
       }

       public ArrayList<Integer> getPhone(String surname){
            ArrayList<Integer> phone = new ArrayList<>();
            for (Integer a: phoneList.keySet()){

                if(phoneList.get(a).equals(surname)){
                    System.out.println(surname + " - №:" + a);
                    phone.add(a);
                }

            }
            return phone;
       }

}
