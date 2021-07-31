package com.example.mgdh_kotlin.Repo

import com.example.mgdh_kotlin.Network.Network

class MyRepository constructor(private val network:Network) {
    val token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjcyIiwidXNlcl90eXBlIjoiMiIsImRpc3BsYXlfbmFtZSI6IkFuc2h1bCBTaHJlc3RoIiwiY3BfY29kZSI6IjEwMDM1IiwiZW1haWwiOiJhZGRAZy5jb20iLCJ0aW1lIjoxNjI1ODE4NTQ3fQ.IB2gc_eNoKxDZOIrvYZV3n6S2Ozv_1mvTjcfCn_4Mjo"

    fun getallpartner()=network.getpartnerlist(token)

}