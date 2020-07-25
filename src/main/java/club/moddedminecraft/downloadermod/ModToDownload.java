package club.moddedminecraft.downloadermod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

final class ModToDownload{
    private final URL url;
    private final File targetPath;

    public ModToDownload(URL url, File targetPath){
        this.url = url;
        this.targetPath = targetPath;
    }

    public boolean downloadIfNeeded(){
        if(targetPath.exists()){
            System.out.println("The mod " + url + " / " + targetPath + " is already downloaded, so it will be skipped.");
            return false;
        }else{
            System.out.println("Downloading mod " + url + " to " + targetPath + ".");
            try{
                URLConnection connection = url.openConnection();
                try(
                    InputStream inputStream = connection.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
                ){
                    byte[] buffer = new byte[1024];
                    int read;
                    while((read = inputStream.read(buffer)) >= 0){
                        fileOutputStream.write(buffer, 0, read);
                    }
                }
            }catch(IOException e){
                throw new RuntimeException(e);
            }
            return true;
        }
    }

}
