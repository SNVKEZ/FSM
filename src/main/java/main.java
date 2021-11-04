import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class main {



    public static void main(String[] args){

        FileInputStream file =null;
        InputStreamReader inputStreamReader = null;
        ArrayList<ArrayList<Character>> arrayList = new ArrayList<ArrayList<Character>>();
        ArrayList<Character> arrayListIN = new ArrayList<Character>();
        int b=0;
        char zap = ',';
        char tchk = '.';

        try {
            file = new FileInputStream("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\input.txt");
            inputStreamReader = new InputStreamReader(file, "UTF-8");
            while ((b=inputStreamReader.read())!=(-1)){
                if( Character.isLetterOrDigit((char)b))
                {
                    arrayListIN.add((char)b);
                }
                if ((((char)b)==zap) || (char)b==tchk){
                    ArrayList<Character> newArray = (ArrayList<Character>) arrayListIN.clone();
                    arrayList.add(newArray);
                    arrayListIN.clear();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Character> inputSymbol = new ArrayList<>(arrayList.get(0));
        ArrayList<Character> fortunes = new ArrayList<>(arrayList.get(1));
        Character startFortunet = (arrayList.get(2)).get(0);
        ArrayList<Character> endFort = new ArrayList<>(arrayList.get(3));
        int column = fortunes.size();
        int line = inputSymbol.size();

        int columnCount = 0;
        int lineCount = 0;

        Character[][] arr = new Character[line][column];

        try {
            file = new FileInputStream("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\tableDSM.txt");
            inputStreamReader = new InputStreamReader(file, "UTF-8");
            while ((b=inputStreamReader.read())!=(-1)){
                if (Character.isLetterOrDigit(b)){
                    arr[columnCount][lineCount] = (char)b;
                    columnCount++;
                }
                if(((char)b==zap || (char)b== tchk) ){
                    columnCount=0;
                    lineCount++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a lenght of word:");
        int count = in.nextInt();
        System.out.println("Please enter the word:");
        String word = in.nextLine();
        char[] word1 = word.toCharArray();


        DSM dsm = new DSM(inputSymbol,fortunes,startFortunet,endFort,arr,word1);
        dsm.Determian();
    }
}
