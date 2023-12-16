public enum Status {
    CREATE("Создан"),
    WORKING ("В сборке"),
    FINISHED ("Готов к выдаче");

    private String name;
    Status(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Status intToStatus (int Status)
    {
        return switch (Status) {
            case 0 -> CREATE;
            case 1 -> WORKING;
            case 2 -> FINISHED;
            default -> {
                System.out.println("Ошибка ввода данных!");
                yield null;
            }
        };
    }
}
