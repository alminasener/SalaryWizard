class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    //kişinin bilgilerini ekrana yazdır
    public void displayInfo() {
        System.out.println("Name: " + name);
    }
}
