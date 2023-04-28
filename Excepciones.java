class NoHayProductoException extends Exception{
    public NoHayProductoException(String mensaje){
        super(mensaje);
    }
}

class PagoInsuficienteException extends Exception{
    public  PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}

class PagoIncorrectoException extends  Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
