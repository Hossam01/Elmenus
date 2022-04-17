package com.example.elmenus.data.repository

import com.example.elmenus.data.remote.webservice.WebService
import com.example.elmenus.domain.repositry.DataRepo
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val webService: WebService
) : DataRepo {

}