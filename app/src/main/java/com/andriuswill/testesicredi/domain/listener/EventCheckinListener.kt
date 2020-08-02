package com.andriuswill.testesicredi.domain.listener

import com.andriuswill.testesicredi.data.models.People

interface EventCheckinListener {
    fun onCheckin(people: People)
}