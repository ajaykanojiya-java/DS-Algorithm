package practiceset.recursion;

public class Item {
    String name;
    int weight;
    int value;

    Item(String name, int weight, int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getPrice() {
        return value;
    }
}
