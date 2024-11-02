package com.example.mainactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.Adapter.adapterWisata
import com.example.mainactivity.model.ModelWisata

class ListWisata : AppCompatActivity() {
    private lateinit var RecyclerViewMenu: RecyclerView
    private lateinit var AdapterMenu: adapterWisata

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        val menuIcons = listOf(
            ModelWisata(
                R.drawable.mekah34,
                "Mekkah,",
                "Saudi Arabia",
                "Makkah[1][a], secara resmi bernama Makkah al-Mukarramah (bahasa Arab: مكة المكرمة, translit. Makkat al-Mukarramah, har. 'Makkah, Kota yang Mulia'), (Ejaan tidak baku: 'Mekah' atau 'Mekkah') Mekkah adalah arah tempat semua kiblat bagi para umat muslim",
                21.435053634475608, 39.72425580224436
            ),
            ModelWisata(
                R.drawable.pisa,
                "Menara Pisa",
                "Italia",
                "Menara Miring Pisa (Bahasa Italia: Torre pendente di Pisa atau disingkat Torre di Pisa), atau lebih dikenal dengan Menara Pisa, adalah sebuah campanile atau menara lonceng gereja katedral di kota Pisa, Italia.",
                43.723099289814854, 10.396607725528167
            ),
            ModelWisata(
                R.drawable.paris,
                "Menara Eiffle",
                "France",
                "Menara Eiffel dulu bernama Menara Paris (bahasa Prancis: Tour Eiffel, /tuʀ ɛfɛl/) merupakan sebuah menara besi yang dibangun di Champ de Mars di tepi Sungai Seine, Paris. Menara ini telah menjadi ikon utama negara Prancis",
                48.858405365041364, 2.2954576209878845
            ),
            ModelWisata(
                R.drawable.rinjani,
                "Gunung Rinjani",
                "Indonesia",
                "Keindahan Gunung Rinjani sempat terbingkai dalam mata uang pecahan Rp 10.000 yang dikeluarkan Bank Indonesia pada 1998. Potret Gunung Rinjani yang muncul di permukaan danau kawah dikelilingi oleh tebing setinggi ratusan meter",
                -8.410700563292512, 116.45739164907803
            ),
            ModelWisata(
                R.drawable.danautobaaa,
                "Danau Toba",
                "Sumatera Utara",
                "Danau Toba adalah danau alami berukuran besar di Sumatera Utara, Indonesia yang terletak di kaldera gunung supervulkan. Danau ini memiliki panjang 100 kilometer, lebar 30 kilometer, dan kedalaman 508 meter. Danau ini terletak di tengah pulau Sumatra bagian utara dengan ketinggian permukaan sekitar 900 mete",
                2.797166, 98.636363


            )

        )

        RecyclerViewMenu = findViewById(R.id.rvwisata)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        AdapterMenu = adapterWisata(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}