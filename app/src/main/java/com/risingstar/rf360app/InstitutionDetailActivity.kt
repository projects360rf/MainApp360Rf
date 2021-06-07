package com.risingstar.rf360app

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.risingstar.rf360app.model.SliderData
import com.smarteist.autoimageslider.SliderView
import java.util.ArrayList

class InstitutionDetailActivity : AppCompatActivity() {

    lateinit var sliderView : SliderView
    lateinit var sliderAdapter: SliderAdapter
    lateinit var txtTitle : TextView
    lateinit var txtTitle2 : TextView
    lateinit var txtDesc : TextView
    lateinit var btnContact : FloatingActionButton
    lateinit var btnJoin : FloatingActionButton
    lateinit var frameInstitution : FrameLayout

    @SuppressLint("SetTextI18n", "InflateParams")
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_institution_detail)

        sliderView = findViewById(R.id.slider)
        txtTitle = findViewById(R.id.txtTitle)
        txtTitle2 = findViewById(R.id.txtTitle2)
        txtDesc = findViewById(R.id.txtDesc)
        btnContact = findViewById(R.id.btnContact)
        btnJoin = findViewById(R.id.btnJoin)
        frameInstitution = findViewById(R.id.frameInstitution)

        val instituition = intent.getStringExtra("Institution")
        val sliderArrayList = ArrayList<SliderData>()

        if (instituition == "First Aid"){
            sliderArrayList.add(SliderData(R.drawable.first_aid_logo))
            sliderArrayList.add(SliderData(R.drawable.first_aid1))
            sliderArrayList.add(SliderData(R.drawable.first_aid2))
            txtTitle.text = "First Aid"
            txtTitle2.text = "The First Aid (FA)"
            txtDesc.text = "is an initiative of 360 Research Foundation for the purpose of providing primary healthcare consultation and First Aid services at village/ward level. The First Aid functions as the primary health center and offers outpatient consultation services with a small pharmacy with general medicines prescribed by the doctor. Apart from this, the First Aid conducts regular health talks and consultation by various specialists with the help of 360 Research Foundation.\n" +
                    "When required, specialist consultations and inpatient services are catered for by designated tertiary care hospitals. It has a team of doctors and healthcare workers from very basic to life saving facilities in the vicinity to take care of the inpatient requirement.\n\n"+
                    "First Aid Health Worker (FAHW)\n" +
                    "A First Aid Health Worker is a Community Health Worker instituted by the 360 Research Foundation’s Department of Health. Once fully implemented, there is to be “A First Aid Health Worker in every village/ward\" in Bihar. FAHW is local individual trained/appointed to act as health educators and promoters in his/her community.\n" +
                    "\n" +
                    "Doctor\n" +
                    "The doctors are the primary care providers. There are different types of doctors in the First Aid. Patient go to them for first-level diagnoses and the treatment. Some doctors are specialists in their field. There is a wide range of specialists that include urologists, neurologists, cardiologists, oncologists, chiropractors, psychologists, dentists, pediatricians, etc\n" +
                    "\n" +
                    "Technologists and Technicians\n" +
                    "Before making a diagnosis, doctors often need more information about what is going on in the patient’s body. To get this information, the doctor may send blood or urine samples to a lab for analysis. The technicians who work in the lab look for all kinds of things in the blood or urine to help the doctor make a diagnosis. These are laboratory technicians. The second set of technicians are radiology technicians. They are the people who take x-rays so a radiologist can evaluate them and make a diagnosis. Pharmacy technicians help pharmacists get prescriptions ready and even help with customers. All these technicians play an important part in the team.\n" +
                    "\n" +
                    "Pharmacist\n" +
                    "Pharmacists are the people who give patients medications that a doctor prescribed for a specific condition. They can also advise patient’s on over-the-counter medication to help with certain conditions. Pharmacists often help doctors understand what types of medicine to prescribe together to avoid serious side effects in the patient. They offer instruction on how to take medication and an answer the questions of the patient\n" +
                    "\n" +
                    "Administrative Staff\n" +
                    "Duties and responsibilities of Administrative staffs include providing administrative support to ensure efficient operation of the office. Supports managers and employees through a variety of tasks related to organization and communication. Responsible for confidential and time sensitive material. Familiar with a variety of the field's concepts, practices and procedures. Ability to effectively communicate via phone and email ensuring that all Administrative Assistant duties are completed accurately and delivered with high quality and in a timely manner. May direct and lead the work of others. Rely on experience and judgment to plan and accomplish goals and a wide degree of creativity and latitude is expected.\n" +
                    "\n"
        }
        if (instituition == "Team A"){
            sliderArrayList.add(SliderData(R.drawable.teama_logo))
            sliderArrayList.add(SliderData(R.drawable.teama1))
            sliderArrayList.add(SliderData(R.drawable.teama2))
            sliderArrayList.add(SliderData(R.drawable.teama3))
            txtTitle.text = "Team A"
            txtTitle2.text = "Team A"
            txtDesc.text = "is a constituent unit of 360 Research Foundation working for women security and empowerment. It is a group of Local Police, Social workers and Volunteers managed by assistance of senior police officers. The Team visits every school, coaching, market and every sensitive place to protect and aware girls and women from the social evils.\n"
        }
        if (instituition == "360 rig"){
            sliderArrayList.add(SliderData(R.drawable.rig_logo))
            sliderArrayList.add(SliderData(R.drawable.rig1))
            sliderArrayList.add(SliderData(R.drawable.rig2))
            sliderArrayList.add(SliderData(R.drawable.rig3))
            txtTitle.text = "360 RIG"
            txtTitle2.text = "360 Research and Innovation Group (360RIG)"
            txtDesc.text = "is the constituent unit of 360 Research Foundation, working in the field of Scientific Research and Innovation. It was established on 13 December 2015. 360 RIG collaborate with exceptional researchers, innovators, entrepreneurs, users, communities to co-create knowledge and solution for a wide range of social needs, and also scouts, supports and spawns grassroots innovations developed by individuals and local communities in technological field, helping in human survival. 360RIG helps innovators and outstanding traditional knowledge holders get due recognition, respect and reward for their innovations. It also tries to ensure that such innovations diffuse widely through commercial and/or non-commercial channels, generating material or non-material incentives for them and others involved in the value chain. These socially-relevant solutions help us, our communities and our nation.\n\n" +
                    "360 RIG since inception has been an inclusive programme where children irrespective of gender, language social and geographical background have been participating.\n" +
                    "\n" +
                    "1. Language: They can use any scheduled language for communication. However, special attention will be given to the children who would be communicating through sign language or if necessary the escort can facilitate the interpretation.\n" +
                    "2. Presentation: The children with disability are allowed to present their projects through oral presentation along with a written project report, similar to the children under normal category. So, some of the visually impaired children will prepare their written reports in Braille, and in that case during oral presentation that child will be provided with the help of an aide / assistant. In all other cases normal existing procedure will be followed.\n" +
                    "3. Time: The maximum time allotted for oral presentation is 10 minutes but for the children with disability that might be relaxed. Depending upon the number of projects the time allocation will be decided and notified.\n" +
                    "4. Evaluation: At least one of the evaluators must be a special educator, who understands the needs and limitations of these children. Other members of the evaluation team in the room should also be compassionate and empathetic to the presenters."
        }
        if (instituition == "Kraft Lady"){
            sliderArrayList.add(SliderData(R.drawable.kraft_lady_logo))
            sliderArrayList.add(SliderData(R.drawable.the_kraft_ladies1))
            txtTitle.text = "The Kraft Lady"
            txtTitle2.text = "The Kraft Ladies"
            txtDesc.text = "is the constituent unit of 360 Research Foundation working in the field of women empowerment. The Group of ladies, proving the “typical” society that crafts are not just for time-pass, they are taking crafts to a financial level.\n" +
                    "\n" +
                    "Buy one of the best crafts in India at most affordable prices. The Kraft Ladies sells homemade crafts. We always have ready stock for crafts like stamping, scrapbooking, card making, Punchcraft, Quilling, Sospeso Transparent, Clay Art, Mixed Media, Decoupage, Altered Art, 3D boxes, Shadow boxes, Miniature Set up, Collage Clay Art, DIY things, Jewellary Making etc. We also welcome pre orders for any brand or any craft supplies at any point of time."
        }
        if (instituition == "Life Savers"){
            sliderArrayList.add(SliderData(R.drawable.life_savers_logo))
            sliderArrayList.add(SliderData(R.drawable.life_savers1))
            txtTitle.text = "The Life Savers"
            txtTitle2.text = "The Life Savers (TLS)"
            txtDesc.text = "is an initiative supported by 360 Research Foundation to save the lives by donating blood directly to the needy people. The Life Savers donates blood not to store/ sell; all have a plan to help needy people who cannot buy the blood from other sources. The Life savers is a group of people ready to donate blood, generally we have members from all blood groups.\n" +
                    "\n" +
                    "Note: Team member(s) are ready to donate their blood without any force, no one has right to pressure them to donate. It depends on their physical and mental situation(s).\n"

        }
        if (instituition == "MEC"){
            sliderArrayList.add(SliderData(R.drawable.mec_logo))
            sliderArrayList.add(SliderData(R.drawable.rf_logo))
            txtTitle.text = "Master English Classes (MEC)"
            txtTitle2.text = "Master English Classes (MEC)"
            txtDesc.text = "is the constituent unit of 360 Research Foundation. This is a charitable organization working with an aim to bring solace to the needy. MEC works for the betterment of women and children. Free coaching classes provided by us have helped students to gain confidence in facing exams and society.\n" +
                    "\n" +
                    "The Master English Classes aims to empower the communities, which are relatively disadvantaged section of society, by assisting them as well as those institutions working for them, towards enhancing their skills and capabilities to make them employable in industries, services and business sectors in addition to the government sector. It has the built-in resilience to adapt itself to the market dynamics on a continuous basis so that the target groups are not deprived of the professional acumen demanded by the changing/emerging market needs and opportunities for employment at domestic as well as international."
        }
        if (instituition == "Gurukul"){
            sliderArrayList.add(SliderData(R.drawable.gurukul_logo))
            sliderArrayList.add(SliderData(R.drawable.gurukul1))
            sliderArrayList.add(SliderData(R.drawable.gurukul2))
            sliderArrayList.add(SliderData(R.drawable.gurukul3))
            txtTitle.text = "Gurukul Coaching Center"
            txtTitle2.text = "Gurukul Coaching Center"
            txtDesc.text = "is an innovative initiative of 360 Research Foundation to educate those children who have left behind in this very competitive era. India has the second largest education system in the world. The scale of operation involved to ensure the quality of Education for India is unique and challenging because in a rural part of India teacher have to face many difficulties to teach. This is why Gurukul Coaching Center was established to promote rural education.\n\n"+
                    "More than half of the population of the country lives in villages and the crucial motivating factor for the development is Education. The path involves active guidance by a master teacher, including giving students practice facing real problems, testing solutions, making mistakes, seeking help, and refining approaches. Comprehensive dialogues between teachers and students delineate how reflection-in-action works, what boost it, and behaviour or attitudes that can avert the development of reflectiveness."
        }

        sliderAdapter = SliderAdapter(this,sliderArrayList)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()

        btnJoin.setOnClickListener {
            val joinUsFragment = JoinUsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frameInstitution,joinUsFragment).commit()
            supportActionBar?.title = "Join Us"

        }

        btnContact.setOnClickListener {
            val dialog = Dialog(this@InstitutionDetailActivity)
            dialog.setContentView(R.layout.contact_dialog)
            val txtContactName : TextView = dialog.findViewById(R.id.txtContactName)
            val txtContactPosition : TextView = dialog.findViewById(R.id.txtContactPosition)
            val txtContactNumber : TextView = dialog.findViewById(R.id.txtContactNumber)
            val imgHead : ImageView = dialog.findViewById(R.id.imgHead)

            if(instituition == "First Aid"){
                txtContactName.text = "Uddipta Das"
                txtContactPosition.text = "Director, FA"
                txtContactNumber.text = " "
                imgHead.setImageResource(R.drawable.fa_director)
            }
            if(instituition == "Team A"){
                txtContactName.text = "Director Name"
                txtContactPosition.text = "Director, Team A"
                txtContactNumber.text = "9471040714"
            }
            if(instituition == "360 rig"){
                txtContactName.text = "Dr. Prabhat Niraj"
                txtContactPosition.text = "Director, 360 rig"
                txtContactNumber.text = " "
                imgHead.setImageResource(R.drawable.rig_head)
            }
            if(instituition == "Kraft Lady"){
                txtContactName.text = "Head Name"
                txtContactPosition.text = "Head,TKL"
                txtContactNumber.text = "9471040714"
            }
            if(instituition == "Life Savers"){
                txtContactName.text = "Lavkush Kumar"
                txtContactPosition.text = "Director, TLS"
                txtContactNumber.text = "9122820407"
                imgHead.setImageResource(R.drawable.tls_director)
            }
            if(instituition == "MEC"){
                txtContactName.text = "Director Name"
                txtContactPosition.text = "Director, MEC"
                txtContactNumber.text = "9471040714"
            }
            if(instituition == "Gurukul"){
                txtContactName.text = "Director Name"
                txtContactPosition.text = "Director, Gurukul"
                txtContactNumber.text = "9471040714"
            }

            txtContactNumber.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:${txtContactNumber.text}")
                dialog.dismiss()
                startActivity(intent)
            }

            dialog.show()


        }


    }
}
