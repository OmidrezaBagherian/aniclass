package ir.omidrezabagherian.aniclass.core;
/*

@created in 18/07/2021 - 4:25 PM
@project AniClass
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.app.Application;
import android.content.Context;

public class Base extends Application {
    private static Context mContext;
    
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    
    public static Context getContext() {
        return mContext;
    }
    
    public static void setContext(Context context) {
        mContext = context;
    }
    
    
}
