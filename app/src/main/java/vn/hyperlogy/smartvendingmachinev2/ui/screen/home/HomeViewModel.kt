package vn.hyperlogy.smartvendingmachinev2.ui.screen.home

import android.app.Application
import android.provider.SyncStateContract.Constants
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import vn.hyperlogy.smartvendingmachinev2.helpers.readJsonFromAssets
import vn.hyperlogy.smartvendingmachinev2.model.Product
import vn.hyperlogy.smartvendingmachinev2.model.ProductMapItem
import java.util.LinkedList

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "HomeViewModel"
    val productList = MutableStateFlow<List< ProductMapItem>>(emptyList())
    val isModalOpen = MutableStateFlow(false)
    val cartList = MutableStateFlow(LinkedList<Product>())


    fun loadProducts() {
        val json = readJsonFromAssets(getApplication(), "ProductMap.json")
        val gson = Gson()
        val type = object :TypeToken<List<ProductMapItem>>() {}.type
        productList.value = gson.fromJson( json , type)
    }

    fun setOpenModal(isOpen: Boolean) {
        isModalOpen.value = isOpen
    }


}