package com.gengmei.animdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gengmei.animdemo.databinding.ActivityHorizontalListBinding
import com.gengmei.animdemo.databinding.ActivityMainBinding
import java.util.*

class HorizontalListActivity : AppCompatActivity() {
    private lateinit var list: MutableList<String?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //        rv_content.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL));
        binding.rvContent.layoutManager = LinearLayoutManager(this)
        list = arrayListOf()
        for (i in 0..14) {
            if (i % 3 == 0) {
                list.add("当前item$i")
            } else if (i % 3 == 1) {
                list.add("当前$i")
            } else {
                list.add("feed流卡片完善：$i")
            }
        }
        binding.rvContent.adapter = MyAdapter(this, list)
    }
}