package net.hankjin.android.xbrain;

import net.hankjin.android.xbrain.db.DBHelper;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class TabBookFragment extends Fragment {
	public final int DELETE_ID = 0;
	
	private DBHelper db = null;
	public TabBookFragment(){
		db = DBHelper.getDB();		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.fragment_book, container, true);
		ListView list = (ListView)result.findViewById(R.id.list_book);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
           "Linux", "OS/2" };
		ArrayAdapter<String> files = new ArrayAdapter<String>(getActivity(), 
                android.R.layout.simple_list_item_1, 
                values);
		/*
		Cursor cursor = db.getReadableDatabase().query("book", new String[]{"id", "name"}, null, null, null, null,"id");
		ListAdapter res = new SimpleCursorAdapter(getActivity(),
                R.layout.book_listitem,
                cursor,
                new String[]{"Name","Weight"},//游标数据的名称，实际是Table列名字
                new int[]{R.id.ItemTitle, R.id.ItemText});//对应的UI微件的id
		*/
        list.setAdapter(files);
        
		return result;
	}
	public void clickAddBook(View v){
		
	}
	public void onCreateContextMenu(ContextMenu menu, View v,  ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE,DELETE_ID,Menu.NONE,"Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
	 public boolean onContextItemSelected(MenuItem item) {
	        switch(item.getItemId()){
	        case DELETE_ID:
	            /* 在此处，我们关键引入 AdapterView.AdapterContextMenuInfo来获取单元的信息。在有三个重要的信息。 1、id：The row id of the item for which the context menu is being displayed ，在cursorAdaptor中，实际就是表格的_id序号； 2、position 是list的元素的顺序；3、view就可以获得list中点击元素的View，通过view可以获取里面的显示的信息   */
	            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	            delete(info.id, info.toString());
	            return true;
	        default:
	            break;
	        }
	        return super.onContextItemSelected(item);
	    }
	 private void delete(final long  rowId, String name){
	        if(rowId>0){
	            new AlertDialog.Builder(getActivity())
	            .setTitle("删除" + name)
	            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                      deleteData(rowId);
	                }
	            })
	            .setNegativeButton("取消", null)
	            .show();
	        }
	    }
	 private void deleteData(long rowId){
	        String[] str = {String.valueOf(rowId)};
	        db.getWritableDatabase().delete("book","_id=?",str);
	    }
}