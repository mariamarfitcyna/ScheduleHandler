public class Cabinet {

    public Cabinet(int number, int lesson){
        this.number = number;
        this.status[lesson] = 1;
    }

    private String address;
    private int number;
    private int[] status = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public int getNumber(){
        return this.number;
    }
    public void print() {System.out.println("print");};
}
