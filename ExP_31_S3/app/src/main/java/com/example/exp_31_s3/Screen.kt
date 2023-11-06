package com.example.exp_31_s3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun PreviewItem(navController: NavController) {
    val categoryList = getcategorylist(navController)
    LazyColumn(content = {
        items(categoryList) { item ->
            Category(img1 = item.img1, name = item.name, phoneno = item.phoneno, img2 = item.img2, navController = navController)
        }
    })
}

@Composable
fun Category(img1: Int, name: String, phoneno: String, img2: Int, navController: NavController) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img1),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(name, phoneno)
            Image(
                painter = painterResource(id = img2),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .clickable { navController.navigate("message/$name") } // Pass the sender's name
                    .weight(.2f)
            )

        }
    }
}


@Composable
fun ItemDescription(name: String, phoneno: String) {
    Column(modifier = Modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = phoneno,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Thin
        )
    }
}


data class Category1(val img1: Int,val name: String,val phoneno: String,val img2: Int,val navController: NavController)

fun getcategorylist(navController:NavController): MutableList<Category1> {
    val list= mutableListOf<Category1>()

    list.add(Category1(R.drawable.user,"Employer 1","+91 9346207593",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 2","+91 7639254023",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 3","+91 9874510482",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 4","+91 8465903254",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 5","+91 6583137410",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 1","+91 9346207593",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 2","+91 7639254023",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 3","+91 9874510482",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 4","+91 8465903254",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 5","+91 6583137410",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 1","+91 9346207593",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 2","+91 7639254023",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 3","+91 9874510482",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 4","+91 8465903254",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 5","+91 6583137410",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 1","+91 9346207593",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 2","+91 7639254023",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 3","+91 9874510482",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 4","+91 8465903254",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 5","+91 6583137410",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 1","+91 9346207593",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 2","+91 7639254023",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 3","+91 9874510482",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 4","+91 8465903254",R.drawable.message_icon, navController ))
    list.add(Category1(R.drawable.user,"Employer 5","+91 6583137410",R.drawable.message_icon, navController ))

    return list
}