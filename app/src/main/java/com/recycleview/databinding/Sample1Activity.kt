package com.recycleview.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recycleview.databinding.databinding.ActivitySample1Binding
import com.recycleview.databinding.model.Fruit
import java.util.*

class Sample1Activity : AppCompatActivity() {
    var fruit:Fruit = Fruit("水果",R.drawable.n1);
    val arrName:Array<String> = arrayOf("水果1","水果2","水果3","水果4","水果5","水果6")
    val arrImg:Array<Int> = arrayOf(R.drawable.n1,R.drawable.n2,R.drawable.n3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =
            DataBindingUtil.setContentView<ActivitySample1Binding>(this, R.layout.activity_sample1)
        binding.fruit = fruit
        initList(binding.rv)
    }

    private fun initList(rv: RecyclerView) {
        val layoutManager = LinearLayoutManager(this);
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = FruitRvAdapter(getData(),this);
        rv.layoutManager = layoutManager;
        rv.adapter = adapter
    }

    private fun getData(): MutableList<Fruit>? {
        val list = arrayListOf<Fruit>()

        for (i in 0 .. 20){
            val nameIndex = Random().nextInt(arrName.size)
            val imgIndex = Random().nextInt(arrImg.size)
            list.add(Fruit(arrName[nameIndex],arrImg[imgIndex]));
        }

        return list;
    }

    fun test(view: View) {


        val nameIndex = Random().nextInt(arrName.size)
        val imgIndex = Random().nextInt(arrImg.size)
        fruit.name = arrName[nameIndex]
        fruit.imageId = arrImg[imgIndex]
    }
}