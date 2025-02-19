package cn.wildfire.chat.kit.group;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.wildfire.chat.kit.GlideApp;
import com.weilaizhihui.xchat.R;
import cn.wildfirechat.model.GroupInfo;

public class GroupViewHolder extends RecyclerView.ViewHolder {
    protected Fragment fragment;
    private GroupListAdapter adapter;
    @BindView(R.id.portraitImageView)
    ImageView portraitImageView;
    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.categoryTextView)
    TextView categoryTextView;
    @BindView(R.id.dividerLine)
    View dividerLine;

    protected GroupInfo groupInfo;

    public GroupViewHolder(Fragment fragment, GroupListAdapter adapter, View itemView) {
        super(itemView);
        this.fragment = fragment;
        this.adapter = adapter;
        ButterKnife.bind(this, itemView);
    }

    // TODO hide the last diver line
    public void onBind(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
        categoryTextView.setVisibility(View.GONE);
        nameTextView.setText(this.groupInfo.name);
        GlideApp.with(fragment).load(this.groupInfo.portrait).error(R.mipmap.ic_group_cheat).into(portraitImageView);
    }

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }
}
