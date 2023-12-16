import java.util.Scanner;

public class HDD extends DataStor implements Cloneable
{
    private int speed = 0;

    protected HDD() {super();}
    protected HDD(int vol, int speed)
    {
        super(vol);
        SetHDD(speed);
    }
    private void SetHDD(int speed)
    {
        if (speed > 0)
        {
            this.speed = speed;
            this.type = "HDD";
            this.vol = vol;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }
    public int getSpeed() {
        return speed;
    }

    @Override
    public void input() {
        super.input();
        int speed;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите cкорость вращения диска: ");
        speed = scan.nextInt();

        SetHDD(speed);
    }
}
