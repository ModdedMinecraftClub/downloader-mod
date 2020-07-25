package club.moddedminecraft.downloadermod;

public final class RestartYourClientException extends RuntimeException{

    public RestartYourClientException(){
        super("This error is harmless. Simply restart your client.");
    }

}
