package com.upwellsurf.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.upwellsurf.R
import com.upwellsurf.models.LiveReportModel
import org.w3c.dom.Text
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CalendarAdapter(
    private val context: Context,
    private val data: ArrayList<LiveReportModel>,
    private val currentDate: Calendar,
    private val changeMonth: Calendar?
) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    private var mListener: OnItemClickListener? = null
    private var index = -1

    // This is true only the first time you load the calendar.
    private var selectCurrentDate = true
    private val currentMonth = currentDate[Calendar.MONTH]
    private val currentYear = currentDate[Calendar.YEAR]
    private val currentDay = currentDate[Calendar.DAY_OF_MONTH]

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(
            inflater.inflate(R.layout.custom_calendar_day, parent, false),
            mListener!!
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val liveDate = data[position]
        val sdf = SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH)
        val cal = Calendar.getInstance()
        cal.time=sdf.parse(liveDate.data)

        val displayMonth = cal[Calendar.MONTH]
        val displayYear = cal[Calendar.YEAR]
        val displayDay = cal[Calendar.DAY_OF_MONTH]


        var dateString =
            "$displayDay/$displayMonth/$displayYear"
        holder.txtDayInWeek.text = dateString
// check if boolean property "extend" is true or false
        // if it is true make the "extendedView" Visible
       // holder.expanded_view.visibility = if (liveDate.expand) View.VISIBLE else View.GONE
        // on Click of the item take parent card view in our case
        // revert the boolean "expand"
        holder.linearLayout.setOnClickListener {
            liveDate.expand = !liveDate.expand
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(itemView: View, val listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var txtDayInWeek = itemView.findViewById<TextView>(R.id.txt_day)
        var linearLayout = itemView.findViewById<LinearLayout>(R.id.calendar_linear_layout)
       // var expanded_view = itemView.findViewById<LinearLayout>(R.id.expanded_view)
    }

    /**
     * OnClickListener.
     */
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }
}