package club.moddedminecraft.downloadermod;

public class ParseException extends RuntimeException{

    public ParseException(){
    }

    public ParseException(String s){
        super(s);
    }

    public ParseException(String s, Throwable throwable){
        super(s, throwable);
    }

    public ParseException(Throwable throwable){
        super(throwable);
    }

    public ParseException(String s, Throwable throwable, boolean b, boolean b1){
        super(s, throwable, b, b1);
    }
}
