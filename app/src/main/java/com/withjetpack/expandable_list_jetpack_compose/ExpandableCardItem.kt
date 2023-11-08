package com.withjetpack.expandable_list_jetpack_compose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.withjetpack.expandable_list_jetpack_compose.model.SectionData

@Composable
fun ExpandableCardItem(item: SectionData) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(
                animationSpec = tween(durationMillis = 300)
            )
            .clickable { expanded = !expanded },
        backgroundColor = Color.Green
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp),
                    color=Color.White

                )

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { expanded = !expanded }
                )
            }

            if (expanded) {
                Text(
                    text = item.content,
                    color=Color.White,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
