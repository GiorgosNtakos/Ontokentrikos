public class Notebook extends Item {
    private int sections;

    public Notebook(String name, double price, String description, int stock, int id,
                    int sections) {
        super(name, price, description, stock, id);
        this.sections = sections;
    }

    public int getSections() { return sections; }
    public void setSections(int sections) { this.sections = sections; }

    @Override
    public String getDetails() {
        return "\nNumber of sections: " + this.sections;
    }
}
