import java.util.Scanner;
public class PC implements BuildComp, Cloneable
{
    private float price;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Motherboard mrbrd;
    public PC()
    {
        cpu = new CPU();
        gpu = new GPU();
        ram = new RAM();
        mrbrd = new Motherboard();
    }
    public PC(float price) {
        this.price = price;
        cpu = new CPU();
        gpu = new GPU();
        ram = new RAM();
        mrbrd = new Motherboard();
    }
    public PC(float price, CPU cpu, GPU gpu, RAM ram, Motherboard mrbrd) {
        SetPC(price,cpu,gpu,ram,mrbrd);
    }
    private void SetPC(float price, CPU cpu, GPU gpu, RAM ram, Motherboard mrbrd)
    {
        if (price>0)
        {
            this.price = price;
            this.cpu = cpu;
            this.gpu = gpu;
            this.ram = ram;
            this.mrbrd = mrbrd;
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public CPU GetCpu() {
        return cpu;
    }
    public GPU GetGpu() {
        return gpu;
    }
    public RAM GetRam() {
        return ram;
    }
    public Motherboard GetMrbrd() {
        return mrbrd;
    }
    public float GetPrice() {
        return price;
    }
    public void input_pc()
    {
        float price;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите стоимость сборки: ");
        price = in.nextFloat();
        cpu.input();
        gpu.input();
        ram.input();
        mrbrd.input();

        SetPC(price,cpu,gpu,ram,mrbrd);
    }
    public void SetCPU(CPU cpu)
    {
        this.cpu = cpu;
    }
    public void Undervolt_GPU()
    {
        if (gpu.GetTDP() -3 > gpu.GetMin_TDP())
        {
            this.gpu = new GPU(gpu.GetName_gpu(), gpu.GetVram(), gpu.GetTDP() - 3);
            if (gpu.GetTDP()<=gpu.GetMin_TDP())
                gpu = new GPU(gpu.GetName_gpu(), gpu.GetVram(), gpu.GetMin_TDP());
        }
        else
        {
            System.out.print("Undervolt невозможен!");
        }
    }
    public void out_PC()
    {
        System.out.println("\nИнформация о сборке:\n");
        System.out.printf("Процессор: %s, %d МГЦ, %d ядер, %d потоков\n", cpu.GetName(), cpu.GetFrequency(), cpu.GetCores(), cpu.GetTreads());
        System.out.printf("Видеокарта: %s, %d VRAM, %d TDP\n", gpu.GetName_gpu(), gpu.GetVram(), gpu.GetTDP());
        System.out.printf("ОЗУ: %s, %d частота, %d объём\n", ram.GetType_ddr(), ram.GetFrequency(),ram.getMem());
        System.out.printf("Материнская плата: %s, %s чипсет\n", mrbrd.GetName_mrbrd(), mrbrd.GetChipset());
        System.out.printf("Цена сборки: %.2f\n\n",price);
    }
    public static void pc_item(int option)
    {
        switch (option) {
            case 1 -> new CPU();
            case 2 -> new GPU();
            case 3 -> new RAM();
            case 4 -> new Motherboard();
            default -> throw new IllegalArgumentException("Некорректный формат данных!");
        }
    }
    @Override public Object clone() throws CloneNotSupportedException {
        PC clone = (PC) super.clone();
        clone.cpu = (CPU) this.cpu.clone();
        clone.gpu = (GPU) this.gpu.clone();
        clone.ram = (RAM) this.ram.clone();
        clone.mrbrd = (Motherboard) this.mrbrd.clone();
        return clone;
    }

    @Override
    public String getObjectName() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void input() {

    }

    static class Component
    {
        public static PC CreateComp(String name)
        {
            switch (name) {
                case "cpu" -> new CPU();
                case "gpu" -> new GPU();
                case "ram" -> new RAM();
                case "mrbrd" -> new Motherboard();
                default -> throw new IllegalArgumentException("Некорректный формат данных!");
            };
            return null;
        }
    }
}
