package com.example.latte.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ui.R;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.List;

public class AutoPhotoLayout extends LinearLayoutCompat {

    private int mCurrentNum = 0;
    private int mMaxNum = 0;
    private int mMaxLineNum = 0;
    private IconTextView mIconAdd = null;
    private LayoutParams mParams = null;
    //要删除的图片Id
    private int mDeleteId = 0;
    private AppCompatImageView mTargetImageView = null;
    private int mImageMargin = 0;
    private LatteDelegate mDelegate = null;
    private List<View> mLineViews = null;
    private AlertDialog mTargetDialog = null;
    private static final String ICON_TEXT = "{fa-plus}";
    private float mIconSize = 0;

    private static final List<List<View>> ALL_VIEWS = new ArrayList<>();
    private static final List<Integer> LINE_HEIGHTS = new ArrayList<>();

    public AutoPhotoLayout(Context context) {
        super(context,null);
    }

    public AutoPhotoLayout(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public AutoPhotoLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.camera_flow_layout);
        mMaxNum = typedArray.getInt(R.styleable.camera_flow_layout_max_count,1);
        mMaxLineNum = typedArray.getInt(R.styleable.camera_flow_layout_line_count,3);
        mImageMargin = typedArray.getInt(R.styleable.camera_flow_layout_item_margin,0);
        mIconSize = typedArray.getInt(R.styleable.camera_flow_layout_icon_size,20);
        typedArray.recycle();
    }
}
