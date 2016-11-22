package dsd.informme.com.helpblox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import java.util.ArrayList;


/**
 * Created by kaizer on 11/21/16.
 */
public class CategoryAdapter extends BaseAdapter{

    ArrayList<String> nameOfCategory;
    Context context;

    public CategoryAdapter(Context context, ArrayList<String> nameOfCategory){

        this.context = context;
        this.nameOfCategory = nameOfCategory;

    }

    @Override
    public int getCount() {
        return nameOfCategory.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.activity_category_grid, null);
            CheckBox checkBox = (CheckBox) grid.findViewById(R.id.checkbox_id);
            checkBox.setText(nameOfCategory.get(position));
        } else {
            grid = convertView;
        }

        return grid;
    }
}
