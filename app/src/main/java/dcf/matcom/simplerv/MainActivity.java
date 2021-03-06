package dcf.matcom.simplerv;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends RecyclerViewActivity {
    private static final String[] items = {"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        setLayoutManager(new LinearLayoutManager(this));
        // Add decoration
        Drawable divider=getResources().getDrawable(R.drawable.item_divider);
        getRecyclerView().addItemDecoration(new
                HorizontalDividerItemDecoration(divider));
        //
        setAdapter(new RecViewAdapter());
    }

    class RecViewAdapter extends RecyclerView.Adapter<RecViewRowHolder> {
        @Override
        public RecViewRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return (new RecViewRowHolder(getLayoutInflater()
                    .inflate(R.layout.row, parent, false)));
        }


        @Override
        public void onBindViewHolder(RecViewRowHolder holder, int position) {
            holder.bindModel(items[position]);
        }

        @Override
        public int getItemCount() {
            return (items.length);
        }
    }

    static class RecViewRowHolder extends RecyclerView.ViewHolder {
        TextView label = null;
        TextView size = null;
        ImageView icon = null;
        String template = null;

        RecViewRowHolder(View row) {
            super(row);

            label = (TextView) row.findViewById(R.id.label);
            size = (TextView) row.findViewById(R.id.size);
            icon = (ImageView) row.findViewById(R.id.icon);

            template = size.getContext().getString(R.string.size_template);
        }

        void bindModel(String item) {
            label.setText(item);
            size.setText(String.format(template, item.length()));

            if (item.length() > 4) {
                icon.setImageResource(R.drawable.delete);
            } else {
                icon.setImageResource(R.drawable.ok);
            }
        }


    }
}
