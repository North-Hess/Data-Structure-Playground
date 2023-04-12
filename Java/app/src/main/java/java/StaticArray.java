package java;

public class StaticArray {
    public static void main(String[] args) {
        // Static arrays are the default array in Java
        // Specify size on initialization and type 
        // to be held
        var staticArray = new int[5];
        System.out.println(staticArray);
        // prints pointer/location in mem of array
        // rather than data it is holding
    }
}
