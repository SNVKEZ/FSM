import java.util.ArrayList;

public class DSM {

    ArrayList<Character> inpSymbls = new ArrayList<>();
    ArrayList<Character> fortunets = new ArrayList<>();
    Character startFortun;
    ArrayList<Character> endSost = new ArrayList<>();
    Character[][] tableTransf;
    char[] word;

    DSM(ArrayList<Character> inpSymbls, ArrayList<Character> fortunets, Character startFortun,
        ArrayList<Character> endSost, Character[][] tableTransf, char[] word){
        this.inpSymbls=inpSymbls;
        this.fortunets=fortunets;
        this.endSost=endSost;
        this.startFortun=startFortun;
        this.tableTransf=tableTransf;
        this.word=word;
    }

    int col=0;
    int line=0;


    public void Determian() {
        while(word[0]!=startFortun){
            for(int i=0;i<word.length;i++)
            {

            }
        }
    }
}
