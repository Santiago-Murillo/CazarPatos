package com.murillo.santiago.cazarpatos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ranking)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        var jugadores = arrayListOf<Player>()
        jugadores.add(Player("Santiago.Murillo",10))
        jugadores.add(Player("Jugador2",6))
        jugadores.add(Player("Jugador3",3))
        jugadores.add(Player("Jugador4",9))
        jugadores.add(Player("Ana.Perez", 8))
        jugadores.add(Player("Carlos.Lopez", 12))
        jugadores.add(Player("Maria.Gomez", 5))
        jugadores.add(Player("Luis.Ramirez", 7))
        jugadores.add(Player("Elena.Torres", 11))
        jugadores.add(Player("Pedro.Sanchez", 4))
        jugadores.add(Player("Lucia.Fernandez", 9))
        jugadores.add(Player("Miguel.Diaz", 6))
        jugadores.add(Player("Valeria.Martinez", 13))
        jugadores.add(Player("Javier.Ruiz", 2))
        jugadores.add(Player("Sofia.Herrera", 10))
        jugadores.add(Player("Andres.Morales", 7))
        jugadores.add(Player("Paula.Castro", 8))
        jugadores.add(Player("Diego.Vega", 5))
        jugadores.add(Player("Camila.Silva", 12))
        jugadores.add(Player("Fernando.Ortiz", 6))
        jugadores.add(Player("Gabriela.Mendez", 9))
        jugadores.add(Player("Ricardo.Perez", 4))
        jugadores.sortByDescending { it.huntedDucks }

        val recyclerViewRanking: RecyclerView = findViewById(R.id.recyclerViewRanking);
        recyclerViewRanking.layoutManager = LinearLayoutManager(this);
        recyclerViewRanking.adapter = RankingAdapter(jugadores);
        recyclerViewRanking.setHasFixedSize(true);

    }
}