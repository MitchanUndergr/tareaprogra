abstract class Bebida{
    private int serie;

    public Bebida(int serie){
        super();
        this.serie=serie;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    public String beber(){
        String b="sprite";
        return b;
    }

}

class CocaCola extends Bebida{
    public CocaCola(int serie){
        super(serie);
    }
    public String beber(){
        String b="cocacola";
        return b;
    }

}