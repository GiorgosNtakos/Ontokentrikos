public class Main 
{
    
    public static void main(String args[])
    {
        
        Owner owner = new Owner("Takhs Tsoukalas","Takhs7Tsoukalas@hotmail.com");
        EShop eshop = new EShop("Ceid Shop", owner);
        
        Menu menu = new Menu(eshop);
        
        Buyer buyer1 = new Buyer("Kwstas Raptopoylos","RapMarmita@hotmail.com");
        Buyer buyer2 = new Buyer("Iwannhs Tsilligiris","TsiliKafeneio@yahoo.com");
        eshop.addBuyer(buyer1);
        eshop.addBuyer(buyer2);

        Paper paperA4=new Paper("A4", 2.5, "Packet of 500 pages  type of A4", 100, 654, 2000, 500);
        Paper paperA3=new Paper("A3", 3.5, "Packet of 250 pages  type of A3", 100, 653, 2534,250);
        Paper paperA2=new Paper("A2", 3.75, "Packet of 150 pages  type of A2", 100, 652, 2389,150);
        eshop.addItem(paperA4);
        eshop.addItem(paperA3);
        eshop.addItem(paperA2);
        
        Pencil pencilFaber=new Pencil("Faber", 700, "Grey Pencil type of B", 65, 701, "grey", 0.13, "B");
        Pencil pencilCamel=new Pencil("Camel", 0.42, "Yellow Pencil type of HB", 120, 671, "yellow", 0.15, "HB");
        Pencil pencilFila=new Pencil("Fila", 0.75, "Blue Pencil type of H", 55, 702, "blue", 0.18, "H");
        eshop.addItem(pencilFaber);
        eshop.addItem(pencilCamel);
        eshop.addItem(pencilFila);
        
        Pen penBic1=new Pen("Bic", 0.18, "Blue Pen with tip Size 0.8 mm", 500, 661, "blue", 0.8);
        Pen penBic2=new Pen("Bic", 0.18, "Green Pen with tip Size 0.8 mm", 500, 662, "green", 0.8);
        Pen penPilots=new Pen("Pilots", 1.2, "Blue Pen with tip Size 0.7 mm", 250, 801, "blue", 0.7);
        eshop.addItem(penBic1);
        eshop.addItem(penBic2);
        eshop.addItem(penPilots);
        
        Notebook noteSkag1=new Notebook("Skag", 0.63, "NoteBook of one section", 130, 831, 1);
        Notebook noteSkag2=new Notebook("Skag", 1.26, "NoteBook with two section", 130, 832, 2);
        Notebook noteSkag4=new Notebook("Skag", 2.42, "NoteBook with four section", 130, 833, 4);
        eshop.addItem(noteSkag1);
        eshop.addItem(noteSkag2);
        eshop.addItem(noteSkag4);
        
        buyer1.placeOrder(pencilFaber, 5);
        buyer1.placeOrder(penBic1, 10);
        buyer1.placeOrder(noteSkag2, 2);
        buyer1.placeOrder(paperA4, 3);
        
        buyer2.placeOrder(pencilCamel, 15);
        buyer2.placeOrder(penPilots, 8);
        buyer2.placeOrder(noteSkag1, 2);
        buyer2.placeOrder(paperA2,  3);
         
        menu.welcome();
        menu.enterEmail();
    }
}