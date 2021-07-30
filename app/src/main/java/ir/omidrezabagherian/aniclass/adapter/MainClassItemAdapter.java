package ir.omidrezabagherian.aniclass.adapter;
/*

@created in 26/07/2021 - 3:26 PM
@project AniClass
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.omidrezabagherian.aniclass.R;
import ir.omidrezabagherian.aniclass.model.QueryAllClasses;

public class MainClassItemAdapter extends RecyclerView.Adapter<MainClassItemAdapter.MainClassItemAdapterHolder> {
    private ClassItemClick classItemClick;
    private List<QueryAllClasses> classItemEntityEntities = new ArrayList<>();
    private Activity mActivity;
    
    public MainClassItemAdapter(Activity activity, ClassItemClick classItemClick) {
        mActivity = activity;
        this.classItemClick = classItemClick;
    }
    
    public void bindData(List<QueryAllClasses> classItemEntityEntities) {
        this.classItemEntityEntities.clear();
        this.classItemEntityEntities.addAll(classItemEntityEntities);
        notifyDataSetChanged();
    }
    
    @NonNull
    @NotNull
    @Override
    public MainClassItemAdapterHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MainClassItemAdapterHolder(
            LayoutInflater.from(mActivity).inflate(
                R.layout.cardlist_main_student ,
                      parent,
                false)
        );
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull MainClassItemAdapterHolder holder, int position) {
        QueryAllClasses item = classItemEntityEntities.get(position);
        
        holder.textview_cardlist_main_student_title.setText(item.name);
        holder.textview_cardlist_main_student_department.setText(item.department);
        holder.textview_cardlist_main_student_teacher_name.setText(item.teacher_name);
        holder.textview_cardlist_main_student_university.setText(item.university);
        holder.button_cardlist_main_student_goto_details_page.setOnClickListener(v -> {
            classItemClick.onClickListener(v , item);
        });
        
    }
    
    @Override
    public int getItemCount() {
        return classItemEntityEntities.size();
    }
    
    
    public interface ClassItemClick {
        void onClickListener(View v , QueryAllClasses queryAllClasses);
    }
    
    public class MainClassItemAdapterHolder extends RecyclerView.ViewHolder {
        TextView textview_cardlist_main_student_title;
        TextView textview_cardlist_main_student_department;
        TextView textview_cardlist_main_student_teacher_name;
        TextView textview_cardlist_main_student_university;
        Button   button_cardlist_main_student_goto_details_page;
        
        public MainClassItemAdapterHolder(View view) {
            super(view);
            setViews(view);
        }
        
        private void setViews(View view) {
            textview_cardlist_main_student_title = view.findViewById(R.id.textview_cardlist_main_student_title);
            textview_cardlist_main_student_department = view.findViewById(R.id.textview_cardlist_main_student_department);
            textview_cardlist_main_student_teacher_name = view.findViewById(R.id.textview_cardlist_main_student_teacher_name);
            textview_cardlist_main_student_university = view.findViewById(R.id.textview_cardlist_main_student_university);
            button_cardlist_main_student_goto_details_page = view.findViewById(R.id.button_cardlist_main_student_goto_details_page);
        }
        
    }
}
