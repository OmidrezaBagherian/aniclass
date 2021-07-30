package ir.omidrezabagherian.aniclass.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.omidrezabagherian.aniclass.R;
import ir.omidrezabagherian.aniclass.adapter.FollowStudentAdapter;
import ir.omidrezabagherian.aniclass.core.Base;
import ir.omidrezabagherian.aniclass.local.shared_pref.AniclassSharedPref;

public class FollowedStudentActivity extends AppCompatActivity {

    private Toolbar toolbarFollowedStudent;
    private DrawerLayout drawerLayoutFollowedStudent;
    private NavigationView navigationViewFollowedStudent;
    private RecyclerView recyclerViewFollowedStudentClasses;
    private FollowStudentAdapter adapter;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private long currentId = -1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followed_student);
        currentId = AniclassSharedPref.getCurrentId();
        
        toolbarFollowedStudent = (Toolbar) findViewById(R.id.toolbar_followed_student);
        drawerLayoutFollowedStudent = (DrawerLayout) findViewById(R.id.drawerlayout_followed_student);
        navigationViewFollowedStudent = (NavigationView) findViewById(R.id.navigationview_followed_student);
        recyclerViewFollowedStudentClasses = (RecyclerView) findViewById(R.id.recyclerview_followed_class_student_classes);

        toolbarFollowedStudent.setTitle(R.string.text_followed_student_title_toolbar);
        setSupportActionBar(toolbarFollowedStudent);
        ActionBar actionBarFollowedStudent = getSupportActionBar();
        actionBarFollowedStudent.setDisplayHomeAsUpEnabled(true);
        actionBarFollowedStudent.setHomeAsUpIndicator(R.drawable.ic_round_menu);

        navigationViewFollowedStudent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_student_main:
                        Intent goToMain = new Intent(FollowedStudentActivity.this, MainStudentActivity.class);
                        startActivity(goToMain);
                        break;
                    case R.id.item_menu_student_class_saved:
                        drawerLayoutFollowedStudent.closeDrawers();
                        break;
                    case R.id.item_menu_student_setting:
                        Intent goToSetting = new Intent(FollowedStudentActivity.this, SettingStudentActivity.class);
                        startActivity(goToSetting);
                        break;
                    case R.id.item_menu_student_exit:
                        AniclassSharedPref.exit();
                        startActivity(new Intent(FollowedStudentActivity.this , LoginActivity.class));                        break;
                }
                return false;
            }
        });
    
        adapter = new FollowStudentAdapter(this , (v , item) -> {
            Bundle bundle = new Bundle();
            bundle.putString("title" , item.name);
            bundle.putString("code" , item.code);
            bundle.putString("teacherName" , "کد معلم : " + item.teacherId);
            bundle.putString("dpartment" , item.department);
            bundle.putString("link" , item.link);
            bundle.putString("desc" , item.desc);
    
            Intent intent = new Intent(FollowedStudentActivity.this , DetailClassActivity.class);
            intent.putExtra("detail" , bundle);
    
            startActivity(intent);
        } ,(v , item) -> {
            removeFollow(item.followId);
        });
        
        recyclerViewFollowedStudentClasses.setAdapter(adapter);
        recyclerViewFollowedStudentClasses.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
    }
    
    @Override
    protected void onResume() {
        fetchData();
        super.onResume();
    }
    
    private void removeFollow(long id) {
        compositeDisposable.add(Base.getDao().deleteFollow(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(list -> {
                Toast.makeText(this, "با موفقیت حذف شد", Toast.LENGTH_LONG).show();
                fetchData();
            }, error -> {
                Toast.makeText(this, "مشکل در دریافت اطلاعات", Toast.LENGTH_LONG).show();
            }));
    }
    
    private void fetchData() {
        compositeDisposable.add(Base.getDao().getCustomFollow(currentId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(list -> {
                adapter.bindData(list);
            }, error -> {
                Toast.makeText(this, "مشکل در دریافت اطلاعات", Toast.LENGTH_LONG).show();
            }));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayoutFollowedStudent.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        compositeDisposable = null;
        super.onDestroy();
    }
    

}