package Backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import javafx.scene.image.Image;
/**
 *
 * @author Opsi Jay
 */
class SuiteDeck_Controller {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        
        Suite[] suites= new Suite[0];
        Power[] abilities=new Power[0];
        System.out.println("Press 1 to make a new Suite, any other Key to Exit");
        int input=scan.nextInt();
        
        while(input==1){
            suites=addSuites(suites,createSuites());
            System.out.println("Press 1 to make a new Suite, any other Key to Exit");
            input=scan.nextInt();
        }
        
        System.out.println("Type the numbers Associated with These Powers, Type 0 if you don't have the Power");
        for(ability a:ability.values()){
            if((a!=ability.NORMAL)&&(a!=ability.JOKER)){
                System.out.print(a.toString() + " :");
                input=scan.nextInt();
                abilities = addPowers(abilities,new Power(a,input));
            }
        }
        Deck deck = new Deck(suites,abilities);
      
    }
    static int [] add(int [] ranks,int input){
        int[] newArr = new int[ranks.length+1];
        System.arraycopy(ranks, 0, newArr, 0, ranks.length);    
        newArr[ranks.length]=input;
        return newArr;
    }
    static Suite[] addSuites(Suite[] suites,Suite input){
        Suite[] newArr = new Suite[suites.length+1];
        System.arraycopy(suites, 0, newArr, 0, suites.length);    
        newArr[suites.length]=input;
        return newArr;
    }
    static Suite createSuites(){
         System.out.println("Enter the Name of the Suite");
         String name = scan.next();
        System.out.println("Enter Weight");
        int weight = scan.nextInt();
        System.out.println("Enter All numbers in this Suite, Stop by entering 0 or a negative number");
        int input;
        int[] ranks= new int[0];
        input=scan.nextInt();
        while(input>0){
            ranks=add(ranks,input);
            input=scan.nextInt();
        }
        return new Suite(name,weight,ranks,new Image[0]);
    }
    static Power[] addPowers(Power[] suites,Power input){
        Power[] newArr = new Power[suites.length+1];
        System.arraycopy(suites, 0, newArr, 0, suites.length);    
        newArr[suites.length]=input;
        return newArr;
    }
}
