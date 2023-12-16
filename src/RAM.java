import java.util.Scanner;
public class RAM implements BuildComp, Cloneable {
    private String type_ddr;
    private int frequency;
    private int mem;

    public RAM() { }
    public RAM(String type_ddr) {
        this.type_ddr = type_ddr;
    }
    public RAM(String type_ddr, int frequency, int mem) {
        SetRam(type_ddr, frequency, mem);
    }
    private boolean CheckCor(String type_ddr, int frequency, int mem)
    {
        return frequency>0 && mem > 0 && !type_ddr.isEmpty();
    }
    private void SetRam(String type_ddr, int frequency, int mem)
    {
        if (CheckCor(type_ddr, frequency, mem))
        {
            this.type_ddr = type_ddr;
            this.frequency = frequency;
            this.mem = mem;
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public String GetType_ddr()
    {
        return type_ddr;
    }
    public int GetFrequency() {
        return frequency;
    }
    public int getMem() {
        return mem;
    }

    @Override
    public String getObjectName() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public void input()
    {
        String type_ddr;
        int frequency, mem;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите тип памяти: ");
        type_ddr = in.nextLine();
        System.out.print("Введите частоту ОЗУ в МГЦ: ");
        frequency = in.nextInt();
        System.out.print("Введите кол-во ОЗУ в МБ: ");
        mem = in.nextInt();

        SetRam(type_ddr, frequency, mem);
    }
    @Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override public String toString() {
        String result = String.format("%s, %d МГц", this.GetType_ddr(), this.GetFrequency());
        return result;
    }
}
