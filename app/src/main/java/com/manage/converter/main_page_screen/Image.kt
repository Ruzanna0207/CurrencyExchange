package com.manage.converter.main_page_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.manage.converter.core.consts.STORAGE.EMPTY

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Image(url: String) {
    GlideImage(
        model = url,
        contentDescription = EMPTY,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}