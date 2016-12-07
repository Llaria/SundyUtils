package com.sundy.sundyutils.adapter;

import android.content.Context;

import com.sundy.sundyutils.TestData.adapterData.SingleChoiceAdapterEntity;
import com.sundy.sundyutils.adapter.baseAdapter.AbsCommonAdapter;
import com.sundy.sundyutils.adapter.baseAdapter.ViewHolder;

import java.util.List;

/**
 * 可以单选的listView适配器
 * Created by sundi on 2016/10/12.
 */
public class SingleChoiceAdapter extends AbsCommonAdapter<SingleChoiceAdapterEntity>{


    public SingleChoiceAdapter(Context context, List<SingleChoiceAdapterEntity> datas, int itemLayoutId) {
        super(context, datas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder holder, SingleChoiceAdapterEntity data, int position) {

    }
}
