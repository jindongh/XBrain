package net.hankjin.android.xbrain;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class TabBirthdayFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.fragment_birthday, container, true);
		WebView webView = (WebView) result.findViewById(R.id.webView01);
		String url = "http://www.baidu.com";
		webView.loadUrl(url);
		return result;
	}
}
