package com.Ounzy.OpenBl.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.Ounzy.OpenBl.ui.components.Tables.rewriteIconUrl

@Composable
fun RewrittenImage(
    modifier: Modifier = Modifier,
    url: String
) {
    val realUrl = rewriteIconUrl(url)

    if (realUrl.endsWith(".svg")) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(realUrl)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = null,
            modifier = modifier,
        )
    } else {
        AsyncImage(
            model = realUrl,
            null,
            modifier = modifier
        )
    }
}