class NoHayProductoException extends Exception{
   public NoHayProductoException(String mensaje){
       super(mensaje);
   }
}

class PagoInsuficienteException extends Exception{
    private Moneda m;
    public PagoInsuficienteException(Moneda m){
        this.m=m;

    }
    public Moneda pagoInsuficiente(){
        return m;
    }
}

class PagoIncorrectoException extends  Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }

}
