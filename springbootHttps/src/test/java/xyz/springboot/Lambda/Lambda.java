package xyz.springboot.Lambda;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Supplier;

public class Lambda {
    
    public static void main(String[] args) {
            printIfValidIndex(0, () -> getVeryExpensiveValue());
            printIfValidIndex(2, () -> getVeryExpensiveValue());
            printIfValidIndex(-1, () -> getVeryExpensiveValue());
    }

    private static String getVeryExpensiveValue(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Dahun";
    }

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier){
        if(number >= 0){
            System.out.println("Tehe value is "+ valueSupplier.get() +" .");
        }else{
            System.out.println("Invalid");
        }
    }
    
}