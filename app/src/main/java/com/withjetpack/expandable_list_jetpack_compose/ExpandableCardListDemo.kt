package com.withjetpack.expandable_list_jetpack_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import com.withjetpack.expandable_list_jetpack_compose.model.SectionData

@Composable
fun ExpandableCardListDemo() {
    var searchQuery by remember { mutableStateOf("") }
    val items = listOf(
        SectionData("A", "Apple"),
        SectionData("B", "Ball"),
        SectionData("C", "Cat"),
        SectionData("D", "Dog"),
        SectionData("E", "Eagle")
    )

    Column {
        ExpandableCardList(items = items)
    }
}

@Composable
fun ExpandableCardList(items: List<SectionData>) {
    LazyColumn {
        items(items) { item ->
            ExpandableCardItem(item)
        }
    }
}