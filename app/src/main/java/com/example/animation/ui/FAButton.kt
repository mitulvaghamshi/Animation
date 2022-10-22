/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.animation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animation.R

/**
 * Shows the floating action button.
 *
 * @param extended Whether the tab should be shown in its expanded state.
 */
// AnimatedVisibility is currently an experimental API in Compose Animation.
@Composable
fun FAButton(extended: Boolean, onClick: () -> Unit) {
    // Use `FloatingActionButton` rather than `ExtendedFloatingActionButton` for full control on
    // how it should animate.
    FloatingActionButton(onClick) {
        Row(Modifier.padding(horizontal = if (extended) 20.dp else 16.dp)) {
            Icon(Icons.Default.Edit, null)
            // Toggle the visibility of the content with animation.
            AnimatedVisibility(extended) {
                Text(
                    stringResource(R.string.edit),
                    Modifier.padding(start = 10.dp, top = 3.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewFAButton() = Surface {
    Column(Modifier.padding(10.dp)) {
        FAButton(extended = false) {}
        Spacer(modifier = Modifier.height(10.dp))
        FAButton(extended = true) {}
    }
}
