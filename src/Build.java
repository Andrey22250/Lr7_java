import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
public class Build<T extends BuildComp> {
    private static int number = 1;
    private int numBuild;
    private PC pc;
    private String client;
    private Status status;
    private T objectOfBuild;
    public Build()
    {
        this.pc = new PC();
        this.status = Status.CREATE;
        this.numBuild = number;

        number++;
    }
    public Build(T objectOfBuild) {
        this();
        this.objectOfBuild = objectOfBuild;
    }
    public Build(String client)
    {
        this.pc = new PC();
        this.status = Status.CREATE;
        this.numBuild = number;
        this.client = client;

        number++;
    }
    public Build(int Stat)
    {
        this.pc = new PC();
        this.status = Status.intToStatus(Stat);
        this.numBuild = number;
        this.client = client;

        number++;
    }
    public Build(String client, PC pc, Status status)
    {
        SetBuild(client, pc, status);
        number++;
    }
    private boolean CheckCor(String client)
    {
        return !client.isEmpty();
    }
    private void SetBuild(String client, PC pc, Status status)
    {
        if (CheckCor(client))
        {
            this.pc = pc;
            this.status = status;
            this.numBuild = number;
            this.client = client;
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public static int GetNumber() {return number;}
    public int GetNumBuild() {
        return numBuild;
    }
    public PC GetPc() {
        return pc;
    }
    public String GetClient() {
        return client;
    }
    public Status GetStatus() {
        return status;
    }
    public void input_build() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String client;
        //приходится использовать рефлексию, чтобы создать объект типа T
        Class<T> clazz = (Class<T>)this.objectOfBuild.getClass();
        T objectOfBuild = clazz.getDeclaredConstructor().newInstance();
        Status status;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя клиента: ");
        client = in.nextLine();
        System.out.println("\tВвод параметров объекта заказа");
        objectOfBuild.input();
        System.out.print("Введите статус заказа \n0 - Заказ создан\n1 - Заказ в работе\n2 - Заказ выполнен\nВаш выбор: ");
        status = Status.intToStatus(in.nextInt());

        this.objectOfBuild = objectOfBuild;
        this.status = status;

        SetBuild(client, pc, status);
    }
    public void out_build()
    {
        System.out.print("\nИнформация о заказе:\n\n");
        System.out.printf("Номер заказа: %d\n", GetNumBuild());
        System.out.printf("Клиент - %s\n", GetClient());
        System.out.printf("Статус - %s\n", status.getName());
        pc.out_PC();
    }
    public void ChangeStatus(Status newstatus)
    {
        if (newstatus.compareTo(Status.CREATE) >= 0 && newstatus.compareTo(Status.FINISHED) <= 0)
        {
            this.status = newstatus;
            System.out.print("Состояние заказа успешно изменено!\n");
        }
        else {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    static class Stat
    {
        public static int GetStat(String name)
        {
            return switch (name)
            {
                case "Создан" -> 0;
                case "В сборке" -> 1;
                case "Готов к выдаче" -> 2;
                default -> throw new IllegalArgumentException("Некорректный формат данных!");
            };
        }
    }
}