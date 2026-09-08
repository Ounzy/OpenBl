package com.Ounzy.OpenBl.Bundesliga.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.Ounzy.OpenBl.utils.USER_AGENT

@Composable
fun ClubImage(
    modifier: Modifier = Modifier,
    url: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            // required for Wikipedia images
            .setHeader("User-Agent", USER_AGENT)
            // SVG support
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = null,
        modifier = modifier,
    )
}