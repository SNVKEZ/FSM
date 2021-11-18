import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DSM {

    DSM() {
    }

    ArrayList<ArrayList<Character>> arrayList1 = new ArrayList<ArrayList<Character>>();

    public void InsertInfo(String way) {
        FileInputStream file = null;
        InputStreamReader inputStreamReader = null;
        ArrayList<ArrayList<Character>> arrayList = new ArrayList<ArrayList<Character>>();
        ArrayList<Character> arrayListIN = new ArrayList<Character>();
        int b = 0;
        try {
            file = new FileInputStream(way);
            inputStreamReader = new InputStreamReader(file, "UTF-8");
            while ((b = inputStreamReader.read()) != (-1)) {
                if (Character.isLetterOrDigit((char) b)) {
                    arrayListIN.add((char) b);
                }
                if ((((char) b) == ',') || (char) b == '.') {
                    ArrayList<Character> newArray = (ArrayList<Character>) arrayListIN.clone();
                    arrayList.add(newArray);
                    arrayListIN.clear();
                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
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
        arrayList1 = (ArrayList<ArrayList<Character>>) arrayList.clone();
    }



    int columnCount = 0;
    int lineCount = 0;

    Character[][] arr;

    public void InsertTable(String way) {
        FileInputStream file = null;
        InputStreamReader inputStreamReader = null;
        int b = 0;
        Character[][] arr1 = new Character[(arrayList1.get(0)).size()][(arrayList1.get(1)).size()];
        try {
            file = new FileInputStream(way);
            inputStreamReader = new InputStreamReader(file, "UTF-8");
            while ((b = inputStreamReader.read()) != (-1)) {
                if (Character.isLetterOrDigit(b)) {
                    arr1[columnCount][lineCount] = (char) b;
                    columnCount++;
                }
                if (((char) b == ',' || (char) b == '.')) {
                    columnCount = 0;
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
        arr = arr1.clone();
    }

    char[] word1;

    public void InsertWord() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the word:");
        String word = in.nextLine();
        word1 = word.toCharArray();
        for(int i = 0;i<word1.length;i++){
            if (!arrayList1.get(0).contains(word1[i])){
                InsertWord();
            }
        }
    }

    public void Determian() {
        ArrayList<Character> sostoyaniya = new ArrayList<>();
        Character stF = ((arrayList1.get(2)).get(0));
        sostoyaniya.add(stF);
        Boolean flag = true;

        for (int i = 0; i < word1.length; i++) {
            lb:
            {
                int symb = (arrayList1.get(0)).indexOf(word1[i]);
                int sost = (arrayList1.get(1)).indexOf(stF);
                if (arr[symb][sost] == arrayList1.get(1).get(sost)) {
                    flag = false;
                    break;
                } else {
                    stF = arr[symb][sost];
                    sostoyaniya.add(stF);
                }
            }
        }
        if (flag && (arrayList1.get(3)).contains(stF)) {
            System.out.println("It's a DSM");
            for(int i=0;i<sostoyaniya.size();i++){
                if(i==0){
                    System.out.print(sostoyaniya.get(i)) ;
                }else{
                System.out.print(" -> "+sostoyaniya.get(i));
            }}
        } else {
            System.out.println("Error, It's not a DSM");
        }
    }


}