package com.luteh.mangareader.common.base


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kazee.waktoo.common.base.BaseActivity
import com.kazee.waktoo.di.component.DaggerFragmentComponent
import com.kazee.waktoo.di.component.FragmentComponent
import com.kazee.waktoo.di.module.FragmentModule
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
abstract class BaseFragment : Fragment(), BaseContract.View {

    protected lateinit var fragmentComponent: FragmentComponent
    protected val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    @Suppress("DEPRECATION")
    private fun injectDependency() {
        fragmentComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit()
    }

    val baseActivity: BaseActivity
        get() = activity as BaseActivity

    override val rootView: View
        get() = baseActivity.rootView

    override fun onError(message: String) {
        baseActivity.onError(message)
    }

    override fun showWarningAlert(message: String) {
        baseActivity.showWarningAlert(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.clear()
    }

    abstract fun onInit()
}