package club.moddedminecraft.downloadermod;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

@Mod(modid = DownloaderMod.MODID, version = DownloaderMod.VERSION)
public final class DownloaderMod{
    public static final String MODID = "Downloader Mod by Modded Minecraft Club";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event){
        ArrayList<ModToDownload> modsToDownload = loadModsList();
        boolean didDownloadAtLeastOneMod = false;

        for(ModToDownload modToDownload : modsToDownload){
            if(modToDownload.downloadIfNeeded()){
                didDownloadAtLeastOneMod = true;
            }
        }

        if(didDownloadAtLeastOneMod){
            JOptionPane.showMessageDialog(null, "To deal with licensing restrictions, some mods need to be installed after the game launches. To ensure that these mods are properly loaded, your client will now close. Please restart it to continue.");
            throw new RestartYourClientException();
        }
    }

    private ArrayList<ModToDownload> loadModsList(){
        try(
                FileReader fileReader = new FileReader("modstodownload.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            ArrayList<ModToDownload> modToDownloadArrayList = new ArrayList<>();

            String line;
            while((line = bufferedReader.readLine()) != null){
                String url = line.substring(0, line.indexOf(";"));
                String path = line.substring(url.length()+1);
                modToDownloadArrayList.add(new ModToDownload(new URL(url), new File(path)));
            }
            return modToDownloadArrayList;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}
