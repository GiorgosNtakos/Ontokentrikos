public class MarriedPerson extends Person
 {
  private int children;
  public MarriedPerson(String lastname, String firstname, int age, float salary, int sex, int children) 
 {
  super(lastname, firstname, age, true, salary, sex);
  this.children = children;
 }
    public int getNoOfChildren() { return children; }
    public void setNoOfChildren(int children){this.children=children;}
    public void setMarried(boolean married){}
    public void setSalary(MarriedPerson spouse)
    { 
        if(spouse.getSex() != getSex())
        {setSalary(getSalary()+spouse.getSalary());}
        else
        {}
    }
    public void printInfo()
    {
        System.out.println();
        super.printInfo();
        System.out.print("She has ");
        if (getNoOfChildren() > 0)
       System.out.print(getNoOfChildren());
     else System.out.print("no");
       System.out.println(" children.");
    }
 } 