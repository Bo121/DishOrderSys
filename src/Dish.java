public class Dish {

    int id;
    String name;
    double price;

    //生成构造方法：command + n
    //选择多个fields：hold住 command 键，用鼠标点击多个
    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

