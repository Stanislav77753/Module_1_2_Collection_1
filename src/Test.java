import myExceptions.MyIndexOutOfBoundsException;
import myExceptions.MyNoSuchFieldException;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyDynamicArrayList myDynamicArrayList = new MyDynamicArrayList();
        MyDynamicArrayList myDynamicArrayList1 = new MyDynamicArrayList(-10);
       /* List list = new ArrayList();
        list.remove("Str");
        list.get(3);*/
        for(int i = 0; i < 9; i++){
            myDynamicArrayList.add((0 + (int)(Math.random()*100)));
        }

        for(Object x : myDynamicArrayList){
            System.out.print(x + " ");
        }
        System.out.println();
        try {
            System.out.println(myDynamicArrayList.findMaxElement());
        } catch (MyNoSuchFieldException e) {
            e.printStackTrace();
        }

        /*System.out.println(myDynamicArrayList.findMinElement());
        System.out.println(myDynamicArrayList.findAverage());*/
        try {
            System.out.println(myDynamicArrayList.findElementByIndex(85));
        } catch (MyIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(myDynamicArrayList.findIndexElement());
    }
}
