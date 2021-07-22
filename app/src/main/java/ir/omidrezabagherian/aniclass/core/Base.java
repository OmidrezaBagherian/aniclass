package ir.omidrezabagherian.aniclass.core;
/*

@created in 18/07/2021 - 4:25 PM
@project AniClass
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.app.Application;
import android.content.Context;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import ir.omidrezabagherian.aniclass.local.room.AniClassDataBase;
import ir.omidrezabagherian.aniclass.local.room.dao.AniClassDao;

public class Base extends Application {
    private static Context mContext;
    private static AniClassDao dao;
    
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        RxJavaPlugins.setErrorHandler(throwable -> {}); // nothing or some logging
        dao = AniClassDataBase.getDatabase(this).getDao();
    }
    
    public static Context getContext() {
        return mContext;
    }
    
    public static void setContext(Context context) {
        mContext = context;
    }
    
    public static AniClassDao getDao() {
        return dao;
    }
    
}
