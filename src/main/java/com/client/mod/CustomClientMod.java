package com.client.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class CustomClientMod implements ClientModInitializer {

    public static final String MOD_ID = "clientmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // متغير لتشغيل/إيقاف الموشن بلور
    public static boolean motionBlurEnabled = true;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Custom Client Mod initialized successfully!");
    }
}
