package com.websarva.wings.android.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    private var _menuList:MutableList<MutableMap<String,Any>> = mutableListOf()
    private val _from = arrayOf("name","price")
    private val _to = intArrayOf(R.id.tvMenuNameRow,R.id.tvMenuPriceRow)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _menuList = createTeishokuList()
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val adapter = SimpleAdapter(this@MainActivity,_menuList,R.layout.row,_from,_to)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, view: View, position:Int, id:Long){
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
            val menuName = item["name"] as String
            val menuPrice = item["price"] as Int
            val intent2MenuThanks = Intent(this@MainActivity,MenuThanksActivity::class.java)
            intent2MenuThanks.putExtra("menuName",menuName)
            intent2MenuThanks.putExtra("menuPrice","${menuPrice}円")
            startActivity(intent2MenuThanks)
        }
    }


    private fun createTeishokuList():MutableList<MutableMap<String,Any>>{
        val menuList:MutableList<MutableMap<String,Any>> = mutableListOf()
        var menu = mutableMapOf<String,Any>("name" to "から揚げ定食","price" to 800,"desc" to "若鶏のから揚げにサラダ、ご飯と味噌汁がつきます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        // 以下データ登録の繰り返し。
        menu = mutableMapOf("name" to "生姜焼き定食", "price" to 850, "desc" to "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to 1000, "desc" to "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to 750, "desc" to "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to 900, "desc" to "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ミンチかつ定食", "price" to 850, "desc" to "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チキンカツ定食", "price" to 900, "desc" to "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食", "price" to 850, "desc" to "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "回鍋肉定食", "price" to 750, "desc" to "ピリ辛回鍋肉にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "麻婆豆腐定食", "price" to 800, "desc" to "本格四川風麻婆豆腐にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "青椒肉絲定食", "price" to 900, "desc" to "ピーマンの香り豊かな青椒肉絲にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to 850, "desc" to "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼肉定食", "price" to 950, "desc" to "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        return menuList
    }
}