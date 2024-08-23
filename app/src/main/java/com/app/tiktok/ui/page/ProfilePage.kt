package com.app.tiktok.ui.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.tiktok.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfilScreen(modifier: Modifier) {
    Column(
        Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        TopAppBar(name = "Aryo Wibisono")
        Spacer(modifier = Modifier.height(15.dp))
        PhotoUser(imageUser = painterResource(id = R.drawable.aryo_fix), "@aryo_dedeo")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            informasiSection(count = "16", text = "Mengikuti")
            informasiSection(count = "899,20k", text = "Pengikut")
            informasiSection(count = "200M", text = "Suka")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth() // Make the Row take up the full width of the screen
                .padding(end = 5.dp),
            horizontalArrangement = Arrangement.Center, // Center the content horizontally
            verticalAlignment = Alignment.CenterVertically // Align the content vertically in the center
        ) {
            ButtonFollow(initialColor = Color.Red)
            Spacer(modifier = Modifier.width(8.dp)) // Optional: add some space between buttons
            ButtonTT()
            Spacer(modifier = Modifier.width(8.dp)) // Optional: add some space between buttons
            ButtonDropDown()
        }
        Spacer(modifier = Modifier.height(5.dp))
        BioSection(
            bio = "Hallo nama saya aryo\n" +
                    "ini cuma akun gabut hehe"
        )
        Spacer(modifier = Modifier.height(5.dp))
        TabLayout()


    }
}

@Composable
fun TopAppBar(name: String) {
    val fontStyle = FontFamily.SansSerif
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back"
        )
        Box(modifier = Modifier.background(Color.Transparent))
        Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp, fontFamily = fontStyle)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "notif"
            )
            Spacer(
                modifier = Modifier
                    .width(15.dp)
                    .height(5.dp)
            )
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "share"
            )
        }
    }
}

@Composable
fun PhotoUser(imageUser: Painter, username: String) {
    val fontStyle = FontFamily.SansSerif
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imageUser,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(130.dp)
                .border(1.dp, Color.Transparent)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = username,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontStyle
        )
    }
}

@Composable
fun informasiSection(count: String, text: String) {
    val fontStyle = FontFamily.SansSerif
    Row(
        modifier = Modifier.padding(end = 25.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = count,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = fontStyle
            )
            Text(
                text = text,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = fontStyle
            )
        }
    }
}

@Composable
fun ButtonFollow(initialColor: Color) {
    val fontStyle = FontFamily.SansSerif
    var colorState by remember { mutableStateOf(initialColor) }
    var text by remember { mutableStateOf("Follow") }
    var textColor by remember { mutableStateOf(Color.White) }
    Button(
        onClick = {
            colorState = Color.LightGray
            text = " Followed"
            textColor = Color.Black
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorState
        ), modifier = Modifier
            .padding(5.dp)
            .height(45.dp)
    ) {
        Text(text = text, color = textColor, fontFamily = fontStyle)
    }
}

@Composable
fun ButtonTT() {
    val fontStyle = FontFamily.SansSerif
    var text by remember { mutableStateOf("Message") }

    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray
        ), modifier = Modifier
            .padding(5.dp)
            .height(45.dp)
    ) {
        Text(text = text, color = Color.Black, fontFamily = fontStyle)
    }
}

@Composable
fun ButtonDropDown() {
    Button(
        onClick = { }, Modifier.width(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray
        ),
    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = null,
            tint = Color.Black,
        )
    }
}

@Composable
fun BioSection(bio: String) {
    val fontStyle = FontFamily.SansSerif
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = bio,
            fontWeight = FontWeight.Normal,
            fontFamily = fontStyle,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val pagerState = rememberPagerState(pageCount = 2)
    Tabs(pagerState)
    TabsContent(pagerState)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {
    val listTabs = listOf(
        "beranda" to Icons.Default.List,
        "repost" to Icons.Default.Refresh
    )

    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.Black,
            )
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Black
    ) {
        listTabs.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                // on below line we are specifying icon
                // for each tab item and we are calling
                // image from the list which we have created.
                icon = {
                    Icon(imageVector = listTabs[index].second, contentDescription = null)
                },
                // on below line we are specifying the text for
                // the each tab item and we are calling data
                // from the list which we have created.
                text = {
                    Text(
                        listTabs[index].first,
                        // on below line we are specifying the text color
                        // for the text in that tab
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                // on below line we are specifying
                // the tab which is selected.
                selected = pagerState.currentPage == index,
                // on below line we are specifying the
                // on click for the tab which is selected.
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            // on below line we are calling tab content screen
            // and specifying data as Home Screen.
            0 -> {
                OnPost(
                    imageList = listOf(
                        painterResource(id = R.drawable.aryo_fix),
                        painterResource(id = R.drawable.arr_1),
                        painterResource(id = R.drawable.arr_2),
                        painterResource(id = R.drawable.arr_3),
                        painterResource(id = R.drawable.arr_4),
                        painterResource(id = R.drawable.mel_1),
                        painterResource(id = R.drawable.mel_2),
                        painterResource(id = R.drawable.arr_3),
                        painterResource(id = R.drawable.arr_4),
                        painterResource(id = R.drawable.mel_1),
                        painterResource(id = R.drawable.mel_2),
                        painterResource(id = R.drawable.arr_1),
                    )
                )
            }
            // on below line we are calling tab content screen
            // and specifying data as Shopping Screen.
            1 -> TabContentScreen(data = "No repost yet")
        }
    }
}

// on below line we are creating a Tab Content
// Screen for displaying a simple text message.
@Composable
fun TabContentScreen(data: String) {
    // on below line we are creating a column
    Column(
        // in this column we are specifying modifier
        // and aligning it center of the screen on below lines.
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // in this column we are specifying the text
        Text(
            // on below line we are specifying the text message
            text = data,

            // on below line we are specifying the font weight
            fontWeight = FontWeight.Bold,

            //on below line we are specifying the text alignment.
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OnPost(imageList: List<Painter>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.scale(1.01f)
    ) {
        items(imageList.size) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = imageList[it],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 0.5.dp, color = Color.White)
                        .padding(top = 1.dp)
                        .height(230.dp)
                )
                Row(Modifier.padding(top = 200.dp)) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "viewCount",
                        tint = Color.White
                    )
                    Text(
                        text = "1,2 jt",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }

        }
    }
}