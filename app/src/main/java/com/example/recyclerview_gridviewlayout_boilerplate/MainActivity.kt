package com.example.recyclerview_gridviewlayout_boilerplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_gridviewlayout_boilerplate.adapter.Adapter
import com.example.recyclerview_gridviewlayout_boilerplate.model.DataList

class MainActivity : AppCompatActivity() {

    private var recyclerView:RecyclerView ? = null
    private var gridLayoutManager:GridLayoutManager ? = null
    private var arrayList: ArrayList<DataList> ? = null
    private var adapter:Adapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext,3,GridLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager =gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataList()
        adapter = Adapter(applicationContext,arrayList!!)
        recyclerView?.adapter = adapter
    }

    private fun setDataList(): ArrayList<DataList> {
        var items:ArrayList<DataList> = ArrayList()
        for (i in 1..30) {
            items.add(DataList(R.drawable.icon, "User" + i))
        }
        return items
    }

}