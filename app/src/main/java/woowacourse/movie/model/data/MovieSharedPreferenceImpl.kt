package woowacourse.movie.model.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object MovieSharedPreferenceImpl : MovieSharedPreference {
    private const val PREFERENCE_KEY = "settings"
    private var sharedPreferences: SharedPreferences? = null

    override fun setAlarmChecked(isChecked: Boolean) {
        sharedPreferences?.edit {
            putBoolean(PREFERENCE_KEY, isChecked)
            apply()
        }
    }

    override fun getAlarmChecked(): Boolean {
        return sharedPreferences?.getBoolean(PREFERENCE_KEY, false) ?: false
    }

    fun initialize(context: Context) {
        if (sharedPreferences == null) {
            sharedPreferences =
                context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
                    ?: throw IllegalStateException()
        }
    }
}
