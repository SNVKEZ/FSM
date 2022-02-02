import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NDSM {
    NDSM(){}

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

    ArrayList<Character>[][] arr;

    public void InsertTable(String way) {
        FileInputStream file = null;
        InputStreamReader inputStreamReader = null;
        int b = 0;

        ArrayList<Character> arrayList = new ArrayList<Character>();
        ArrayList<Character>[][] arr1 = new ArrayList[(arrayList1.get(0)).size()][(arrayList1.get(1)).size()];
        try {
            file = new FileInputStream(way);
            inputStreamReader = new InputStreamReader(file, "UTF-8");
            while ((b = inputStreamReader.read()) != (-1)) {
                if(Character.isLetterOrDigit((char)b) || ((char)b=='-'))
                {
                    arrayList.add((char)b);
                }

                if ((char) b == '}') {
                    ArrayList<Character> newArr = (ArrayList<Character>) arrayList.clone();

                    arr1[columnCount][lineCount] = newArr;
                    arrayList.clear();
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

    Boolean flag=false;







    public void findNeDerm(int count,int symb, int sost){
        ArrayList<Character> arr1 = arr[symb][sost];

        lp:
        {
            for (int i = 0; i < arr1.size(); i++) {
                if ((arr1.get(i) != arrayList1.get(1).get(sost)) && (arr1.get(i)!='-')) {
                    sost = arrayList1.get(1).indexOf(arr1.get(i));
                    if (count < word1.length - 1) {
                        findNeDerm(count + 1, (arrayList1.get(0)).indexOf(word1[count + 1]), sost);
                    }
                }

                if ((arrayList1.get(3).contains(arrayList1.get(1).get(sost))) && (word1[count] == word1[word1.length - 1])) {

                    flag=true;
                    break lp;
                }

                if (arr1.get(i) == '-') {
                    break lp;
                }

            }
        }

    }

    public Boolean NotDetermian() {
        Character stF = ((arrayList1.get(2)).get(0));



        int symb = (arrayList1.get(0)).indexOf(word1[0]);
        int sost = (arrayList1.get(1)).indexOf(stF);



        findNeDerm(0,symb,sost);
        if(flag){
            return true;
        }else{
            return false;
        }
    }
}
