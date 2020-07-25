package club.moddedminecraft.downloadermod;

import java.io.File;
import java.net.URL;

final class ModToDownload{
    private final URL url;
    private final File targetPath;

    public ModToDownload(URL url, File targetPath){
        this.url = url;
        this.targetPath = targetPath;
    }

    public boolean downloadIfNeeded(){
        return true;
    }

}
