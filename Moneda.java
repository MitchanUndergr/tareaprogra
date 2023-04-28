abstract class Moneda{
    public Moneda(){
        super();
    }
    public Moneda getSerie(){
        return this.getSerie();
    }
    public abstract int getValor();
}
class Moneda1500 extends Moneda{
    public Moneda1500(){
        super();
    }
    public int getValor(){
        return 1500;
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }
    public int getValor(){
        return 500;
    }
}


class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }
    public int getValor(){
        return 1000;
    }
}

class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }
    public int getValor(){
        return 100;
    }
}