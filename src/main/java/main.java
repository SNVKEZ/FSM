public class main {

    public static void dsm(){
        DSM dsm = new DSM(); // создаем детерм автомат
        dsm.InsertInfo("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\input.txt");
        // вставляем входной алфавит и тд
        dsm.InsertTable("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\tableDSM.txt");
        // вставляем таблицу переходов
        dsm.InsertWord(); // вводим слово
        dsm.Determian(); // проверяем является ли детермиантом
    }

    public static void ndsm(){
        NDSM ndsm = new NDSM(); // создаем недетрм автомат
        ndsm.InsertInfo("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\input.txt");
        ndsm.InsertTable("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\tableNDSM.txt");
        ndsm.InsertWord();
        if(ndsm.NotDetermian()){
            System.out.println("Succ");
        }else{
            System.out.println("NS");
        }
    }

    public static void ndsme(){
        NDSME ndsme = new NDSME(); // создаем недерм автомат с эпс переход
        ndsme.InsertInfo("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\input.txt");
        ndsme.InsertTable("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\tableNDSM.txt");
        ndsme.InsertTableEps("D:\\Study\\формальные ЯПэ\\FSM\\src\\main\\resources\\tableNDSME.txt");
        ndsme.InsertWord();
        ndsme.NotDetermian();
        System.out.println(ndsme.NotDetermian());
    }

    public static void main(String[] args){
        //dsm();
        //ndsm();
        ndsme();
    }
}
