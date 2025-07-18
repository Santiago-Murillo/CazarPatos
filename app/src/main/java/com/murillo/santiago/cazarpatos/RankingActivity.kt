package com.murillo.santiago.cazarpatos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.murillo.santiago.cazarpatos.database.RankingPlayerDBHelper

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

        // Quemadito
//        var jugadores = arrayListOf<Player>()
//        jugadores.add(Player("Santiago.Murillo",10))
//        jugadores.add(Player("Ana.Perez", 8))
//        jugadores.add(Player("Carlos.Lopez", 12))
//        jugadores.add(Player("Maria.Gomez", 5))
//        jugadores.add(Player("Luis.Ramirez", 7))
//        jugadores.sortByDescending { it.huntedDucks }
//
//        val recyclerViewRanking: RecyclerView = findViewById(R.id.recyclerViewRanking);
//        recyclerViewRanking.layoutManager = LinearLayoutManager(this);
//        recyclerViewRanking.adapter = RankingAdapter(jugadores);
//        recyclerViewRanking.setHasFixedSize(true);

        OperacionesSqLite()
        GrabarRankingSQLite()
        LeerRankingsSQLite()
    }

    fun OperacionesSqLite(){
        RankingPlayerDBHelper(this).deleteAllRanking()
        RankingPlayerDBHelper(this).insertRankingByQuery(Player("Jugador9",10))
        val patosCazados = RankingPlayerDBHelper(this).readDucksHuntedByPlayer("Jugador9")
        RankingPlayerDBHelper(this).updateRanking(Player("Jugador9",5))
        RankingPlayerDBHelper(this).deleteRanking("Jugador9")
        RankingPlayerDBHelper(this).insertRanking(Player("Jugador9",7))
        val players = RankingPlayerDBHelper(this).readAllRankingByQuery()
    }

    fun GrabarRankingSQLite(){
        val jugadores = arrayListOf(
            Player("Santiago.Murillo", 10),
            Player("Jugador2", 6),
            Player("Jugador3", 3),
            Player("Jugador4", 9)
        )
        jugadores.sortByDescending { it.huntedDucks }
        for(jugador in jugadores){
            RankingPlayerDBHelper(this).insertRanking(jugador)
        }
    }

    fun LeerRankingsSQLite(){
        val jugadoresSQLite = RankingPlayerDBHelper(this).readAllRanking()
        val recyclerViewRanking: RecyclerView = findViewById(R.id.recyclerViewRanking)
        recyclerViewRanking.layoutManager = LinearLayoutManager(this)
        recyclerViewRanking.adapter = RankingAdapter(jugadoresSQLite)
        recyclerViewRanking.setHasFixedSize(true)
    }

}