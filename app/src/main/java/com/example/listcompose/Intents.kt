package com.example.listcompose

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openPhone(context: Context, phone: String) {
    if (phone.isNotBlank()) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
        context.startActivity(intent)
    }
}

fun openSite(context: Context, site: String) {
    if (site.isBlank()) return
    var url = site.trim()
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
        url = "https://$url"
    }
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

fun openAddress(context: Context, address: String) {
    if (address.isNotBlank()) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${Uri.encode(address)}"))
        context.startActivity(intent)
    }
}