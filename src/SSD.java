import java.util.Scanner;

public class SSD extends DataStor implements Cloneable
{
    private int speed = 0;
    private String TypeSSD;
    protected SSD() { super(); }
    protected SSD(int vol, int speed, String TypeSSD )
    {
        super(vol);
        SetSSD(speed, TypeSSD);
    }
    private void SetSSD(int speed, String TypeSSD)
    {
        if (speed > 0)
        {
            this.speed = speed;
            this.type = "SSD";
            this.vol = vol;
            this.TypeSSD = TypeSSD;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }
    public int getSpeed() {
        return speed;
    }
    public String getTypeSSD() {
        return TypeSSD;
    }
    @Override
    public void input() {
        super.input();
        int speed;
        String TypeSSD;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите cкорость диска: ");
        speed = scan.nextInt();
        System.out.print("Введите тип SSD: ");
        TypeSSD = scan.nextLine();

        SetSSD(speed, TypeSSD);
    }
}
