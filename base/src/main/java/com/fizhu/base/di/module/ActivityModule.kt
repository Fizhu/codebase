package com.kazee.waktoo.di.module

import android.app.Activity
import com.fizhu.base.ui.activity.home.HomeContract
import com.fizhu.base.ui.activity.home.HomePresenter
import com.fizhu.base.ui.activity.splash.SplashContract
import com.fizhu.base.ui.activity.splash.SplashPresenter
import com.fizhu.base.ui.activity.timeline.TimelineContract
import com.fizhu.base.ui.activity.timeline.TimelinePresenter
import com.kazee.waktoo.di.scope.PreActivity
import dagger.Module
import dagger.Provides

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @PreActivity
    fun provideSplashPresenter(): SplashContract.Presenter = SplashPresenter()

    @Provides
    fun provideHomePresenter(): HomeContract.Presenter = HomePresenter()

    @Provides
    fun provideTimelinePresenter(): TimelineContract.Presenter = TimelinePresenter()


//    @Provides
//    fun provideBroadcastReceiver(): BroadcastReceiver =
//        object : BroadcastReceiver() {
//            override fun onReceive(context: Context, intent: Intent) {
//                // checking for type intent filter
//                if (intent.action == AppConstants.REGISTRATION_COMPLETE) {
//                    // gcm successfully registered
//                    // now subscribe to `global` topic to receive app wide notifications
//                    FirebaseMessaging.getInstance().subscribeToTopic(AppConstants.TOPIC_GLOBAL)
//
//                } else if (intent.action == AppConstants.PUSH_NOTIFICATION) {
//                    // new push notification is received
//                    val message = intent.getStringExtra("message")
//                    val title = intent.getStringExtra("title")
//                    val notificationUtils = NotificationUtils(context)
//                    notificationUtils.showNotificationMessage(title, message, "", intent)
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                        // Create channel to show notifications.
//                        val channelId =
//                            BaseApp.context!!.getString(R.string.default_notification_channel_id)
//                        val channelName =
//                            BaseApp.context!!.getString(R.string.default_notification_channel_name)
//                        val notificationManager =
//                            getSystemService(BaseApp.context!!, NotificationManager::class.java)
//                        notificationManager!!.createNotificationChannel(
//                            NotificationChannel(
//                                channelId,
//                                channelName, NotificationManager.IMPORTANCE_LOW
//                            )
//                        )
//                    }
//                    Toast.makeText(
//                        BaseApp.context,
//                        "Push notification: $message",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            }
//        }

//    @Provides
//    fun provideMyReceiver(): MyReceiver = MyReceiver()
//
//    @Provides
//    fun provideAppUpdater(): AppUpdater =
//        AppUpdater(BaseApp.context).setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
}