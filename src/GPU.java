import java.util.Scanner;
public class GPU implements BuildComp, Cloneable{
    private String name_gpu;
    private int vram;
    private int TDP;
    private int min_TDP;
    private int flag = 0;

    public GPU() { flag = 1; }
    public GPU(String name_gpu) {
        this.name_gpu = name_gpu;
        flag = 1;
    }
    public GPU(String name_gpu, int vram, int TDP) {
        SetCPU(name_gpu, vram, TDP);
        flag = 1;
    }
    private boolean CheckCor(String name_gpu, int vram, int TDP)
    {
        return vram > 0 && TDP > 0  && !name_gpu.isEmpty();
    }
    private void SetCPU(String name_gpu, int vram, int TDP)
    {
        if (CheckCor(name_gpu, vram, TDP))
        {
            this.name_gpu = name_gpu;
            this.vram = vram;
            this.TDP = TDP;
            if (flag == 0)
            {
                this.min_TDP = TDP * 85 / 100;
                flag = 1;
            }
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public String GetName_gpu() {
        return name_gpu;
    }
    public int GetVram() {
        return vram;
    }
    public int GetTDP() {
        return TDP;
    }
    public int GetMin_TDP() {
        return min_TDP;
    }

    @Override
    public String getObjectName() {
        return "GPU";
    }

    @Override
    public String getName() {
        return name_gpu;
    }

    public void input()
    {
        {
            String name_gpu;
            int vram, TDP;

            Scanner in = new Scanner(System.in);

            System.out.print("Введите название видеокарты: ");
            name_gpu = in.nextLine();
            System.out.print("Введите объём видеопамяти в МБ: ");
            vram = in.nextInt();
            System.out.print("Введите TDP в ваттах: ");
            TDP = in.nextInt();

            SetCPU(name_gpu, vram, TDP);
        }
    }
    @Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
