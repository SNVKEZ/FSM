public class main {

    public static void main(String[] args){
        DSM dsm = new DSM();
        dsm.InsertInfo("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\input.txt");
        dsm.InsertTable("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\tableDSM.txt");
        dsm.InsertWord();
        dsm.Determian();
    }
}
