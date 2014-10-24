package com.test.base;

import com.test.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class Title extends FrameLayout{
	
	private Context context;
	private LinearLayout backBtn;//�������ĺ��˰�ť
	private LinearLayout msgBtn;//��Ϣ��ť
	private FrameLayout searchLayout;//����ģ��
	private LinearLayout moreBtn;//����ģ��
	private SearchEditText searchTxt;
	
	public Title(Context context) {
        super(context,null);
    }
    
    public Title(final Context context,AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context=context;
        LayoutInflater.from(context).inflate(R.layout.title, this,true);
        backBtn=(LinearLayout) findViewById(R.id.backBtn);
        msgBtn=(LinearLayout) findViewById(R.id.msgBtn);
        searchLayout=(FrameLayout) findViewById(R.id.searchLayout);
        moreBtn=(LinearLayout) findViewById(R.id.moreBtn);
      
        backBtn.setOnClickListener(new OnclickListener());
        msgBtn.setOnClickListener(new OnclickListener());
        moreBtn.setOnClickListener(new OnclickListener());
        searchTxt=(SearchEditText) findViewById(R.id.searchTxt);
        searchTxt.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if(actionId ==EditorInfo.IME_ACTION_SEARCH){ 
					// �����ؼ���
					((InputMethodManager) searchTxt.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
					.hideSoftInputFromWindow(
					((Activity)context)
					.getCurrentFocus()
					.getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
				
			}
				Toast.makeText(context, "����˻س���", 2000).show();
				Toast.makeText(context, v.getText().toString(), 2000).show();
				return true;
			}
			
        	});
    }
    
    public class OnclickListener implements View.OnClickListener
    {

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.backBtn:
				((Activity)context).finish();
				break;
			case R.id.msgBtn:
				//��ת����Ϣ��
				break;
			case R.id.moreBtn:
				//���ఴť�ĵ�����
				break;
			default:
				break;
			}
			
		}
    }
    
    /**
     * ���ñ�����ģʽ
     * 1. ��Ϣ��ť+������+���ఴť
     * @param module
     */
    public void setModule(int module)
    {
    	switch (module) {
		case 1:
			msgBtn.setVisibility(View.VISIBLE);
			searchLayout.setVisibility(View.VISIBLE);
			moreBtn.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
    }
    
}