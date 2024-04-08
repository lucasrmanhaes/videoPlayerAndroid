package com.lucas.videoplayer.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

    @Composable
    fun VideoPlayer() {

    val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    val context = LocalContext.current

    val player = ExoPlayer.Builder(context).build()

    val playerView = PlayerView(context)

    val mediaItem = MediaItem.fromUri(videoUrl)

    val playWhenReady by remember { mutableStateOf(true) }

    player.setMediaItem(mediaItem)

    playerView.player = player

    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
    }

    AndroidView(factory = { playerView })

}