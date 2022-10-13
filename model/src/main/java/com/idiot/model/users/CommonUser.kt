package com.idiot.model.users

import com.idiot.model.PreferEstate
import com.idiot.model.TenantEstate

data class CommonUser(
    val birthday: String,
    val phone: String,
    val name: String,
    val email: String,
    val borough: String,
    val authProvider: String,
    val transactionType: String,
    val estateType: String,
    val role: String,
    val tenantEstate: TenantEstate,
    val ownEstate: TenantEstate,
    val dipEstate: List<PreferEstate>,
    val broker: Boolean
)
