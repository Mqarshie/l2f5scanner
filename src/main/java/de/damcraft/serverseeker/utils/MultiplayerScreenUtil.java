package de.damcraft.serverseeker.utils;

import de.damcraft.serverseeker.mixin.MultiplayerScreenAccessor;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerInfo;

public class MultiplayerScreenUtil {

    public static void addInfoToServerList(MultiplayerScreen mps, ServerInfo info) {
        addInfoToServerListInternal(mps, info, false);
    }

    public static void addInfoToServerList(MultiplayerScreen mps, ServerInfo info, boolean reload) {
        addInfoToServerListInternal(mps, info, reload);
    }

    public static void addNameIpToServerList(MultiplayerScreen mps, String name, String ip) {
        ServerInfo info = new ServerInfo(name, "", ServerInfo.ServerType.OTHER); // Empty IP
        addInfoToServerListInternal(mps, info, false);
    }

    public static void addNameIpToServerList(MultiplayerScreen mps, String name, String ip, boolean reload) {
        ServerInfo info = new ServerInfo(name, "", ServerInfo.ServerType.OTHER); // Empty IP
        addInfoToServerListInternal(mps, info, reload);
    }

    public static void reloadServerList(MultiplayerScreen mps) {
        MultiplayerScreenAccessor mpsAccessor = (MultiplayerScreenAccessor) mps;
        mpsAccessor.getServerListWidget().setServers(mps.getServerList());
    }

    public static void saveList(MultiplayerScreen mps) {
        mps.getServerList().saveFile();
    }

    private static void addInfoToServerListInternal(MultiplayerScreen mps, ServerInfo info, boolean reload) {
        MultiplayerScreenAccessor mpsAccessor = (MultiplayerScreenAccessor) mps;
        mps.getServerList().add(info, false);
        if (reload) mpsAccessor.getServerListWidget().setServers(mps.getServerList());
        mps.getServerList().saveFile();
    }
}
