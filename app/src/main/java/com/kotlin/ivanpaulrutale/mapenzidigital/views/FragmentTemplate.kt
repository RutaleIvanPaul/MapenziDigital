package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.app.Activity
import android.app.LauncherActivity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
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

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = customAdapter

        loadContent(page)

        return view
    }

    private fun loadContent(page: String?) {
        when (page){
            "Home"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("This",
                        "Description Description Description",
                    "https://mapenzi.ug/wp-content/uploads/2019/07/53532486_791018341268355_708211356599320576_o.jpg"),
                    ListItem("Is",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-1-550x300.jpg"),
                    ListItem("Home",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/32145409_587134394990085_1576106960154001408_n-570x300.jpg")
                )

                reloadAdapter(items,activity as Activity)

            }
            "Videography"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("This",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/53532486_791018341268355_708211356599320576_o.jpg"),
                    ListItem("Is",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-1-550x300.jpg"),
                    ListItem("Videography",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/32145409_587134394990085_1576106960154001408_n-570x300.jpg")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Photography"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("This",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/53532486_791018341268355_708211356599320576_o.jpg"),
                    ListItem("Is",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-1-550x300.jpg"),
                    ListItem("Photography",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/32145409_587134394990085_1576106960154001408_n-570x300.jpg")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Portfolio"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("This",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/53532486_791018341268355_708211356599320576_o.jpg"),
                    ListItem("Is",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-1-550x300.jpg"),
                    ListItem("Portfolio",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/32145409_587134394990085_1576106960154001408_n-570x300.jpg")
                )


                reloadAdapter(items,activity as Activity)

            }
            "Team"->{
                val items :ArrayList<ListItem> = arrayListOf(
                    ListItem("This",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/53532486_791018341268355_708211356599320576_o.jpg"),
                    ListItem("Is",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/Photography-1-550x300.jpg"),
                    ListItem("Team",
                        "Description Description Description",
                        "https://mapenzi.ug/wp-content/uploads/2019/07/32145409_587134394990085_1576106960154001408_n-570x300.jpg")
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
