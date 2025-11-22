public class Pencil extends Item {
    private String color;
    private double tipSize;
    private String type;

    public Pencil(String name, double price, String description, int stock, int id,
                  String color, double tipSize, String type) {
        super(name, price, description, stock, id);
        this.color = color;
        this.tipSize = tipSize;
        this.type = type;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double gettipSize() { return tipSize; }

    // ✅ ΔΙΟΡΘΩΣΗ: ήταν λάθος όνομα μεθόδου
    public void settipSize(double tipSize) { this.tipSize = tipSize; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String getDetails() {
        return "\nPencil color: " + this.color +
               "\nPencil tip size: " + this.tipSize +
               "\nPencil type in mm: " + this.type;
    }
}
