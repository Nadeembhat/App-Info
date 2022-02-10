package com.ernb.packageinfo

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       rv_items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getPackageInfo()
    }


    private fun getPackageInfo(){
        val apps = packageManager.getInstalledPackages(0)
        Log.e("MainActivity","Package Infor\t ${apps[0].packageName}")

        val dateList:ArrayList<Date> = arrayListOf()
        val packageList:ArrayList<String> = arrayListOf()

        apps.forEach {
            Log.e("MainActivity","Package Infor\t ${it.packageName}")
            val pm: PackageManager = getPackageManager()
            val appInfo = pm.getApplicationInfo(it.packageName.toString(), 0)
            val appFile = appInfo.sourceDir
            val installed: Long = File(appFile).lastModified()
            val d = Date(installed * 1000)
            dateList.add(d)
            packageList.add(it.packageName)
            Log.e("MainActivity","Installed\t $installed")
            Log.e("MainActivity","Installed Date \t $d")
        }
            // rv_items.adapter = AdapterAppInfo(dateList,packageList)
    }
}