public class Paper extends Item {
    private int weight;
    private int pages;

    public Paper(String name, double price, String description, int stock, int id,
                 int weight, int pages) {
        super(name, price, description, stock, id);
        this.weight = weight;
        this.pages = pages;
    }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String getDetails() {
        return "\nWeight in grams: " + this.weight +
               "\nNumber of pages: " + this.pages;
    }
}
