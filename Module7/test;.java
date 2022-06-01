import ExternalChainingHashMap;
public class test {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> myMap = new ExternalChainingHashMap();
        myMap.put(0,0);
        myMap.put(1,1);
        myMap.put(2,2);
        myMap.put(3,3);
        myMap.put(4,4);
        myMap.put(5,5);
        myMap.put(6,6);
        myMap.put(7,7);

        System.out.println(myMap);
    }
}