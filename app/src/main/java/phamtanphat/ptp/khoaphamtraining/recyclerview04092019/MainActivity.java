package phamtanphat.ptp.khoaphamtraining.recyclerview04092019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mMonAnRecycle;
    ArrayList<MonAn> mArrayMonan;
    MonAnAdapter mMonAnAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Tạo ra class mon an
        // 2 : Tao ra layout item mon an
        // 3 : Tạo ra adapter cho recycle
        // 4 : Gán layout cho recycle

        mMonAnRecycle = findViewById(R.id.recyclerviewMonan);
        mArrayMonan = new ArrayList<>();
        mArrayMonan.add(new MonAn("Bún chả","Đặc sản Hồ Chí Minh",35000,R.drawable.buncha));
        mArrayMonan.add(new MonAn("Gỏi cuốn","Ngon nhất Sài Gòn",10000,R.drawable.goicuon));
        mArrayMonan.add(new MonAn("Điểm tâm","Đầu bếp nhà hàng 5 sao chế biến",150000,R.drawable.khaivi));
        mArrayMonan.add(new MonAn("Tôm chiên","Tôm đặc sản miền Trung",200000,R.drawable.tomchien));
        mArrayMonan.add(new MonAn("Tôm hùm","Chế biến tại nhà hàng Châu Âu",600000,R.drawable.tomhum));


        mMonAnAdapter = new MonAnAdapter(mArrayMonan);


//        DividerItemDecoration
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mMonAnRecycle.setLayoutManager(linearLayoutManager);
        mMonAnRecycle.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        mMonAnRecycle.setAdapter(mMonAnAdapter);

    }
}
