package dcf.matcom.simplerv;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dfinlay-air on 26/09/15.
 */
public class RecyclerViewActivity extends Activity {
    //
    private RecyclerView rv=null;
    //
    public void setAdapter(RecyclerView.Adapter adapter) {
        getRecyclerView().setAdapter(adapter);
    }
    public RecyclerView.Adapter getAdapter() {
        return(getRecyclerView().getAdapter());
    }
    public void setLayoutManager(RecyclerView.LayoutManager mgr) {
        getRecyclerView().setLayoutManager(mgr);
    }
    public RecyclerView getRecyclerView() {
        if (rv==null) {
            rv=new RecyclerView(this);
            rv.setHasFixedSize(true);
            setContentView(rv);
        }
        return(rv);
    }
}
