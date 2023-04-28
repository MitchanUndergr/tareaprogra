abstract class Dulce{
    private int serie;

    public Dulce(int serie){
        super();
        this.serie=serie;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String comer();
}

class Super8 extends Dulce {
    public Super8(int serie){
        super(serie);
    }

    public String comer() {
        String b = "super8";
        return b;
    }
}
class Snickers extends Dulce {
    public Snickers(int serie){
        super(serie);
    }

    public String comer(){
        String b = "snickers";
        return b;
    }
}
