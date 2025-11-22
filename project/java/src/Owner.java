public class Owner extends User {
    private final boolean isAdmin = true;

    public Owner(String name, String email) {
        super(name, email);
    }

    public boolean isAdmin() { return isAdmin; }

    public void getOwnerInfo() {
        System.out.println("This user is the Owner.");
        super.userInfo();
    }
}
