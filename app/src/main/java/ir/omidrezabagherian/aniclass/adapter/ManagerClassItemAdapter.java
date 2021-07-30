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

public class ManagerClassItemAdapter extends RecyclerView.Adapter<ManagerClassItemAdapter.ManagerClassItemAdapterHolder> {
    private ClassItemClick infoItemClick;
    private ClassItemClick deleteItemClick;
    private List<QueryAllClasses> classItemEntityEntities = new ArrayList<>();
    private Activity mActivity;
    
    public ManagerClassItemAdapter(Activity activity, ClassItemClick infoItemClick , ClassItemClick deleteItemClick) {
        mActivity = activity;
        this.infoItemClick = infoItemClick;
        this.deleteItemClick = deleteItemClick;
    }
    
    public void bindData(List<QueryAllClasses> classItemEntityEntities) {
        this.classItemEntityEntities.clear();
        this.classItemEntityEntities.addAll(classItemEntityEntities);
        notifyDataSetChanged();
    }
    
    @NonNull
    @NotNull
    @Override
    public ManagerClassItemAdapterHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ManagerClassItemAdapterHolder(
            LayoutInflater.from(mActivity).inflate(
                R.layout.cardlist_class_management_teacher,
                parent,
                false)
        );
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull ManagerClassItemAdapterHolder holder, int position) {
        QueryAllClasses item = classItemEntityEntities.get(position);
        
        holder.textview_cardlist_management_teacher_title.setText(item.name);
        holder.textview_cardlist_management_teacher_department.setText(item.department);
        holder.textview_cardlist_management_teacher_teacher_name.setText(item.teacher_name);
        holder.textview_cardlist_management_teacher_university.setText(item.university);
        holder.button_cardlist_management_teacher_delete_lesson.setOnClickListener(v -> {
            deleteItemClick.onClickListener(v , item);
        });
        holder.button_cardlist_management_teacher_goto_details_page.setOnClickListener(v -> {
            infoItemClick.onClickListener(v , item);
        });
    }
    
    @Override
    public int getItemCount() {
        return classItemEntityEntities.size();
    }
    
    
    public interface ClassItemClick {
        void onClickListener(View v , QueryAllClasses queryAllClasses);
    }
    
    public static class ManagerClassItemAdapterHolder extends RecyclerView.ViewHolder {
        TextView textview_cardlist_management_teacher_title;
        TextView textview_cardlist_management_teacher_department;
        TextView textview_cardlist_management_teacher_teacher_name;
        TextView textview_cardlist_management_teacher_university;
        Button   button_cardlist_management_teacher_delete_lesson;
        Button   button_cardlist_management_teacher_goto_details_page;
        
        public ManagerClassItemAdapterHolder(View view) {
            super(view);
            setViews(view);
        }
        
        private void setViews(View view) {
            textview_cardlist_management_teacher_title = view.findViewById(R.id.textview_cardlist_management_teacher_title);
            textview_cardlist_management_teacher_department = view.findViewById(R.id.textview_cardlist_management_teacher_department);
            textview_cardlist_management_teacher_teacher_name = view.findViewById(R.id.textview_cardlist_management_teacher_teacher_name);
            textview_cardlist_management_teacher_university = view.findViewById(R.id.textview_cardlist_management_teacher_university);
            button_cardlist_management_teacher_delete_lesson = view.findViewById(R.id.button_cardlist_management_teacher_delete_lesson);
            button_cardlist_management_teacher_goto_details_page = view.findViewById(R.id.button_cardlist_management_teacher_goto_details_page);
        }
        
    }
}
