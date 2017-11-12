package ru.annin.penzgtulesson04.ui.fragment

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import kotlinx.android.synthetic.main.fragment_relaxy.view.*
import ru.annin.penzgtulesson04.R

/**
 * Экран "Релакс".
 *
 * @author Pavel Annin.
 */
class RelaxFragment : Fragment() {

    companion object {
        const val TAG = "RelaxFragment"
        @JvmStatic fun newInstance() = RelaxFragment()
    }

    // Component's
    private lateinit var viewDelegate: ViewDelegate

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_relaxy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDelegate = ViewDelegate(view as ViewGroup).apply {
            onChangeClick = { openColorPickerAlert() }
        }
    }

    private fun openColorPickerAlert() {
        ColorPickerDialogBuilder.with(context)
                .setTitle(R.string.relax_picker_title)
                .noSliders()
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .setPositiveButton(R.string.relax_picker_action_positive,
                        { _: DialogInterface, color: Int, _: Array<Int> -> viewDelegate.update(color)})
                .build()
                .show()
    }

    private class ViewDelegate(private val vRoot: ViewGroup) {

        // View's
        private val btnChange by lazy { vRoot.findViewById<Button>(R.id.btn_change) }

        // Listener's
        var onChangeClick: (() -> Unit)? = null

        init {
            btnChange.setOnClickListener{ onChangeClick?.invoke() }
        }

        fun update(@ColorInt newColor: Int) {
            val transition = TransitionDrawable(arrayOf(
                    vRoot.background ?: Color.WHITE.toDrawable(), newColor.toDrawable()))
            vRoot.background = transition
            transition.startTransition(500)
        }

        private fun Int.toDrawable() = ColorDrawable(this)
    }
}