import java.util.Scanner;
public abstract class DataStor
{
    protected int vol = 0;
    protected String type;
    protected DataStor() { }
    protected DataStor(int vol) { this.vol = vol; }
    protected DataStor(String type, int vol)
    {
        SetDataStor(type, vol);
    }
    private void SetDataStor(String type, int vol)
    {
        if (vol > 0)
        {
            this.type = type;
            this.vol = vol;
        }
        else throw new IllegalArgumentException("Некорректный формат данных!");
    }
    //вспомогательный класс "фабрика" объектов DataStorage
    static class DataStor1 {
        public static DataStor createDataStor(String type) {
            return switch (type) {
                case "HDD" -> new HDD();
                case "SSD" -> new SSD();
                default -> throw new IllegalArgumentException("Некорректный формат данных!");
            };
        }
    }
    public int getVol() {
        return vol;
    }
    public String getType() {
        return type;
    }
    public void input() {
        int capacity;
        String type;

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите вместимость (в ГБ): ");
        vol = scan.nextInt();
        System.out.print("Введите интерфейс подключения (PATA - 0, SATA - 1, SAS - 2, NVMe - 3): ");
        type = scan.nextLine();

        SetDataStor(type, vol);
    }
}
