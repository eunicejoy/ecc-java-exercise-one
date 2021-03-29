import java.util.*;

public class JavaExerciseOne{
    public static int x = 0;
    public static int y = 0;
    public static String[][] arrays;
    public static boolean tableIsPrinted = false;

    public static void main(String[] args) {

      int userChoice = 5;


        while(userChoice != 0){
          try{
    			System.out.println("");
    			System.out.print("Search\t[1]\nEdit\t[2]\nPrint\t[3]\nReset\t[4]\nExit\t[0] : ");
    			Scanner userInput = new Scanner(System.in);
    			userChoice = userInput.nextInt();

            switch (userChoice) {
      					case 1:
      						search();
      						break;
      					case 2:
      						edit();
      						break;
      					case 3:
      						printTable();
      						break;
                case 4:
                  reset();
                  break;
                case 0:
                  break;
                default:
                  System.out.println("Invalid input.");
                  break;
      			}
      } catch(InputMismatchException e){
          System.out.println("Invalid input.");
      }
    }
}
    public static void search(){
      int counter = 0;

      if(tableIsPrinted){
        System.out.println("");
        System.out.println("Enter strings to search: ");
        Scanner s = new Scanner(System.in);
        String searchString = s.nextLine();

        boolean notFound = true;

        System.out.println("");
        for(int x=0;x<arrays.length;x++){
          for(int y=0;y<arrays[x].length;y++){
            if(arrays[x][y].contains(searchString)){

              int n = arrays[x][y].length();
              int m = searchString.length();
              int index = arrays[x][y].indexOf(searchString);
              int i = index + 1;
              int count = (index >= 0 ) ? 1:0;

              while(index != -1 && i<=(n-m)){
                  index = arrays[x][y].substring(i, n).indexOf(searchString);
                  count = (index >= 0) ? count + 1 : count;
                  i = i + index + 1;
              }

              System.out.println("Found " + searchString + " on ("+x+", "+y+") with "+ count +" instances.");

              notFound = false;
            }
          }

        }
        if(notFound == true){
          System.out.println("String(s) not found.");
        }
      } else{
        System.out.println("Print table first.");
      }

    }

    public static void edit(){

      int indexX = 0;
      int indexY = 0;

      if(tableIsPrinted){
        try{
          System.out.println("");

      		System.out.println("Enter index you want to edit");
      		System.out.print("x:");
      		Scanner scanX = new Scanner(System.in);
      		indexX = scanX.nextInt();
      		System.out.print("y:");
      		Scanner scanY = new Scanner(System.in);
      		indexY = scanY.nextInt();

        } catch(Exception e){
          System.out.println("Index not found.");
        } finally{
          System.out.println("Enter new characters: ");
      		Scanner scanNewChars = new Scanner(System.in);
      		String newChars = scanNewChars.nextLine();

      		arrays[indexX][indexY] = newChars;

      		System.out.println("");

      		for(int i=0;i<x;i++){
      		    for(int j=0;j<y;j++) {
      		        System.out.print(arrays[i][j]+"|");
      		    }
      		    System.out.println("");
      		}
        }
      } else{
        System.out.println("Print table first.");
      }
    }

    public static void reset(){
      printTable();
    }
    public static void createArray(int a, int b){
      arrays = new String[a][b];
    }

    public static void printTable(){



      System.out.println("Enter table dimensions");

      System.out.print("x: ");
      Scanner inputX = new Scanner(System.in);
      x = inputX.nextInt();

      System.out.print("y: ");
      Scanner inputY = new Scanner(System.in);
      y = inputY.nextInt();

      createArray(x, y);

      System.out.println("");

      for(int i=0;i<x;i++){
  		    for(int j=0;j<y;j++) {
  						arrays[i][j] = generateRandomCharacters();
  		        System.out.print(" " + arrays[i][j]+" |");
              tableIsPrinted = true;
  		    }
  		    System.out.println("");
  		}
    }

    public static String generateRandomCharacters(){
    //String characters = "!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
      String characters = "abcdefghijklmnopqrstuvwxyz";
    //String characters = "ab";
  		String randomCharacters = "";
  		int size = characters.length();

  		Random random = new Random();

  		for(int i = 1; i<4; i++){

  			String character = Character.toString(characters.charAt(random.nextInt(size)));
  			randomCharacters += character;
  		}

  		return randomCharacters;
    }

}
