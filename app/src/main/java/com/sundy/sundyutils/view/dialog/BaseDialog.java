package com.sundy.sundyutils.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

import com.sundy.sundyutils.R;


/**
 * 自定义Dialog基类
 */
public class BaseDialog extends Dialog {

	private String title,message;//标题和消息

	private Context context;

	private View view;

	private TextView vTitle,vMessage;

	private Button vAccept,vCanncel;

	private boolean enabledKeyEvent;
	// 确定取消
	private String confirm, cancel;

	private OnBackClickListener onBackClickListener;

	/**
	 * BaseDialog
	 * 
	 * @param context
	 *            tag
	 */
	public BaseDialog(Context context) {
		super(context, R.style.MyDialog);
		this.context = context;
		setEnabledKeyEvent(true);
		setCancelable(false);
		setCanceledOnTouchOutside(false);
	}

	/**
	 * setLayout
	 * 
	 * @param id
	 *            tag
	 */
	public void setLayout(int id) {
		LayoutInflater inflater = LayoutInflater.from(context);
		view = inflater.inflate(id, null);
	}
	// 屏蔽home功能
	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
	}

	/**
	 * show
	 */
	@Override
	public void show() {
		try {
			if (view == null) {
				setDefalutLayout();
			}
			setContentView(view);
			Window window = this.getWindow();
			WindowManager.LayoutParams windowWM = window.getAttributes();
			window.setAttributes(windowWM);
			window.setLayout(
					(int) context.getResources().getDimension(
							R.dimen.dialog_width), LayoutParams.WRAP_CONTENT);
			window.setGravity(Gravity.CENTER);
			findView();
			super.show();
		} catch (Exception e) {
		}

	}

	/**
	 * showLog
	 *
	 * @param v
	 *            tag
	 */
	public void showLog(View v) {
		setContentView(v);
		Window window = this.getWindow();
		WindowManager.LayoutParams windowWM = window.getAttributes();
		window.setAttributes(windowWM);
		window.setLayout(
				(int) context.getResources().getDimension(R.dimen.dialog_width),
				LayoutParams.WRAP_CONTENT);
		window.setGravity(Gravity.CENTER);
		super.show();
	}

	private void setDefalutLayout() {
		LayoutInflater inflater = LayoutInflater.from(context);
		view = inflater.inflate(R.layout.base_dialog, null);
	}


	private void findView() {
		vTitle = (TextView) view.findViewById(R.id.title);
		vMessage = (TextView) view.findViewById(R.id.message);
		vMessage.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		vAccept = (Button) view.findViewById(R.id.confirmButton);
		vCanncel = (Button) view.findViewById(R.id.cancelButton);

		if (confirm != null && !confirm.equals("")) {
			vAccept.setText(confirm);
			vAccept.requestFocus();
			vAccept.requestFocusFromTouch();
		}

		if (cancel != null && !cancel.equals("")) {
			vCanncel.setText(cancel);
			vCanncel.requestFocusFromTouch();
		}
		setText();
		vAccept.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
				if (onBackClickListener != null) {
					onBackClickListener.onBackClickListener(true);
				}
				
			}
		});

		vCanncel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
				if (onBackClickListener != null) {
					onBackClickListener.onBackClickListener(false);
				}
				
			}
		});
	}

	private void setText() {
		vTitle.setText(title);
		if (title == null || title.trim().equals("")) {
			vTitle.setVisibility(View.GONE);
		}
		if (message == null || message.trim().equals("")) {
			vMessage.setVisibility(View.GONE);
		} else {
			vMessage.setVisibility(View.VISIBLE);
			vMessage.setText(message);
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		dismiss();
	}

	public TextView getvTitle() {
		return vTitle;
	}

	public TextView getvMessage() {
		return vMessage;
	}
	
	public void setTitles(String titleTag) {
		this.title = titleTag;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
		this.onBackClickListener = onBackClickListener;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public Button getvAccept() {
		return vAccept;
	}

	public void setvAccept(Button vAccept) {
		this.vAccept = vAccept;
	}

	public Button getvCanncel() {
		return vCanncel;
	}

	public void setvCanncel(Button vCanncel) {
		this.vCanncel = vCanncel;
	}

	public void setEnabledKeyEvent(boolean enabledKeyEvent) {
		this.enabledKeyEvent = enabledKeyEvent;
	}

	/**
	 * dismiss
	 */
	@Override
	public void dismiss() {
		super.dismiss();

	}

}
