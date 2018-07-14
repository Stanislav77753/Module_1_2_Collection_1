public class Test {
    public static void main(String[] args) {
        MyDynamicArrayList myDynamicArrayList = new MyDynamicArrayList();
        MyDynamicArrayList myDynamicArrayList1 = new MyDynamicArrayList(-10);
        for(int i = 0; i < 2; i++){
            myDynamicArrayList.add((0 + (int)(Math.random()*100)));
        }
        myDynamicArrayList.remove();
        myDynamicArrayList.remove();

        for(Object x : myDynamicArrayList){
            System.out.print(x + " ");
        }
        System.out.println();
        myDynamicArrayList.remove();
        myDynamicArrayList.remove();
        myDynamicArrayList.remove();
        for(Object x : myDynamicArrayList){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(myDynamicArrayList.findMaxElement());
        System.out.println(myDynamicArrayList.findMinElement());
        System.out.println(myDynamicArrayList.findAverage());
        System.out.println(myDynamicArrayList.findElementByIndex(3));
        //System.out.println(myDynamicArrayList.findIndexElement());
    }
}
