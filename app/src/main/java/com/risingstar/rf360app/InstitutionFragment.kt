package com.risingstar.rf360app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView


class InstitutionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_institution, container, false)

        val cvFirstAid : CardView = view.findViewById(R.id.cvFirstAid)
        val cvTeamA : CardView = view.findViewById(R.id.cvTeamA)
        val cv360rig : CardView = view.findViewById(R.id.cv360rig)
        val cvKraftLady : CardView = view.findViewById(R.id.cvKraftLady)
        val cvLifeSavers : CardView = view.findViewById(R.id.cvLifeSavers)
        val cvMEC : CardView = view.findViewById(R.id.cvMEC)
        val cvGurukul : CardView = view.findViewById(R.id.cvGurukul)

        val intent = Intent(activity as Context,InstitutionDetailActivity :: class.java)
        cvFirstAid.setOnClickListener {
            intent.putExtra("Institution","First Aid")
            startActivity(intent)
        }
        cvTeamA.setOnClickListener {
            intent.putExtra("Institution","Team A")
            startActivity(intent)
        }
        cv360rig.setOnClickListener {
            intent.putExtra("Institution","360 rig")
            startActivity(intent)
        }
        cvKraftLady.setOnClickListener {
            intent.putExtra("Institution","Kraft Lady")
            startActivity(intent)
        }
        cvLifeSavers.setOnClickListener {
            intent.putExtra("Institution","Life Savers")
            startActivity(intent)
        }
        cvMEC.setOnClickListener {
            intent.putExtra("Institution","MEC")
            startActivity(intent)
        }
        cvGurukul.setOnClickListener {
            intent.putExtra("Institution","Gurukul")
            startActivity(intent)
        }


        return view
    }

}