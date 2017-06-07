package com.lemon.faceu.sdk.utils;

import android.content.Context;
import android.util.*;

import com.martin.ads.omoshiroilib.debug.removeit.GlobalConfig;
import com.martin.ads.omoshiroilib.util.ShaderUtils;

/**
 * Created by Ads on 2017/6/6.
 */

public class JniEntry {
    private static final String TAG = "JniEntry";
    public JniEntry() {
    }

    public static native void logInit(String var0, String var1, String var2, byte[] var3);

    public static native void logWrite(String var0);

    public static native void logUninit();

    public static native void XXTea(byte[] var0, byte[] var1, int var2);

    public static native void YUVtoRBGA(byte[] var0, int var1, int var2, byte[] var3);

    public static native void YUVtoARBG(byte[] var0, int var1, int var2, int[] var3);

    public static void YuvToGrayAndScaleJava(byte[] var0, int var1, int var2, int var3, boolean var4, byte[] var5, int var6, int var7){
        //about 24ms
        //Log.d(TAG, "YuvToGrayAndScaleJava: start");
        YuvToGrayAndScale(var0, var1,  var2, var3, var4, var5, var6,var7);
        //Log.d(TAG, "YuvToGrayAndScaleJava: end");
    }

    public static native void YuvToGrayAndScale(byte[] var0, int var1, int var2, int var3, boolean var4, byte[] var5, int var6, int var7);

    public static int initJava(Context var0){
        return init(var0);
    }

    public static native int init(Context var0);

    public static native int LoadDecorateFilter();

    public static native int LoadBlackWhiteFilter();

    public static native int LoadBeautifyFilter(int var0);

    public static native int LoadBeautifyFilterV2(int var0);

    public static native int LoadDrawFaceFilter();


    public static int testInitFilter(){
        int ret=ShaderUtils.createProgram(
                ShaderUtils.readAssetsTextFile(GlobalConfig.context,"filter/vsh/fu/no_filter.glsl"),
                ShaderUtils.readAssetsTextFile(GlobalConfig.context,"filter/fsh/fu/DStickerDotFilter.glsl"));
        Log.d(TAG, "testInitFilter: "+ret);
        return ret;
    }

    public static native int LoadDStickerVignetteFilter();

    public static native int LoadSmallModeFirstFilter();

    public static native int LoadSmallModeSecondFilter();

    public static native int LoadSmallModeMergeFilter();

    public static native int LoadSwitchFilterBase();

    public static native int LoadLightUpFilter();

    public static native int LoadWarmUpFilter();

    public static native int LoadMakeUpFilter();


    public static native int LoadDrawMultiTrangleFilter();

    static {
        System.loadLibrary("fucommon");
    }

    public static int loadDStickerDotFilterJava(boolean useXM){
        int ret=ShaderUtils.createProgram(
                ShaderUtils.readAssetsTextFile(GlobalConfig.context,"filter/vsh/fu/no_filter.glsl"),
                ShaderUtils.readAssetsTextFile(GlobalConfig.context,"filter/fsh/fu/DStickerDotFilter.glsl"));
        Log.d(TAG, "loadDStickerDotFilterJava: "+ret);
        return ret;
    }
}
