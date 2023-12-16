import java.util.Scanner;
public class Motherboard implements Cloneable {
    private String name_mrbrd;
    private String chipset;
    public Motherboard() { }
    public Motherboard(String name_mrbrd) {
        this.name_mrbrd = name_mrbrd;
    }
    public Motherboard(String name_mrbrd, String chipset) {
        SetMrbrd(name_mrbrd, chipset);
    }
    private boolean CheckCor(String name_mrbrd, String chipset)
    {
        return !name_mrbrd.isEmpty() && !chipset.isEmpty();
    }
    private void SetMrbrd(String name_mrbrd, String chipset)
    {
        if (CheckCor(name_mrbrd, chipset))
        {
            this.name_mrbrd = name_mrbrd;
            this.chipset = chipset;
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public String GetName_mrbrd() {
        return name_mrbrd;
    }
    public String GetChipset() {
        return chipset;
    }
    public void input()
    {
        String name_mrbrd, chipset;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите название материнской платы: ");
        name_mrbrd = in.nextLine();
        System.out.print("Введите чипсет: ");
        chipset = in.nextLine();

        SetMrbrd(name_mrbrd, chipset);
    }
    @Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
