package club.moddedminecraft.downloadermod;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import javax.swing.*;
import java.util.ArrayList;

@Mod(modid = DownloaderMod.MODID, version = DownloaderMod.VERSION)
public final class DownloaderMod
{
    public static final String MODID = "Downloader Mod by Modded Minecraft Club";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event){

        JOptionPane.showMessageDialog(null, "To deal with licensing restrictions, some mods need to be installed after the game launches. To ensure that these mods are properly loaded, your client will now close. Please restart it to continue.");
        throw new RestartYourClientException();
    }

    private ArrayList<ModToDownload> loadModsList(){


    }

}
