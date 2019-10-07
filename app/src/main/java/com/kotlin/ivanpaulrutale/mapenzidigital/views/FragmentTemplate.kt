package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.app.Activity
import android.app.LauncherActivity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.ivanpaulrutale.mapenzidigital.R
import com.kotlin.ivanpaulrutale.mapenzidigital.adapter.CustomAdapter
import com.kotlin.ivanpaulrutale.mapenzidigital.models.ListItem

class FragmentTemplate : Fragment() {
    private var page:String? = null

    val customAdapter = CustomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            page = it.getString("page")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_template_layout, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val linearLayoutManager = LinearLayoutManager(activity)

        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = customAdapter

        loadContent(page)

        return view
    }

    private fun loadContent(page: String?) {
        when (page){
            "Home"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("Filming",
                        "Filming in stunning 4K HD/ Full HD with the latest remote controlled drones, " +
                                "we can capture beautiful aerial videos and photos like never before. " +
                                "This is what enables us to capture smooth, cinematic 4K shots. " +
                                "Our system allows clients to watch the footage live, so we can make sure everything we’ve captured is perfect before our camera lands.",
                    "https://mapenzi.ug/wp-content/uploads/2019/07/53532486_791018341268355_708211356599320576_o.jpg"),
                    ListItem("Photography",
                        "Our system can capture stunning high resolution images, with a live view of exactly what’s being captured. " +
                                "We can supply RAW or JPEG images ideal for print based media. " +
                                "We can easily switch between photography and video recording, so feel free to ask.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-1-550x300.jpg"),
                    ListItem("AV Systems and setup",
                        "Our audiovisual hire and event production services puts you a step ahead for any type of live event: " +
                                "Whether you plan a conference, a corporate meeting, " +
                                "an international gathering, a show or a product presentation, we give you professional services to suit your desires on a budget.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/meeting-room-1806702_1280-570x300.jpg"),
                    ListItem("Infographics",
                        "There’s no limit to what you can get designed at Mapenzi Digital. " +
                                "Whether you’re looking for a spectacular new logo or some stunning flyers, " +
                                "our talented team of designers can make it happen.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/32145409_587134394990085_1576106960154001408_n-570x300.jpg")
                )

                reloadAdapter(items,activity as Activity)

            }
            "Videography"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("Our typical production process",
                                "Conceptualisation\n" +
                                "Most projects begin with a sit down to discuss and envisage your outlook. " +
                                        "Every video production is different – some clients know exactly what they want whilst others have a web of ideas that need piecing together. " +
                                        "We’re here to offer ideas and provide advise, right from the start.\n" +
                                "\n" +
                                "The Shoot\n" +
                                "Although the shoot is our favorite part, we won’t rush the planning to get here. " +
                                        "It’s fun, entertaining and allows us as a unit to be creative.\n" +
                                "\n" +
                                "Post-Production\n" +
                                "After backing up and archiving all our footage, we dive in and start the editing process. " +
                                        "We bring the video to life through cuts, transitions, colour tweaks and music." +
                                        "Delivery\n" +
                                        "We pay attention to the finest of details. We must be happy with every millisecond of the video. " +
                                        "Once we are, then you can take a look! we send them via a private web page where our clients can view and download them first.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Reda.jpg"),
                    ListItem("Our Approach",
                        "We are a full-service video production company built on the promise to provide professional and customer-focussed video solutions to our customers. Video is an essential ingredient in forming your corporation’s character and communicating with your audience. From promotional videos to internal marketing videos, product launch videos and live event filming, we have the knowhow to deliver on your expectations and we can create something that will match your brief and engross your audience.\n" +
                                "\n" +
                                "The latest equipment at our disposal\n" +
                                "We have our own in-house studio, " +
                                "sound room and a good deal of our own state of the art equipment and means for transport to reach any venue to deliver in any part of the country. " +
                                "Through our planning process we assess and choose the best equipment to deliver on your tasks.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-2.jpg")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Photography"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("Our Approach",
                        "We work closely with our clients to ensure that we fully understand what they do, how they do it and how we can help them achieve their unique vision.\n" +
                                "\n" +
                                "Ideas\n" +
                                "From your brief at the time of contracting us for the work, the initial element of planning and ideation starts. " +
                                "Our experience means that we can help you build on your vision, no matter how big or small.\n" +
                                "\n" +
                                "Shoot\n" +
                                "We always shoot with a range of HD/4K cameras to create the highest quality work. " +
                                "Through our experience we have also built an incredible collection of techniques to capitalize on the time we have with you and produce extremely professional work." +
                                "Edit\n" +
                                "This is where the magic happens! Perhaps the most important part of our process is the time and attention we dedicate to post-production editing. " +
                                "Our editing software allows us to refine the collective footage into a visually and acoustically compelling story which we are confident will fulfill your vision.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Untitled-1.jpg"),
                    ListItem("All Inclusive",
                        "Whether it’s corporate photography, event photography, family, documentary or lifestyle photography, we can bring out compelling shots that tell the story at first sight." +
                                " We bring your desires and ideas or products to life – from initial concept, through to your final high-quality production. " +
                                "Whatever your budget and deadline, your captivating shots will be readily available for all placements. " +
                                "To find out more about who we’ve worked with, why not have a look at our extensive portfolio",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/d.jpg")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Portfolio"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("Capital Fm",
                        "Capital Boat Cruise. " +
                                "Capital FM is owned and operated by Capital Radio Ltd. " +
                                "The station was started in 1993 31st December as FM radio station broadcasting in English.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/collage.jpg",
                        "https://youtu.be/ynmpdThbVTI"),
                    ListItem("Rotary Club Of Muyenga",
                        "The Rotary Club of Muyenga chartered on the 17th April 1988 with 29 members, " +
                                "and as of 2019 membership that stands at over 120 all committed to a common goal to serve humanity.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/collage-2.jpg",
                        "https://youtu.be/WyGcQsR10Bc"),
                    ListItem("Infinity Computers and Communications Company",
                        "I3C offers a full complement of information technology products and services that include scalable and robust data network strategy planning, " +
                                "deployment and management, voice/data integration.",
                        "https://mapenzi.ug/wp-content/uploads/2019/08/i3c.jpg",
                        "https://youtu.be/sow89utFMEU")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Team"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("Ritah Tamale Musisi-Managing Director",
                        "As Head of Credit and Collection at Airtel Uganda for 19 years, " +
                                "She helped build a strategic and integrated way for corporate Sales collections with a genuine business impact. " +
                                "Rita’s skills of organization, attention to detail and contagious enthusiasm have earned her a good reputation as an events planner.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Rita.jpg"),
                    ListItem("Efe Silva-Senior Creative Director",
                        "Passionate film maker, TV Director, Producer and Script Writer with over 13 years working experience and formally " +
                                "the Dean of Academics at the Africa Film and TV Talent Training Institute in Lagos.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Efe-Silva.jpg"),
                    ListItem("Onyango Raphael Arnold-Digital Media Specialist",
                        "Art Director, multi-disciplined graphic designer and visualizer skilled in 2D and 3D motion graphics and cross platform commercial design and packaging, " +
                                "ranging from broadcast branding to independent films.",
                        "https://mapenzi.ug/wp-content/uploads/2019/08/onyango.jpg"),
                    ListItem("Ouma Cosmas-Cinematographer",
                        "Creative thinker who is an expert in the technical aspect of film photography. Proficient in the operation and placement of photographic equipment. " +
                                "Excellent interpersonal skills allow effective interaction with a variety of people, from directors to crew members to post-production teams.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Ouma.jpg"),
                    ListItem("Benard Muwanguzi-Sound Engineer",
                        "Creative in building concepts for different kind of shoots like music videos, TV adverts and programs, films and plays. " +
                                "Proficient in the operation and placement of sound equipment. " +
                                "Excellent interpersonal skills that allows effective interaction with directors, crew members to the post production team.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Team.jpg"),
                    ListItem("Tumanyane Andrew-Creative Director",
                        "Am a host of experiences and skills available to the filmmaking business in a contemporary environment? " +
                                "I am guided by passion, business ethical values and professional conduct. " +
                                "I pay attention to details and have passion to equip myself with soft and hard skills necessary for now and future performance.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Team-4.jpg"),
                    ListItem("Ojambo Enock James-Director of Photography",
                        "Is a film maker who has devoted his focus to writing for film, camera operation, Editing for movies, documentary films and music videos. " +
                                "However, also very passionate about photography and taking all chances in exploring the adventurous field.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Team-3.jpg"),
                    ListItem("Fiona Tamale Semugooma-Advisor, Sales and Marketing",
                        "Over the past 14 years, I worked with some of Uganda’s leading brands including ; Nile Breweries, British Airways, Umeme, Bank of Africa, DFCU etc. " +
                                "I have used my skills in understanding audiences and what makes them tick, to ensure events really resonate with a client’s brief.",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Fiona-Tamale-Semugooma.jpg")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Contact"->{
                val intent = Intent(this.context,ContactActivity::class.java)
                startActivity(intent)
            }
            "Order" ->{
                val intent = Intent(this.context,OrderActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun reloadAdapter(arraylist:ArrayList<ListItem>,activity:Activity){
        customAdapter.listItems.clear()
        customAdapter.listItems.addAll(arraylist)
        activity?.runOnUiThread{
            customAdapter.notifyDataSetChanged()
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(page: String) =
            FragmentTemplate().apply {
                arguments = Bundle().apply {
                    putString("page", page)
                }
            }
    }
}
