import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class NDSME{
    NDSME(){}


    ArrayList<ArrayList<Character>> arrayList1 = new ArrayList<ArrayList<Character>>();
    ArrayList<ArrayList<Character>> arrayListNDSME = new ArrayList<ArrayList<Character>>();

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

    public void InsertTableEps(String way){
        FileInputStream file = null;
        InputStreamReader inputStreamReader = null;
        int b = 0;

        ArrayList<Character> arrayList = new ArrayList<Character>();
        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
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

                    arr.add(newArr);

                    arrayList.clear();
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
        arrayListNDSME = (ArrayList<ArrayList<Character>>) arr.clone();
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





int sost1 ;

    public void findNeDerm(int count,int symb, int sost){
        ArrayList<Character> arr1 = arr[symb][sost];
        System.out.println(arr1);
        if(!arrayListNDSME.get(sost).contains('-')) {
            if(arr1.contains('-')){
                arr1.clear();
            }
            for (int i = 0; i < arrayListNDSME.get(sost).size(); i++) {
                arr1.add(arrayListNDSME.get(sost).get(i));
            }
        }
        lp:
        {
            for (int i = 0; i < arr1.size(); i++) {

                if ((arr1.get(i) != arrayList1.get(1).get(sost)) && (arr1.get(i)!='-')) {
                    sost = arrayList1.get(1).indexOf(arr1.get(i));
                    sost1 = sost;
                    if (count < word1.length - 1) {
                        findNeDerm(count + 1, (arrayList1.get(0)).indexOf(word1[count + 1]), sost);
                    }
                }

                if ((arrayList1.get(3).contains(arrayList1.get(1).get(sost))) && (word1[count] == word1[word1.length - 1])) {

                    flag=true;
                    break lp;
                }




            }


        }

    }


    public void toEps(){

    }

    public Boolean NotDetermian() {
        Character stF = ((arrayList1.get(2)).get(0));
        int symb = (arrayList1.get(0)).indexOf(word1[0]);
        int sost = (arrayList1.get(1)).indexOf(stF);

        findNeDerm(0,symb,sost);

        if(flag==false){
            for(int i=0;i<arrayList1.get(3).size();i++)
                for (int j=0;j<arrayListNDSME.get(sost1).size();j++)
                {
                    if(arrayListNDSME.get(sost1).get(j)==arrayList1.get(3).get(i)){
                        flag=true;
                    }
                }
        }

        if(flag){
            return true;
        }else{
            return false;
        }
    }

}
