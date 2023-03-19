package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args)
    {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Bannana");
        myList.add("Grapes");
        myList.add("Chikku");
        myList.add("watermelon");

        System.out.println("Print all the names");
        for (String s:myList)
        {
            System.out.println(s);
        }

        System.out.println("Is Bannana is in List: "+myList.contains("Bannana"));
        System.out.println("Third name is: "+myList.get(2));
        System.out.println("Size of the arrayList is: "+myList.size());

        myList.remove("watermelon");
        System.out.println("Size of the list is:"+myList.size());


    }
}
