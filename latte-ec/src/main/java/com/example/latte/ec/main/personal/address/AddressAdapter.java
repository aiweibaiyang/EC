package com.example.latte.ec.main.personal.address;

import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.latte.ec.R;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.ui.recycler.MultipleFields;
import com.example.latte.ui.recycler.MultipleItemEntity;
import com.example.latte.ui.recycler.MultipleRecyclerAdapter;
import com.example.latte.ui.recycler.MultipleViewHolder;

import java.util.List;

public class AddressAdapter extends MultipleRecyclerAdapter {

    protected AddressAdapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(AddressItemType.ITEM_ADDRESS, R.layout.item_address);
    }

    @Override
    protected void convert(final MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case AddressItemType.ITEM_ADDRESS:
                final String name = entity.getFiled(MultipleFields.NAME);
                final String phone = entity.getFiled(AddressItemFields.PHONE);
                final String address = entity.getFiled(AddressItemFields.ADDRESS);
                final boolean isDefault = entity.getFiled(MultipleFields.TAG);
                final int id = entity.getFiled(MultipleFields.ID);

                final AppCompatTextView nameText = holder.getView(R.id.tv_address_name);
                final AppCompatTextView phoneText = holder.getView(R.id.tv_address_phone);
                final AppCompatTextView addressText = holder.getView(R.id.tv_address_address);
                final AppCompatTextView deleteTextView = holder.getView(R.id.tv_address_delete);
                deleteTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RestClient.builder()
                                .url("address.php")
                                .params("id", id)
                                .success(new ISuccess() {
                                    @Override
                                    public void onSuccess(String response) {
                                        remove(holder.getLayoutPosition());
                                    }
                                })
                                .build()
                                .post();
                    }
                });

                nameText.setText(name);
                phoneText.setText(phone);
                addressText.setText(address);
                break;
            default:
                break;
        }
    }
}
