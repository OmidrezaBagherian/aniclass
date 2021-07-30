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
import ir.omidrezabagherian.aniclass.model.QueryFollowClasses;

public class FollowStudentAdapter extends RecyclerView.Adapter<FollowStudentAdapter.FollowStudentViewHolder> {
    private ClassItemClick infoItemClick;
    private ClassItemClick unfollowItemClick;
    private List<QueryFollowClasses> classItemEntityEntities = new ArrayList<>();
    private Activity mActivity;
    
    public FollowStudentAdapter(Activity activity, ClassItemClick infoItemClick , ClassItemClick unfollowItemClick) {
        mActivity = activity;
        this.infoItemClick = infoItemClick;
        this.unfollowItemClick = unfollowItemClick;
    }
    
    public void bindData(List<QueryFollowClasses> classItemEntityEntities) {
        this.classItemEntityEntities.clear();
        this.classItemEntityEntities.addAll(classItemEntityEntities);
        notifyDataSetChanged();
    }
    
    @NonNull
    @NotNull
    @Override
    public FollowStudentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new FollowStudentViewHolder(
            LayoutInflater.from(mActivity).inflate(
                R.layout.cardlist_followed_classes_student ,
                      parent,
                false)
        );
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull FollowStudentViewHolder holder, int position) {
        QueryFollowClasses item = classItemEntityEntities.get(position);
        
        holder.textview_cardlist_main_student_title.setText(item.name);
        holder.textview_cardlist_main_student_department.setText(item.department);
        holder.textview_cardlist_main_student_teacher_name.setText("کد معلم : " + item.teacherId);
        holder.textview_cardlist_main_student_university.setText(item.university);
        holder.button_cardlist_followed_classes_student_delete_lesson.setOnClickListener(v -> {
            unfollowItemClick.onClickListener(v , item);
        });
        holder.button_cardlist_main_student_goto_details_page.setOnClickListener(v -> {
            infoItemClick.onClickListener(v , item);
        });
        
    }
    
    @Override
    public int getItemCount() {
        return classItemEntityEntities.size();
    }
    
    
    public interface ClassItemClick {
        void onClickListener(View v , QueryFollowClasses queryAllClasses);
    }
    
    public class FollowStudentViewHolder extends RecyclerView.ViewHolder {
        TextView textview_cardlist_main_student_title;
        TextView textview_cardlist_main_student_department;
        TextView textview_cardlist_main_student_teacher_name;
        TextView textview_cardlist_main_student_university;
        Button   button_cardlist_main_student_goto_details_page;
        Button   button_cardlist_followed_classes_student_delete_lesson;
        
        public FollowStudentViewHolder(View view) {
            super(view);
            setViews(view);
        }
        
        private void setViews(View view) {
            textview_cardlist_main_student_title = view.findViewById(R.id.textview_cardlist_followed_classes_student_title);
            textview_cardlist_main_student_department = view.findViewById(R.id.textview_cardlist_followed_classes_student_department);
            textview_cardlist_main_student_teacher_name = view.findViewById(R.id.textview_cardlist_followed_classes_student_teacher_name);
            textview_cardlist_main_student_university = view.findViewById(R.id.textview_cardlist_followed_classes_student_university);
            button_cardlist_main_student_goto_details_page = view.findViewById(R.id.button_cardlist_followed_classes_student_goto_details_page);
            button_cardlist_followed_classes_student_delete_lesson = view.findViewById(R.id.button_cardlist_followed_classes_student_delete_lesson);
        }
        
    }
}
