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
        ndsm.NotDetermian();
    }

    public static void ndsme(){
        NDSME ndsme = new NDSME(); // создаем недерм автомат с эпс переход
    }

    public static void main(String[] args){
        //dsm();
        ndsm();
        //ndsme();
    }
}
